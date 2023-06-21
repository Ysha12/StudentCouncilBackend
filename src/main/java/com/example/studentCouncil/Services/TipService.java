package com.example.studentCouncil.Services;
import com.example.studentCouncil.Dto.TipReqDto;
import com.example.studentCouncil.Dto.TipResDto;
import com.example.studentCouncil.Model.*;
import com.example.studentCouncil.Repository.ConsaltantRepository;
import com.example.studentCouncil.Repository.TipRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
@Data
public class TipService {
    @Autowired
    private TipRepository tipRepository;
    private final ModelMapper modelMapper;
    private final ConsaltantRepository consaltantRepository;
    private final Path root= Paths.get("Images");

    public TipService(TipRepository tipRepository, ModelMapper modelMapper, ConsaltantRepository consaltantRepository){
        this.tipRepository= tipRepository;
        this.modelMapper = modelMapper;
        this.consaltantRepository = consaltantRepository;
    }
    public ResponseEntity addNewTips(TipReqDto tipReqDto){
        Random random = new Random();
        int upperbound = 100;
        int int_random = random.nextInt(upperbound);
        Optional<Consultant> u = consaltantRepository.findById(tipReqDto.getConsalt());
        if(!u.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id"+"  "+tipReqDto.getConsalt()+"   "+"does not exist");
        }

        String ext;
        try {
            String fileName = tipReqDto.getName().getOriginalFilename();
            ext = fileName.substring(tipReqDto.getName().getOriginalFilename().lastIndexOf(".") + 1);
            Files.copy(tipReqDto.getName().getInputStream(), this.root.resolve(String.valueOf(int_random) + "." + ext));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Tips tips = modelMapper.map(tipReqDto, Tips.class);
        Consultant consultant = u.get();
        tips.setConsultant(consultant);
        tips.setName("/Images/" + String.valueOf(int_random) + "." + ext);
        tipRepository.save(tips);

        Map resp = new HashMap();
        resp.put("resp",Boolean.TRUE);
        return  ResponseEntity.ok().body(resp);
    }
    public List<Tips> getAllTips(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        TipResDto tipResDto = null;
        List list = new ArrayList();
        for (Tips tips : tipRepository.findAll(pageable)) {
            tipResDto = modelMapper.map(tips,TipResDto.class);
            list.add(tipResDto);
        }
        return list;
    }
    public ResponseEntity editTips(Long tipID, TipReqDto tipReqDto) throws ResponseStatusException {
        Optional<Tips> p = tipRepository.findById(tipID);
        if(p.isPresent()){
            Tips tips  = modelMapper.map(tipReqDto,Tips.class);
            tips.setTipID(tipID);
            tipRepository.save(tips);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"");
        }

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
    public ResponseEntity deleteTip(Long tipID){
        tipRepository.deleteById(tipID);

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
}
