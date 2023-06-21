package com.example.studentCouncil.Dto;

import com.example.studentCouncil.Model.User;
import lombok.Data;
@Data
public class LoanResDto {
    private Long loanID;
    private String loanType;
    private Long ID;

    private String F_name;
    private String s_name2;
    private String L_name;
    private String phoneNumber;
    private String address;
    private String role;
    private int status;
    private String Email;
    private String password;
//    private Long userID;
}
