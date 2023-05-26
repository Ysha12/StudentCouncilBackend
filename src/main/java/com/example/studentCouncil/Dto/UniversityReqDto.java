package com.example.studentCouncil.Dto;

import com.example.studentCouncil.Model.User;
import lombok.Data;

@Data
public class UniversityReqDto {
//    private Long uniID;
    private String uniName;
    private String location;
    private String description;
    private Long useID;
}
