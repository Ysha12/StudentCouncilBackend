package com.example.studentCouncil.Services;

import com.example.studentCouncil.Dto.StudentReqDto;
import com.example.studentCouncil.Dto.StudentRespondDto;
import com.example.studentCouncil.Dto.UserRespondDto;
import com.example.studentCouncil.Model.Student;
import com.example.studentCouncil.Model.User;
import com.example.studentCouncil.Repository.ConsaltantRepository;
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
    private ConsaltantRepository consaltantRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    public StudentService(ConsaltantRepository consaltantRepository,StudentRepository studentRepository, ModelMapper modelMapper, UserRepository userRepository){
        this.consaltantRepository= consaltantRepository;
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

//        Optional<Consultant> c = consaltantRepository.findById(studentReqDto.getConst_id());
//        if(!u.isPresent()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id"+"  "+studentReqDto.getConst_id()+"   "+"does not exist");
//        }

        Student student = modelMapper.map(studentReqDto, Student.class);
        User user = u.get();
        student.setUserID(user);
        studentRepository.save(student);

//        Student student1=modelMapper.map(studentReqDto,Student.class);
//        Consultant consultant =c.get();
//        student1.setConstID(consultant);
//        studentRepository.save(student1);

        Map resp = new HashMap();
        resp.put("resp",Boolean.TRUE);
        return  ResponseEntity.ok().body(resp);
    }
    //view all student
    public List<Student> getAllStudent(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        StudentRespondDto studentRespondDto = null;
        List list = new ArrayList();
        for (Student student : studentRepository.findAll(pageable)) {
            studentRespondDto = modelMapper.map(student, StudentRespondDto.class);

            studentRespondDto.setF_name(student.getUserID().getF_name());
            studentRespondDto.setS_name2(student.getUserID().getS_name2());
            studentRespondDto.setL_name(student.getUserID().getL_name());
            studentRespondDto.setEmail(student.getUserID().getEmail());
//            studentRespondDto.setRole(student.getUserID().getRole());
            studentRespondDto.setAddress(student.getUserID().getAddress());
            studentRespondDto.setPhoneNumber(student.getUserID().getPhoneNumber());

            list.add(studentRespondDto);
        }
        return list;
    }
    public StudentRespondDto getStudentById(Long stuID){
        Optional<User> u = userRepository.findById(stuID);

        if(!u.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,stuID+"  "+"doesn't exist");
        }
        StudentRespondDto studentRespondDto = null;

        for (Student student : studentRepository.findAll()) {
            studentRespondDto = modelMapper.map(student, StudentRespondDto.class);

            studentRespondDto.setF_name(student.getUserID().getF_name());
            studentRespondDto.setS_name2(student.getUserID().getS_name2());
            studentRespondDto.setL_name(student.getUserID().getL_name());
            studentRespondDto.setEmail(student.getUserID().getEmail());
//            studentRespondDto.setLevelOfEducation(studentRepository.findStudentLevelById(student.getUserID().getUserID()));
           studentRespondDto.setLevelOfEducation(student.getLevelOfEducation());
            studentRespondDto.setAddress(student.getUserID().getAddress());
            studentRespondDto.setPhoneNumber(student.getUserID().getPhoneNumber());
        }
        return modelMapper.map(u.get(), StudentRespondDto.class);
    }

    public StudentRespondDto viewStudentId(Long stuID){
        Optional<Student> s = studentRepository.findById(stuID);
        if(!s.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,stuID+"  "+"doesn't exist");
        }
        return modelMapper.map(s.get(), StudentRespondDto.class);
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
