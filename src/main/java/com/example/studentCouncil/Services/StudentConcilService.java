package com.example.studentCouncil.Services;
import com.example.studentCouncil.Dto.StudentConcilReqDto;
import com.example.studentCouncil.Dto.StudentConcilResDto;
import com.example.studentCouncil.Model.*;
import com.example.studentCouncil.Repository.ConsaltantRepository;
import com.example.studentCouncil.Repository.StudentConcilRepo;
import com.example.studentCouncil.Repository.StudentRepository;
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
public class StudentConcilService {
    @Autowired
    private StudentConcilRepo studentConcilRepo;
    private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;
    private final ConsaltantRepository consaltantRepository;

    public StudentConcilService(StudentConcilRepo studentConcilRepo, ModelMapper modelMapper,StudentRepository studentRepository, ConsaltantRepository consaltantRepository){
        this.studentConcilRepo= studentConcilRepo;
        this.modelMapper = modelMapper;
        this.consaltantRepository = consaltantRepository;
        this.studentRepository=studentRepository;
    }
    public ResponseEntity addNewStudentConcil(StudentConcilReqDto studentConcilReqDto){
        Optional<Consultant> u = consaltantRepository.findById(studentConcilReqDto.getConsID());
        if(!u.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id"+"  "+studentConcilReqDto.getConsID()+"   "+"does not exist");
        }

        Optional<Student> s = studentRepository.findById(studentConcilReqDto.getStuID());
        if(!u.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id"+"  "+studentConcilReqDto.getStuID()+"   "+"does not exist");
        }

        StudentConcil studentConcil = modelMapper.map(studentConcilReqDto, StudentConcil.class);
        Consultant consultant = u.get();
        studentConcil.setConsultant(consultant);
        studentConcilRepo.save(studentConcil);

        StudentConcil studentConcil1 = modelMapper.map(studentConcilReqDto, StudentConcil.class);
        Student student = s.get();
        studentConcil.setStudents(student);
        studentConcilRepo.save(studentConcil1);

        Map resp = new HashMap();
        resp.put("resp",Boolean.TRUE);
        return  ResponseEntity.ok().body(resp);
    }
    public List<StudentConcil> getAllStudentConcil(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        StudentConcilResDto studentConcilResDto = null;
        List list = new ArrayList();
        for (StudentConcil studentConcil : studentConcilRepo.findAll(pageable)) {
            studentConcilResDto = modelMapper.map(studentConcil,StudentConcilResDto.class);
            list.add(studentConcilResDto);
        }
        return list;
    }
//    public ResponseEntity editS(Long tipID, TipReqDto tipReqDto) throws ResponseStatusException {
//        Optional<Tips> p = tipRepository.findById(tipID);
//        if(p.isPresent()){
//            Tips tips  = modelMapper.map(tipReqDto,Tips.class);
//            tips.setTipID(tipID);
//            tipRepository.save(tips);
//        }else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"");
//        }
//
//        Map response=new HashMap();
//        response.put("response",Boolean.TRUE);
//        return  ResponseEntity.ok().body(response);
//    }
}
