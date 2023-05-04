package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.User;

public interface User_repository extends JpaRepository<User, Long>{
// build in all crud action

}