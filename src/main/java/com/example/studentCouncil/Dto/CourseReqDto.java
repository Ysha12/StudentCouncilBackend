package com.example.studentCouncil.Dto;

import com.example.studentCouncil.Model.University;
import lombok.Data;

import javax.persistence.*;
@Data
public class CourseReqDto {
//    private Long courseID;
    private String courseName;
    private String credits;
    private String acronym;
    private String category;
    private String courseDescription;
}
