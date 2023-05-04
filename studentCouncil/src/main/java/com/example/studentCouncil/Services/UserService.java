package com.example.studentCouncil.Services;
import com.example.studentCouncil.Dto.UserReqDto;
import com.example.studentCouncil.Model.User;
import com.example.studentCouncil.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private org.modelmapper.ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {

        this.userRepository = userRepository;

        this.modelMapper = modelMapper;
    }
    public List<User> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        List list = new ArrayList();
        for (User usr : userRepository.findAll(pageable)) {
            list.add(usr);
        }
        return list;
    }
    public ResponseEntity addNewUser(User usr){
        User u = new User();
        u.setS_name2(usr.getS_name2());
        u.setL_name(usr.getL_name());
        u.setRole(usr.getRole());
        u.setStatus(usr.getStatus());
        u.setPassword(usr.getPassword());
        u.setID(usr.getID());
        u.setEmail(usr.getEmail());
        u.setF_name(usr.getF_name());
        userRepository.save(u);

        Map resp = new HashMap();
        resp.put("resp",Boolean.TRUE);
        return  ResponseEntity.ok().body(resp);
    }
    public ResponseEntity editUser(Long userId, UserReqDto us) throws ResponseStatusException {
        Optional<User> p = userRepository.findById(userId);
        if(p.isPresent()){
            User user  = modelMapper.map(us,User.class);
            user.setID(userId);
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
}

