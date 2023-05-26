package com.example.studentCouncil.Dto;

import lombok.Data;

@Data
public class CourseResDto {
    private Long courseID;
    private String courseName;
    private String credits;
    private String courseDescription;
    private Long universityID;
}