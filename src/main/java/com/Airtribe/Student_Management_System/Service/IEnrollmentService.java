package com.Airtribe.Student_Management_System.Service;

import com.Airtribe.Student_Management_System.Entity.Enrollment;
import com.Airtribe.Student_Management_System.Entity.Student;
import com.Airtribe.Student_Management_System.Helper.Status;

import java.util.List;

public interface IEnrollmentService {
    // make sure to make the enrollment unique
    Enrollment enrollStudentInCourse(Long studentId, Long courseId) throws Exception;

    Enrollment changeEnrollmentStatus(Long studentId, Long courseId, Status status) throws Exception;

    List<Enrollment> getEnrollmentsByStudent(Long studentId);

    List<Enrollment> getEnrollmentsByCourse(Long courseId);

    List<Student> getActiveStudentsByCourse(Long courseId);

    List<Enrollment> getAllEnrollments();
}
