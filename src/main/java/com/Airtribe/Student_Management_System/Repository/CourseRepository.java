package com.Airtribe.Student_Management_System.Repository;

import com.Airtribe.Student_Management_System.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository  extends JpaRepository<Course,Long> {

    List<Course> findByTeacher_Id(Long id);

    Course findByCourseCode(String courseCode);

    List<Course> findByDepartment_Id(Long departmentId);

    Long countByDepartment_Id(Long departmentId);
}
