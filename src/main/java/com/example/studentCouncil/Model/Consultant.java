package com.example.studentCouncil.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "consultant")
//@EqualsAndHashCode(callSuper = true)
public class Consultant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consID;
    private String working_experience;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User userID;

//    @OneToMany( mappedBy = "constID", fetch = FetchType.LAZY)
//    private List<Student> studentList;

    @OneToMany( mappedBy = "consultant", fetch = FetchType.LAZY)
    private List<Tips> tipsList;
//
//    @OneToMany( mappedBy = "consultant", fetch = FetchType.LAZY)
//    private List<StudentConcil> studentConcilList;

//    consultant  + student
//    @ManyToMany
//    @JoinTable(name = "consultant_students",
//            joinColumns = @JoinColumn(name = "consultantId"),
//            inverseJoinColumns = @JoinColumn(name = "studentId")
//    )
//    private Set<Student> students;
}
