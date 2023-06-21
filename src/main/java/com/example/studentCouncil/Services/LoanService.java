package com.example.studentCouncil.Services;
import com.example.studentCouncil.Dto.LoanReqDto;
import com.example.studentCouncil.Dto.LoanResDto;
import com.example.studentCouncil.Model.Loan;
import com.example.studentCouncil.Model.User;
import com.example.studentCouncil.Repository.LoanRepository;
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
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    public LoanService(LoanRepository loanRepository, ModelMapper modelMapper, UserRepository userRepository){
        this.loanRepository= loanRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }
    public ResponseEntity addNewLoan(LoanReqDto loanReqDto){
        Optional<User> u = userRepository.findById(loanReqDto.getUsID());
        if(!u.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id"+"  "+loanReqDto.getUsID()+"   "+"does not exist");
        }
        Loan loan = modelMapper.map(loanReqDto, Loan.class);
        User user = u.get();
        loan.setUserID(user);
        loanRepository.save(loan);

        Map resp = new HashMap();
        resp.put("resp",Boolean.TRUE);
        return  ResponseEntity.ok().body(resp);
    }
    //view all student
    public List<Loan> getAllLoan(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        LoanResDto loanResDto = null;
        List list = new ArrayList();
        for (Loan loan : loanRepository.findAll(pageable)) {
            loanResDto = modelMapper.map(loan,LoanResDto.class);

            loanResDto.setF_name(loan.getUserID().getF_name());
            loanResDto.setS_name2(loan.getUserID().getS_name2());
            loanResDto.setL_name(loan.getUserID().getL_name());
            loanResDto.setEmail(loan.getUserID().getEmail());
            loanResDto.setRole(loan.getUserID().getRole());
            loanResDto.setStatus(loan.getUserID().getStatus());
            loanResDto.setPassword(loan.getUserID().getPassword());
            loanResDto.setAddress(loan.getUserID().getAddress());
            loanResDto.setPhoneNumber(loan.getUserID().getPhoneNumber());

            list.add(loanResDto);
        }
        return list;
    }
    //edit student
    public ResponseEntity editLoan(Long loanID, LoanReqDto loanReqDto) throws ResponseStatusException {
        Optional<Loan> p = loanRepository.findById(loanID);
        if(p.isPresent()){
            Loan loan  = modelMapper.map(loanReqDto,Loan.class);
            loan.setLoanID(loanID);
            loanRepository.save(loan);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"");
        }

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
    public ResponseEntity deleteLoan(Long loanID){
        loanRepository.deleteById(loanID);

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
}
