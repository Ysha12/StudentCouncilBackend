package com.example.studentCouncil.Dto;

import com.example.studentCouncil.Model.User;
import lombok.Data;

import javax.persistence.*;
@Data
public class LoanReqDto {
        private String loanType;
        private Long usID;
    }
