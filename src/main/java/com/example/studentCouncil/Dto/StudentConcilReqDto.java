package com.example.studentCouncil.Dto;

import com.example.studentCouncil.Model.Consaltant;
import com.example.studentCouncil.Model.Student;
import lombok.Data;

import javax.persistence.*;
@Data
public class StudentConcilReqDto {
    private Long stuID;
    private Long consID;
}
