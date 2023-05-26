package com.example.studentCouncil.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class StudentConcil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stuConcilID;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "stuID", referencedColumnName = "stuID")
    private Student students;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "consultant", referencedColumnName = "consID")
    private Consaltant consaltant;
}
