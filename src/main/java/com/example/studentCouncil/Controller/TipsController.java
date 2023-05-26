package com.example.studentCouncil.Controller;
import com.example.studentCouncil.Controller.Api.TipApi;
import com.example.studentCouncil.Dto.TipReqDto;
import com.example.studentCouncil.Services.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TipsController implements TipApi {
    @Autowired
    private TipService tipService;
    public TipsController (TipService tipService) {
        this.tipService=tipService;
    }
    public ResponseEntity getTips(int page, int size){
        return ResponseEntity.ok().body(tipService.getAllTips(page,size));
    }
    public ResponseEntity addNewTip(TipReqDto tipReqDto) {

        return ResponseEntity.ok().body(tipService.addNewTips(tipReqDto));
    }
    public ResponseEntity editTips(Long ID, TipReqDto tipReqDto) {
        return  ResponseEntity.ok().body(tipService.editTips(ID, tipReqDto));
    }
    public ResponseEntity deleteTip(Long tipID){

        return ResponseEntity.ok().body(tipService.deleteTip(tipID));
    }
}
