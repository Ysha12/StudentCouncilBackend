package com.example.studentCouncil.Controller;

import com.example.studentCouncil.Controller.Api.RoleApi;
import com.example.studentCouncil.Dto.RoleReqDto;
import com.example.studentCouncil.Services.RoleService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @Data
    public class RoleController implements RoleApi {
        @Autowired
        private final RoleService roleService;

        public ResponseEntity addRole(RoleReqDto roleReqDto) {
            return ResponseEntity.ok().body(roleService.add(roleReqDto));
        }

        public ResponseEntity getRoles(int page, int size) {
            return ResponseEntity.ok().body(roleService.getAll(page, size));
        }

        public ResponseEntity getRoleById(Integer id) {
            return  ResponseEntity.ok().body(roleService.getById(id));
        }

        public ResponseEntity editRole(Integer id, RoleReqDto roleReqDto) {
            return  ResponseEntity.ok().body(roleService.edit(id, roleReqDto));
        }
        public ResponseEntity deleteRole(Integer roleId){
            return ResponseEntity.ok().body(roleService.deleteRole(roleId));
        }

    }
