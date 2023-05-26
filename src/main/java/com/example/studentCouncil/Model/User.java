package com.example.studentCouncil.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    private String F_name;
    private String s_name2;
    private String L_name;
    private String role;
    private int status;
    private String Email;
    private String password;

    @OneToOne(mappedBy = "userID")
    private Student stuID;
//    @OneToOne(mappedBy = "userID")
    private Long consID;
//    @OneToOne(mappedBy = "userID")
    private Long loanID;
    private Long uniID;
}
