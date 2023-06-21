package com.example.studentCouncil.Controller.Api;
import com.example.studentCouncil.Dto.ConsaltantReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/Consultant")
public interface ConsApi {
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity addNewConsultant(@RequestBody ConsaltantReqDto consaltantReqDto);

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAllConsultant(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size);

    @RequestMapping(value = "/{ID}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity editConsultant(@PathVariable("ID") Long ID, @RequestBody ConsaltantReqDto consaltantReqDto);

    @RequestMapping(value = "/{ID}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteConsultant(@PathVariable("ID") Long ID);
}
