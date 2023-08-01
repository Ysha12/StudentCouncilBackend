package com.example.studentCouncil.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseID;
    private String courseName;
    private String category;
    private String acronym;
    private String credits;
    private String courseDescription;

//    @ManyToOne(cascade =CascadeType.REFRESH)
//    @JoinColumn(name = "universityID", referencedColumnName = "uniID")
//    private University university;

    @OneToMany( mappedBy = "courseID", fetch = FetchType.LAZY)
    private List<Course> courses;
}
