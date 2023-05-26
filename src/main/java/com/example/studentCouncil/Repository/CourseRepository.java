package com.example.studentCouncil.Repository;
import com.example.studentCouncil.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
