package com.example.studentCouncil.Repository;

import com.example.studentCouncil.Model.Tips;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipRepository extends JpaRepository<Tips,Long> {
}
