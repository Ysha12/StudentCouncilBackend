package com.example.studentCouncil.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "consaltant")
public class Consaltant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consID;
    private String WorkingExperience;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User userID;

    @OneToMany( mappedBy = "consaltant", fetch = FetchType.LAZY)
    private List<Tips> tipsList;

    @OneToMany( mappedBy = "consaltant", fetch = FetchType.LAZY)
    private List<StudentConcil> studentConcilList;
}
