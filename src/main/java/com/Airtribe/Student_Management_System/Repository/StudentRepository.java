package com.Airtribe.Student_Management_System.Repository;

import com.Airtribe.Student_Management_System.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository  extends JpaRepository<Student, Long>
{
    Student findByEmail(String email);

    List<Student> findByDepartmentId(Long departmentId);

    Student findByRollNumber(String rollNumber);
}
