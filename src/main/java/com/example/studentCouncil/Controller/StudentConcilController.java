package com.example.studentCouncil.Controller;

import com.example.studentCouncil.Controller.Api.StudentConcilApi;
import com.example.studentCouncil.Dto.StudentConcilReqDto;
import com.example.studentCouncil.Dto.TipReqDto;
import com.example.studentCouncil.Services.StudentConcilService;
import com.example.studentCouncil.Services.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentConcilController implements StudentConcilApi {
    @Autowired
    private StudentConcilService studentConcilService;
    public StudentConcilController (StudentConcilService studentConcilService) {

        this.studentConcilService=studentConcilService;
    }
    public ResponseEntity getStudentConcil(int page, int size){
        return ResponseEntity.ok().body(studentConcilService.getAllStudentConcil(page,size));
    }
    public ResponseEntity addNewStudentConcil(StudentConcilReqDto studentConcilReqDto) {

        return ResponseEntity.ok().body(studentConcilService.addNewStudentConcil(studentConcilReqDto));
    }
//    public ResponseEntity editTips(Long ID, TipReqDto tipReqDto) {
//        return  ResponseEntity.ok().body(tipService.editTips(ID, tipReqDto));
//    }
}
