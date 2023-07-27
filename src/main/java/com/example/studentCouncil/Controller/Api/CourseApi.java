package com.example.studentCouncil.Controller.Api;
import com.example.studentCouncil.Dto.CourseReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RequestMapping("/Course")
public interface CourseApi {
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity addNewCourse(@RequestBody CourseReqDto courseReqDto);

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getCourse(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @RequestMapping(value = "/{ID}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity editCourse(@PathVariable("ID") Long ID, @RequestBody CourseReqDto courseReqDto);

    @RequestMapping(value = "/{ID}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteCourse(@PathVariable("ID") Long ID);
}
