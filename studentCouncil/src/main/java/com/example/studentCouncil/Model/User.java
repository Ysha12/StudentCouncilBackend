package com.example.studentCouncil.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String F_name;
    private String s_name2;
    private String L_name;
    private String role;
    private String status;
    private String Email;
    private String password;
//    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
}
