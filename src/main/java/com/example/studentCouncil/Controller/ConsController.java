package com.example.studentCouncil.Controller;
import com.example.studentCouncil.Controller.Api.ConsApi;
import com.example.studentCouncil.Dto.ConsaltantReqDto;
import com.example.studentCouncil.Services.ConsaltantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsController implements ConsApi {
    @Autowired
    private ConsaltantService consaltantService;
    public ConsController (ConsaltantService consaltantService)
    {
        this.consaltantService=consaltantService;
    }
    public ResponseEntity getConsaltant(int page, int size){
        return ResponseEntity.ok().body(consaltantService.getAllConsaltant(page,size));
    }
    public ResponseEntity addNewConsaltant(ConsaltantReqDto cons) {

        return ResponseEntity.ok().body(consaltantService.addNewConsultant(cons));
    }
    public ResponseEntity editConsaltant(Long ID, ConsaltantReqDto consreq) {
        return  ResponseEntity.ok().body(consaltantService.editConsaltant(ID, consreq));
    }
    public ResponseEntity deleteConsaltant(Long consID){

        return ResponseEntity.ok().body(consaltantService.deleteConsaltant(consID));
    }
}
