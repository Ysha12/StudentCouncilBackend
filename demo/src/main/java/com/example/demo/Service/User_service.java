package com.example.demo.Service;

import com.example.demo.dto.UserRequest;
import com.example.demo.models.User;
import com.example.demo.repository.User_repository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@Data
public class User_service {
    private final User_repository u_repo;
    private final ModelMapper modelMapper;

    public User_service( User_repository u_repo, ModelMapper modelMapper) {

        this.u_repo = u_repo;
        this.modelMapper=modelMapper;
    }
    public List<User> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        List list = new ArrayList();
        for (User usr : u_repo.findAll(pageable)) {
            list.add(usr);
        }
        return list;
    }

    public ResponseEntity addNewUser(User usr){
        User u = new User();
        u.setS_name(usr.getS_name());
        u.setL_name(usr.getL_name());
        u.setRole(usr.getRole());
        u.setStatus(usr.getStatus());
        u.setPassword(usr.getPassword());
        u.setID(usr.getID());
        u.setEmail(usr.getEmail());
        u.setF_name(usr.getF_name());
        u_repo.save(u);

        Map resp = new HashMap();
        resp.put("resp",Boolean.TRUE);
        return  ResponseEntity.ok().body(resp);
    }

    public ResponseEntity editUser(Long userId, UserRequest us){
        Optional<User> p = u_repo.findById(userId);
        if(p.isPresent()){
          User user=modelMapper.map(us,User.class);
            user.setID(userId);
            u_repo.save(user);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"");
        }

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
    public ResponseEntity deleteUser(Long userId){
        u_repo.deleteById(userId);

        Map response=new HashMap();
        response.put("response",Boolean.TRUE);
        return  ResponseEntity.ok().body(response);
    }
}