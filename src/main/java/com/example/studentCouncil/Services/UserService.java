package com.example.studentCouncil.Services;
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
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
@Service
@Data
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {

        this.userRepository = userRepository;

        this.modelMapper = modelMapper;
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
}

