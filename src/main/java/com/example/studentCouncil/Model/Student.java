package com.example.studentCouncil.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stuID;
    private String LevelOfEducation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User userID;

    @OneToMany( mappedBy = "students", fetch = FetchType.LAZY)
    private List<StudentConcil> studentConcilList;

}
