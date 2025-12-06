package com.Airtribe.Student_Management_System.Repository;

import com.Airtribe.Student_Management_System.Entity.Enrollment;
import com.Airtribe.Student_Management_System.Helper.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByCourse_Id(Long courseId);

    List<Enrollment> findByCourse_IdAndStatus(Long courseId, Status status);

    List<Enrollment> findByStudent_IdAndStatus(Long studentId, Status status);

    Enrollment findByStudent_IdAndCourse_Id(Long studentId, Long courseId);

    List<Enrollment> findByStudent_Id(Long studentId);

    Long countByCourse_IdAndStatus(Long courseId, Status status);
}

