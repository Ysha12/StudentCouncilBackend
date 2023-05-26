package com.example.studentCouncil.Repository;

import com.example.studentCouncil.Model.StudentConcil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentConcilRepo extends JpaRepository<StudentConcil,Long> {
}
