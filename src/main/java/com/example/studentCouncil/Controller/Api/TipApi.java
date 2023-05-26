package com.example.studentCouncil.Controller.Api;

import com.example.studentCouncil.Dto.CourseReqDto;
import com.example.studentCouncil.Dto.TipReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RequestMapping("Tips")
public interface TipApi {
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity addNewTip(@ModelAttribute TipReqDto tipReqDto);

    @RequestMapping(value = "/{ID}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getTips(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size);

    @RequestMapping(value = "/{ID}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity editTips(@PathVariable("ID") Long ID, @RequestBody TipReqDto tipReqDto);

    @RequestMapping(value = "/{ID}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteTip(@PathVariable("ID") Long ID);
}
