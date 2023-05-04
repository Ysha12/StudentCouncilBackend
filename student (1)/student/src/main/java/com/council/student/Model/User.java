package com.council.student.Model;
//import javax.persistence.Entity;
//import javax.persistence.Table;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users")
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
}
