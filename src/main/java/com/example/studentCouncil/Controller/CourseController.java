package com.example.studentCouncil.Controller;

import com.example.studentCouncil.Controller.Api.CourseApi;
import com.example.studentCouncil.Dto.CourseReqDto;
import com.example.studentCouncil.Dto.UniversityReqDto;
import com.example.studentCouncil.Services.CourseService;
import com.example.studentCouncil.Services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController implements CourseApi {
    @Autowired
    private CourseService courseService;
    public CourseController (CourseService courseService) {
        this.courseService=courseService;
    }
    public ResponseEntity getCourse(int page, int size){
        return ResponseEntity.ok().body(courseService.getAllCourse(page,size));
    }
    public ResponseEntity addNewCourse(CourseReqDto courseReqDto) {

        return ResponseEntity.ok().body(courseService.addNewCourse(courseReqDto));
    }
    public ResponseEntity editCourse(Long ID, CourseReqDto courseReqDto) {
        return  ResponseEntity.ok().body(courseService.editCourse(ID, courseReqDto));
    }
    public ResponseEntity deleteCourse(Long courseID){

        return ResponseEntity.ok().body(courseService.deleteCourse(courseID));
    }
}
