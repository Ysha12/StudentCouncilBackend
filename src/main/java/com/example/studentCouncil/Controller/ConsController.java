package com.example.studentCouncil.Controller;
import com.example.studentCouncil.Controller.Api.ConsApi;
import com.example.studentCouncil.Dto.ConsaltantReqDto;
import com.example.studentCouncil.Services.ConsultantService;
import com.example.studentCouncil.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class ConsController implements ConsApi {
    @Autowired
    private ConsultantService consultantService;
    private UserService userService;
    public ConsController (ConsultantService consultantService, UserService userService)
    {
        this.consultantService=consultantService;
        this.userService=userService;
    }
    public ResponseEntity getAllConsultant(int page, int size){
        return ResponseEntity.ok().body(consultantService.getAllConsultant(page,size));
    }
    public ResponseEntity addNewConsultant(ConsaltantReqDto cons) {
        return ResponseEntity.ok().body(consultantService.addNewConsultant(cons));
    }
    public ResponseEntity editConsultant(Long ID, ConsaltantReqDto consreq) {
        return  ResponseEntity.ok().body(consultantService.editConsultant(ID, consreq));
    }
    public ResponseEntity deleteConsultant(Long consID){
        return ResponseEntity.ok().body(consultantService.deleteConsultant(consID));
    }
}
