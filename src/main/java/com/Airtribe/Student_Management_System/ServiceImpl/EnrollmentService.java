package com.Airtribe.Student_Management_System.ServiceImpl;

import com.Airtribe.Student_Management_System.Entity.Enrollment;
import com.Airtribe.Student_Management_System.Entity.Student;
import com.Airtribe.Student_Management_System.Helper.Status;
import com.Airtribe.Student_Management_System.Service.IEnrollmentCourse;

import java.util.List;

public class EnrollmentService implements IEnrollmentCourse
{

    @Override
    public Enrollment enrollStudentInCourse(Long studentId, Long courseId) {
        return null;
    }

    @Override
    public Enrollment changeEnrollmentStatus(Long studentId, Long courseId, Status status) {
        return null;
    }

    @Override
    public List<Enrollment> getEnrollmentsByStudent(Long studentId) {
        return List.of();
    }

    @Override
    public List<Enrollment> getEnrollmentsByCourse(Long courseId) {
        return List.of();
    }

    @Override
    public List<Student> getActiveStudentsByCourse(Long courseId) {
        return List.of();
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return List.of();
    }
}
