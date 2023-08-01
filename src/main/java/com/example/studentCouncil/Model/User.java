package com.example.studentCouncil.Model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    private String F_name;
    private String s_name2;
    private String L_name;
    private String phoneNumber;
    private String address;
    private int status;
    private String email;
    private String password;

    @OneToOne(mappedBy = "userID")
    private Student stuID;
    private Long consID;
    private Long loanID;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "roleCode", referencedColumnName = "roleId")
    private Role role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getRoleName()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getPassword(){
        return password;
    }





}
