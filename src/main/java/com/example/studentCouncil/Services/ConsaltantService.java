package com.example.studentCouncil.Services;

import com.example.studentCouncil.Dto.ConsaltantReqDto;
import com.example.studentCouncil.Dto.StudentReqDto;
import com.example.studentCouncil.Model.Consaltant;
import com.example.studentCouncil.Model.Student;
import com.example.studentCouncil.Model.User;
import com.example.studentCouncil.Repository.ConsaltantRepository;
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

//import static jdk.internal.org.jline.utils.Colors.s;

@Service
public class ConsaltantService {
    @Autowired
    private ConsaltantRepository consaltantRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    public ConsaltantService(ConsaltantRepository consaltantRepository, ModelMapper modelMapper, UserRepository userRepository){
        this.consaltantRepository= consaltantRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }
    //add new student
    public ResponseEntity addNewConsultant(ConsaltantReqDto consaltantReqDto){
        Optional<User> u = userRepository.findById(consaltantReqDto.getUsrid());
        if(!u.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id"+"  "+consaltantReqDto.getUsrid()+"   "+"does not exist");
        }
        Consaltant consaltant = modelMapper.map(consaltantReqDto, Consaltant.class);
        User user = u.get();
        consaltant.setUserID(user);
        consaltantRepository.save(consaltant);

        Map resp = new HashMap();
        resp.put("resp",Boolean.TRUE);
        return  ResponseEntity.ok().body(resp);
    }
    //view all student
    public List<Consaltant> getAllConsaltant(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        List list = new ArrayList();
        for (Consaltant consaltant : consaltantRepository.findAll(pageable)) {
            list.add(consaltant);
        }
        return list;
    }
    //edit student
    public ResponseEntity editConsaltant(Long consId, ConsaltantReqDto consaltantReqDto) throws ResponseStatusException {
        Optional<Consaltant> p = consaltantRepository.findById(consId);
        if(p.isPresent()){
            Consaltant consaltant  = modelMapper.map(consaltantReqDto,Consaltant.class);
            consaltant.setConsID(consId);
            consaltantRepository.save(consaltant);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"");
        }

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
    public ResponseEntity deleteConsaltant(Long consId){
        consaltantRepository.deleteById(consId);

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
}
