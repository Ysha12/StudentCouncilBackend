package com.example.studentCouncil.Controller;

import com.example.studentCouncil.Controller.Api.UniversityApi;
import com.example.studentCouncil.Dto.LoanReqDto;
import com.example.studentCouncil.Dto.UniversityReqDto;
import com.example.studentCouncil.Services.LoanService;
import com.example.studentCouncil.Services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UniversityController implements UniversityApi {
    @Autowired
    private UniversityService universityService;
    public UniversityController (UniversityService universityService) {
        this.universityService=universityService;
    }
    public ResponseEntity getUniversity(int page, int size){
        return ResponseEntity.ok().body(universityService.getAllUniversity(page,size));
    }
    public ResponseEntity addNewUniversity(UniversityReqDto uni) {

        return ResponseEntity.ok().body(universityService.addNewUniversity(uni));
    }
    public ResponseEntity editUniversity(Long ID, UniversityReqDto universityReqDto) {
        return  ResponseEntity.ok().body(universityService.editUniversity(ID, universityReqDto));
    }
    public ResponseEntity deleteUniversity(Long uniID){

        return ResponseEntity.ok().body(universityService.deleteUniversity(uniID));
    }
}
