package com.example.studentCouncil.Controller.Api;

import com.example.studentCouncil.Dto.LogInDto;
import com.example.studentCouncil.Dto.UserReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = "*")
@RequestMapping("/User")
public interface UserApi {

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity addNewUser(@RequestBody UserReqDto user);

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUser(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @RequestMapping(value = "/{ID}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity editUser(@PathVariable("ID") Long ID,@RequestBody UserReqDto user);

    @RequestMapping(value = "/deleteUser/{ID}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteUser(@PathVariable("ID") Long ID);

    @RequestMapping(value = "/getUserById/{ID}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUserById(@PathVariable("ID") Long ID);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LogInDto logInDto );
}
