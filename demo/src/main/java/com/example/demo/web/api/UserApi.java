package com.example.demo.web.api;

import com.example.demo.dto.UserRequest;
import com.example.demo.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("User")
public interface UserApi {
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity addNewUser(@RequestBody User user);

    @RequestMapping(value = "/{email}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUser(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "3") int size);

    @RequestMapping(value = "/{ID}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity editUser(@PathVariable("ID") Long ID,@RequestBody UserRequest user);

    @RequestMapping(value = "/{ID}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteUser(@PathVariable("ID") Long ID);

}
