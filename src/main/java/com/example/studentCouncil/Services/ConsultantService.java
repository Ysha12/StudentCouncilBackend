package com.example.studentCouncil.Services;

import com.example.studentCouncil.Dto.ConsaltantReqDto;
import com.example.studentCouncil.Dto.ConsaltantRespondDto;
import com.example.studentCouncil.Model.Consultant;
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
public class ConsultantService {
    @Autowired
    private ConsaltantRepository consaltantRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    public ConsultantService(ConsaltantRepository consaltantRepository, ModelMapper modelMapper, UserRepository userRepository){
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
        Consultant consultant = modelMapper.map(consaltantReqDto, Consultant.class);
        User user = u.get();
        consultant.setUserID(user);
        consaltantRepository.save(consultant);

        Map resp = new HashMap();
        resp.put("resp",Boolean.TRUE);
        return  ResponseEntity.ok().body(resp);
    }
    //view all student
    public List<Consultant> getAllConsultant(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        ConsaltantRespondDto consaltantRespondDto = null;
        List list = new ArrayList();
        for (Consultant consultant : consaltantRepository.findAll(pageable)) {
            consaltantRespondDto = modelMapper.map(consultant,ConsaltantRespondDto.class);

            consaltantRespondDto.setF_name(consultant.getUserID().getF_name());
            consaltantRespondDto.setS_name2(consultant.getUserID().getS_name2());
            consaltantRespondDto.setL_name(consultant.getUserID().getL_name());
            consaltantRespondDto.setEmail(consultant.getUserID().getEmail());
            //consaltantRespondDto.setRole(consultant.getUserID().getRole());
            consaltantRespondDto.setStatus(consultant.getUserID().getStatus());
            consaltantRespondDto.setPassword(consultant.getUserID().getPassword());
            consaltantRespondDto.setAddress(consultant.getUserID().getAddress());
            consaltantRespondDto.setPhoneNumber(consultant.getUserID().getPhoneNumber());

            list.add(consaltantRespondDto);
        }
        return list;
    }
    //edit student
    public ResponseEntity editConsultant(Long consId, ConsaltantReqDto consaltantReqDto) throws ResponseStatusException {
        Optional<Consultant> p = consaltantRepository.findById(consId);
        if(p.isPresent()){
            Consultant consultant = modelMapper.map(consaltantReqDto, Consultant.class);
            consultant.setConsID(consId);
            consaltantRepository.save(consultant);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"");
        }

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
    public ResponseEntity deleteConsultant(Long consId){
        consaltantRepository.deleteById(consId);

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
}
