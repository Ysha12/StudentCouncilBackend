package com.example.studentCouncil.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Role {
    @Id
    @GeneratedValue
    private int roleId;
    private String roleName;
    private String roleDescription;

    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY)
    private List<User> userList;

}
