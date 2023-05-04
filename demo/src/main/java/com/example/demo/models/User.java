package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    private Long ID;
    private String F_name;
    private String s_name2;
    private String L_name;
    private String role;
    private String status;
    private String Email;
    private String password;
    public Object getS_name() {
        return null;
    }
    public void setS_name(Object s_name2) {
    }
    public Object getL_name() {
        return null;
    }
    public void setL_name(Object l_name2) {
    }
    public Object getRole() {
        return null;
    }
    public void setRole(Object role2) {
    }
    public Object getStatus() {
        return null;
    }
    public void setStatus(Object status2) {
    }
    public Object getPassword() {
        return null;
    }
    public void setPassword(Object password2) {
    }
    public Object getEmail() {
        return null;
    }
    public Object getID() {
        return null;
    }
    public void setID(Object id2) {
    }
    public void setEmail(Object email2) {
    }
    public Object getF_name() {
        return null;
    }
    public void setF_name(Object f_name2) {
    }
}
