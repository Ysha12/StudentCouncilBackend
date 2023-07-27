package com.example.studentCouncil.Controller.Api;

import com.example.studentCouncil.Dto.StudentReqDto;
import com.example.studentCouncil.Dto.UserReqDto;
import com.example.studentCouncil.Model.Student;
import com.example.studentCouncil.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/Student")
public interface StudentApi {
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity addNewStudent(@RequestBody StudentReqDto student);

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAllStudent(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @RequestMapping(value = "/{ID}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity editStudent(@PathVariable("ID") Long ID, @RequestBody StudentReqDto studentReqDto);

    @RequestMapping(value = "/getStudentById/{ID}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getStudentById(@PathVariable("ID") Long ID);

    @RequestMapping(value = "/viewStudentById/{ID}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity viewStudentId(@PathVariable("ID") Long ID);

    @RequestMapping(value = "/{ID}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteStudent(@PathVariable("ID") Long ID);


    //    yangu
    public ResponseEntity addStudent(@RequestBody StudentReqDto student);

}
