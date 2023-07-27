package com.example.studentCouncil.Repository;

import com.example.studentCouncil.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("SELECT s.levelOfEducation FROM Student s WHERE s.userID = :userID")
    String findStudentLevelById(@Param("userID") Long userID);
}
