package com.example.studentCouncil.Repository;

import com.example.studentCouncil.Model.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsaltantRepository extends JpaRepository<Consultant,Long> {
}


