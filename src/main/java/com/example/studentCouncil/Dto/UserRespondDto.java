package com.example.studentCouncil.Dto;

import lombok.Data;

@Data
public class UserRespondDto {
    private Long userID;
    private String F_name;
    private String s_name;
    private String L_name;
    private String phoneNumber;
    private String address;
    private int roleId;
    private int status;
    private String Email;
    private String password;
}
