package com.example.studentCouncil.Services;
import com.example.studentCouncil.Dto.AuthResponse;
import com.example.studentCouncil.Dto.LogInDto;
import com.example.studentCouncil.Dto.UserReqDto;
import com.example.studentCouncil.Dto.UserRespondDto;
import com.example.studentCouncil.Model.User;
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
    private final ModelMapper modelMapper;
    private final JwtService jwtService;
    @Autowired
    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, JwtService jwtService,ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.jwtService=jwtService;
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
    public ResponseEntity addNewUser(UserReqDto usr){
        User user = modelMapper.map(usr,User.class);
        String encPsd = this.passwordEncoder.encode(usr.getPassword());
        user.setPassword(encPsd);
        userRepository.save(user);

        Map resp = new HashMap();
        resp.put("resp",Boolean.TRUE);
        return  ResponseEntity.ok().body(resp);
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

    public AuthResponse doLogin(LogInDto logInDto) {
        String rawPassword = logInDto.getPassword();
        String encodedPassword = userRepository.findPasswordByEmail(logInDto.getEmail());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean passwordMatches = encoder.matches(rawPassword, encodedPassword);
        Optional<User> u = userRepository.findByEmail(logInDto.getEmail());
        if(!u.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Map response = new HashMap();
        if(passwordMatches){
            response.put("response",Boolean.TRUE);

        }else{
            response.put("response",Boolean.FALSE);
        }
        User users = modelMapper.map(logInDto, User.class);
        var jwtToken = jwtService.generateToken(users);
        return AuthResponse.builder().token(jwtToken).build();

    }
}

