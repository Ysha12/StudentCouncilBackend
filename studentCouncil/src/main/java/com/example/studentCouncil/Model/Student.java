package com.example.studentCouncil.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stuID;
    private String LevelOfEducation;
    private Long ID;
//    @OneToMany (targetEntity = User,mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //    @JoinColumn()
}
