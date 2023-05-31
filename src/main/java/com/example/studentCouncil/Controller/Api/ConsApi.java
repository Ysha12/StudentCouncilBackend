package com.example.studentCouncil.Controller.Api;
import com.example.studentCouncil.Dto.ConsaltantReqDto;
import com.example.studentCouncil.Model.Consaltant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("Consultant")
public interface ConsApi {
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity addNewConsaltant(@RequestBody ConsaltantReqDto consaltantReqDto);

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAllConsaltant(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size);

    @RequestMapping(value = "/{ID}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity editConsaltant(@PathVariable("ID") Long ID, @RequestBody ConsaltantReqDto consaltantReqDto);

    @RequestMapping(value = "/{ID}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteConsaltant(@PathVariable("ID") Long ID);
}
