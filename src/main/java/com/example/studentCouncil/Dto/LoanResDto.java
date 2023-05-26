package com.example.studentCouncil.Dto;

import com.example.studentCouncil.Model.User;
import lombok.Data;
@Data
public class LoanResDto {
    private Long loanID;
    private String loanType;
    private User userID;
}
