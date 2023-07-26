package com.example.studentCouncil.Controller;

import com.example.studentCouncil.Controller.Api.UserApi;
import com.example.studentCouncil.Dto.LogInDto;
import com.example.studentCouncil.Dto.UserReqDto;
import com.example.studentCouncil.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {
    @Autowired
    private UserService userService;
    public UserController(UserService serv)
    {
        this.userService = serv;
    }
    @Override
    public ResponseEntity getUser(int page, int size){
        return ResponseEntity.ok().body(userService.getUser(page,size));
    }
    public ResponseEntity getUserById(Long userID) {

        return ResponseEntity.ok().body(userService.getUserById(userID));
    }

    public ResponseEntity addNewUser(UserReqDto userReqDto) {
        return ResponseEntity.ok().body(userService.addUser(userReqDto));
    }
    @Override
    public ResponseEntity editUser(Long ID, UserReqDto user) {
        return  ResponseEntity.ok().body(userService.editUser(ID, user));
    }
    public ResponseEntity deleteUser(Long userId){

        return ResponseEntity.ok().body(userService.deleteUser(userId));
    }
    public ResponseEntity login(LogInDto logInDto) {
        return ResponseEntity.ok().body(userService.doLogin(logInDto));

    }
}

