package com.example.studentCouncil.Services;
import com.example.studentCouncil.Controller.Api.RoleApi;
import com.example.studentCouncil.Dto.*;
import com.example.studentCouncil.Model.Consultant;
import com.example.studentCouncil.Model.Role;
import com.example.studentCouncil.Model.User;
import com.example.studentCouncil.Repository.RoleRepository;
import com.example.studentCouncil.Repository.UserRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
@Service
@Data
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private UserReqDto userReqDto;
    private RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;
    @Autowired
    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, JwtService jwtService, ModelMapper modelMapper, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.jwtService=jwtService;
        this.roleRepository = roleRepository;
    }
    public List<User> getUser(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        UserRespondDto userRespondDto = null;
        List list = new ArrayList();
        for (User usr : userRepository.findAll(pageable)) {
        userRespondDto = modelMapper.map(usr,UserRespondDto.class);
            list.add(userRespondDto);
        }
        return list;
    }
    public ResponseEntity<?> addUser (UserReqDto userReqDto) {
        Optional<Role> r = roleRepository.findById(userReqDto.getRoleId());
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        if (r.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role with id" + " " + userReqDto.getRoleId() + " " + "doesn't exist");
        }
        User users = modelMapper.map(userReqDto, User.class);
        String encPsd = this.passwordEncoder.encode(userReqDto.getPassword());
        Role role = r.get();
        users.setRole(role);
        users.setPassword(encPsd);
        userRepository.save(users);

        userReqDto.setRoleName(userRepository.findRoleByName(userReqDto.getEmail()));

        Map<String, Object> response = new HashMap<>();
        response.put("userid",userRepository.findUserIdByEmail(userReqDto.getEmail()));
        response.put("role", userRepository.findRoleByName(userReqDto.getEmail()));
        var jwtToken = jwtService.generateToken(users);
        return new ResponseEntity<>(response, HttpStatus.OK);
//        return AuthResponse.builder().token(jwtToken).build();
    }
    public UserRespondDto getUserById(Long userID){
        Optional<User> u = userRepository.findById(userID);
        if(!u.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,userID+"  "+"doesn't exist");
        }
        return modelMapper.map(u.get(), UserRespondDto.class);
    }


    public ResponseEntity editUser(Long userId, UserReqDto us) throws ResponseStatusException {
        Optional<User> p = userRepository.findById(userId);
        if(p.isPresent()){
            User user  = modelMapper.map(us,User.class);
            user.setUserID(userId);
            userRepository.save(user);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"");
        }

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
    public ResponseEntity deleteUser(Long userId){
        userRepository.deleteById(userId);

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }

    public ResponseEntity<?> doLogin(LogInDto loginDto){
        String rawPassword = loginDto.getPassword();
        String encodedPassword = userRepository.findPasswordByEmail(loginDto.getEmail());
        AuthResponse authenticationResponse = null;

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean passwordMatches = encoder.matches(rawPassword, encodedPassword);
        Optional<User> u = userRepository.findByEmail(loginDto.getEmail());


        User users = modelMapper.map(loginDto, User.class);
        authenticationResponse = modelMapper.map(users,AuthResponse.class);

        var jwtToken = jwtService.generateToken(users);
        authenticationResponse.setRoleName(userRepository.findRoleByName(loginDto.getEmail()));
        authenticationResponse.setToken(jwtToken);

        if(passwordMatches == true && u != null ){
            Map<String, Object> response = new HashMap<>();
            response.put("token", jwtToken);
            response.put("userid",userRepository.findUserIdByEmail(loginDto.getEmail()));
            response.put("role", userRepository.findRoleByName(loginDto.getEmail()));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Invalid credentials");

            return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
        }
    }
}

