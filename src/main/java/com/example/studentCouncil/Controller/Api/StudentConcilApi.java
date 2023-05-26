package com.example.studentCouncil.Controller.Api;

import com.example.studentCouncil.Dto.StudentConcilReqDto;
import com.example.studentCouncil.Dto.TipReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface StudentConcilApi {
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity addNewStudentConcil(@ModelAttribute StudentConcilReqDto studentConcilReqDto);

    @RequestMapping(value = "/{ID}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getStudentConcil(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size);

}
