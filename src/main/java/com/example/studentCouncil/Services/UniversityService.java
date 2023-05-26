package com.example.studentCouncil.Services;
import com.example.studentCouncil.Dto.UniversityReqDto;
import com.example.studentCouncil.Model.University;
import com.example.studentCouncil.Model.User;
import com.example.studentCouncil.Repository.UniversityRepository;
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
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    public UniversityService(UniversityRepository universityRepository, ModelMapper modelMapper, UserRepository userRepository){
        this.universityRepository= universityRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    public ResponseEntity addNewUniversity(UniversityReqDto universityReqDto){
        Optional<User> u = userRepository.findById(universityReqDto.getUseID());
        if(!u.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id"+"  "+universityReqDto.getUseID()+"   "+"does not exist");
        }
        University university = modelMapper.map(universityReqDto, University.class);
        User user = u.get();
        university.setUserID(user);
        universityRepository.save(university);

        Map resp = new HashMap();
        resp.put("resp",Boolean.TRUE);
        return  ResponseEntity.ok().body(resp);
    }
    public List<University> getAllUniversity(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        List list = new ArrayList();
        for (University university : universityRepository.findAll(pageable)) {
            list.add(university);
        }
        return list;
    }
    public ResponseEntity editUniversity(Long uniID, UniversityReqDto universityReqDto) throws ResponseStatusException {
        Optional<University> p = universityRepository.findById(uniID);
        if(p.isPresent()){
            University university  = modelMapper.map(universityReqDto,University.class);
            university.setUniID(uniID);
            universityRepository.save(university);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"");
        }

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
    public ResponseEntity deleteUniversity(Long uniID){
        universityRepository.deleteById(uniID);

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
}
