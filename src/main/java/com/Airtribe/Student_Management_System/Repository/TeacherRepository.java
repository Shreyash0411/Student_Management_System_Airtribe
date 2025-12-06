package com.Airtribe.Student_Management_System.Repository;

import com.Airtribe.Student_Management_System.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findByEmail(String email);

    List<Teacher> findByDepartmentId(Long departmentId);

    Long countByDepartmentId(Long departmentId);
}
