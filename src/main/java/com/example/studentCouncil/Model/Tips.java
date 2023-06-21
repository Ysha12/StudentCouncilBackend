package com.example.studentCouncil.Model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "Tips")
public class Tips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipID;
    private String name;
    private String category;
    private String tipsDescription;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "consultant", referencedColumnName = "consID")
    private Consultant consultant;
}
