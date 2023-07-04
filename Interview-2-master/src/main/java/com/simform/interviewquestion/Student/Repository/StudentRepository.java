package com.simform.interviewquestion.Student.Repository;

import com.simform.interviewquestion.Student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {
}
