package com.example.studentCouncil.Repository;

import com.example.studentCouncil.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u.password FROM User u WHERE u.email = :email")
    String findPasswordByEmail(@Param("email") String email);

    @Query("SELECT u.role.roleName FROM User u WHERE u.email = :email")
    String findRoleByName(@Param("email") String email);

    @Query("SELECT u.userID FROM User u WHERE u.email = :email")
    String findUserIdByEmail(@Param("email") String email);
    Optional<User> findByEmail(String email);
}
