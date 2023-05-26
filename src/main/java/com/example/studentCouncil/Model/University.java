package com.example.studentCouncil.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uniID;
    private String uniName;
    private String location;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User userID;

    @OneToMany( mappedBy = "university", fetch = FetchType.LAZY)
   private List<Course> courseList;
}
