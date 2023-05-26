package com.example.studentCouncil.Repository;

import com.example.studentCouncil.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
