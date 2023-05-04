package com.council.student.Controller;

import com.council.student.Controller.Api.UserApi;
import com.council.student.Dto.UserRequest;
import com.council.student.Model.User;
import com.council.student.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class UserController implements UserApi {
    @Autowired
    private UserService userService;
    public UserController(UserService serv) {
        this.userService = serv;
    }
    @Override
    public ResponseEntity getUser(int page, int size){
        return ResponseEntity.ok().body(userService.getAll(page,size));
    }

    @Override
    public ResponseEntity addNewUser(User user) {
        return ResponseEntity.ok().body(userService.addNewUser(user));
    }
    @Override
    public ResponseEntity editUser(Long ID, UserRequest user) {
        return  ResponseEntity.ok().body(userService.editUser(ID, user));
    }
    public ResponseEntity deleteUser(Long userId){
        return ResponseEntity.ok().body(userService.deleteUser(userId));
    }
}
