package com.council.student.Service;

import com.council.student.Dto.UserRequest;
import com.council.student.Model.User;
import com.council.student.Repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

public class UserService {
    @Autowired
    private  UserRepo userRepo;
    private  ModelMapper modelMapper;

    public UserService( UserRepo userRepo, ModelMapper modelMapper) {

        this.userRepo = userRepo;
        this.modelMapper=modelMapper;
    }
    public List<User> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        List list = new ArrayList();
        for (User usr : userRepo.findAll(pageable)) {
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
        userRepo.save(u);

        Map resp = new HashMap();
        resp.put("resp",Boolean.TRUE);
        return  ResponseEntity.ok().body(resp);
    }
    public ResponseEntity editUser(Long userId, UserRequest us) throws ResponseStatusException {
        Optional<User> p = userRepo.findById(userId);
        if(p.isPresent()){
            User user=modelMapper.map(us,User.class);
            user.setID(userId);
            userRepo.save(user);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"");
        }

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
    public ResponseEntity deleteUser(Long userId){
        userRepo.deleteById(userId);

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
}
