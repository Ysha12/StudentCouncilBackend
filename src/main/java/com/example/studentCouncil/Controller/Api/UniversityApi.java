package com.example.studentCouncil.Controller.Api;

import com.example.studentCouncil.Dto.LoanReqDto;
import com.example.studentCouncil.Dto.UniversityReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("University")
public interface UniversityApi {
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity addNewUniversity(@RequestBody UniversityReqDto universityReqDto);

    @RequestMapping(value = "/{ID}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUniversity(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size);

    @RequestMapping(value = "/{ID}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity editUniversity(@PathVariable("ID") Long ID, @RequestBody UniversityReqDto universityReqDto);

    @RequestMapping(value = "/{ID}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteUniversity(@PathVariable("ID") Long ID);
}
