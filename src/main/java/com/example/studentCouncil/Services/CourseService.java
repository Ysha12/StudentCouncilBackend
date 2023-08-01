package com.example.studentCouncil.Services;
import com.example.studentCouncil.Dto.ConsaltantRespondDto;
import com.example.studentCouncil.Dto.CourseReqDto;
import com.example.studentCouncil.Dto.CourseResDto;
import com.example.studentCouncil.Model.Course;
import com.example.studentCouncil.Model.University;
import com.example.studentCouncil.Repository.CourseRepository;
import com.example.studentCouncil.Repository.UniversityRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Data
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    private final ModelMapper modelMapper;
    private final UniversityRepository universityRepository;
    public CourseService(CourseRepository courseRepository, ModelMapper modelMapper, UniversityRepository universityRepository){
        this.courseRepository= courseRepository;
        this.modelMapper = modelMapper;
        this.universityRepository = universityRepository;
    }
    public ResponseEntity addNewCourse(CourseReqDto courseReqDto){
//        Optional<University> u = universityRepository.findById(courseReqDto.getUniID());
//        if(!u.isPresent()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course with id"+"  "+courseReqDto.getUniID()+"   "+"does not exist");
//        }
        Course course = modelMapper.map(courseReqDto, Course.class);
//        University uni = u.get();
//        course.setUniversity(uni);
        courseRepository.save(course);

        Map resp = new HashMap();
        resp.put("resp",Boolean.TRUE);
        return  ResponseEntity.ok().body(resp);
    }
    public ResponseEntity<?> getAllCourse(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        CourseResDto courseResDto=null;
        List list = new ArrayList();
        for (Course course : courseRepository.findAll(pageable)) {
            courseResDto = modelMapper.map(course, CourseResDto.class);

            list.add(courseResDto);

        }
        Map<String, Object> response = new HashMap<>();
        response.put("body", list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    public ResponseEntity editCourse(Long courseID, CourseReqDto courseReqDto) throws ResponseStatusException {
        Optional<Course> p = courseRepository.findById(courseID);
        if(p.isPresent()){
            Course course  = modelMapper.map(courseReqDto,Course.class);
            course.setCourseID(courseID);
            courseRepository.save(course);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"");
        }

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
    public ResponseEntity deleteCourse(Long courseID){
        courseRepository.deleteById(courseID);

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
}
