package com.example.demo.web;

import com.example.demo.Service.User_service;
import com.example.demo.dto.UserRequest;
import com.example.demo.models.User;
import com.example.demo.web.api.UserApi;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data

public class UserController implements UserApi {
    @Autowired
    private final User_service serv;
    
    //get all users

public UserController(User_service serv) {
        this.serv = serv;
    }

@Override
    public ResponseEntity getUser(int page, int size){
        return ResponseEntity.ok().body(serv.getAll(page,size));
    }

    @Override
    public ResponseEntity addNewUser(User user) {
        return ResponseEntity.ok().body(serv.addNewUser(user));
    }
    @Override
    public ResponseEntity editUser(Long ID, UserRequest user) {
        return  ResponseEntity.ok().body(serv.editUser(ID, user));
    }
    public ResponseEntity deleteUser(Long userId){
    return ResponseEntity.ok().body(serv.deleteUser(userId));
    }
}
