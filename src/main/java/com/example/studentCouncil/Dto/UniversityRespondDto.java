package com.example.studentCouncil.Dto;

import com.example.studentCouncil.Model.User;
import lombok.Data;

@Data
public class UniversityRespondDto {
    private Long uniID;
    private String uniName;
    private String location;
    private String description;
}
