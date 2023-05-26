package com.example.studentCouncil.Services;

import com.example.studentCouncil.Dto.StudentReqDto;
import com.example.studentCouncil.Model.Student;
import com.example.studentCouncil.Model.User;
import com.example.studentCouncil.Repository.StudentRepository;
import com.example.studentCouncil.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper, UserRepository userRepository){
        this.studentRepository= studentRepository;
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    //add new student
    public ResponseEntity addNewStudent(StudentReqDto studentReqDto){
     Optional<User> u = userRepository.findById(studentReqDto.getUser_id());
     if(!u.isPresent()){
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id"+"  "+studentReqDto.getUser_id()+"   "+"does not exist");
     }
        Student student = modelMapper.map(studentReqDto, Student.class);
        User user = u.get();
        student.setUserID(user);
        studentRepository.save(student);

        Map resp = new HashMap();
        resp.put("resp",Boolean.TRUE);
        return  ResponseEntity.ok().body(resp);
    }
    //view all student
    public List<Student> getAllStudent(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        List list = new ArrayList();
        for (Student student : studentRepository.findAll(pageable)) {
            list.add(student);
        }
        return list;
    }
//edit student
public ResponseEntity editStudent(Long stuId, StudentReqDto studentReqDto) throws ResponseStatusException {
    Optional<Student> p = studentRepository.findById(stuId);
    if(p.isPresent()){
        Student student  = modelMapper.map(studentReqDto,Student.class);
        student.setStuID(stuId);
        studentRepository.save(student);
    }else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"");
    }

    Map response=new HashMap();
    response.put("response",Boolean.TRUE);
    return  ResponseEntity.ok().body(response);
    }

    public ResponseEntity deleteStudent(Long stuId){
        studentRepository.deleteById(stuId);

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
}
