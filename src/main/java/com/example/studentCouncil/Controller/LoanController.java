package com.example.studentCouncil.Controller;

import com.example.studentCouncil.Controller.Api.LoanApi;
import com.example.studentCouncil.Dto.ConsaltantReqDto;
import com.example.studentCouncil.Dto.LoanReqDto;
import com.example.studentCouncil.Services.ConsaltantService;
import com.example.studentCouncil.Services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController implements LoanApi {
    @Autowired
    private LoanService loanService;
    public LoanController (LoanService loanService) {
        this.loanService=loanService;
    }
    public ResponseEntity getLoan(int page, int size){
        return ResponseEntity.ok().body(loanService.getAllLoan(page,size));
    }
    public ResponseEntity addNewLoan(LoanReqDto lon) {

        return ResponseEntity.ok().body(loanService.addNewLoan(lon));
    }
    public ResponseEntity editLoan(Long ID, LoanReqDto loanreq) {
        return  ResponseEntity.ok().body(loanService.editLoan(ID, loanreq));
    }
    public ResponseEntity deleteLoan(Long loanID){

        return ResponseEntity.ok().body(loanService.deleteLoan(loanID));
    }
}
