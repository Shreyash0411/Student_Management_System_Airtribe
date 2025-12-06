package com.Airtribe.Student_Management_System.ServiceImpl;

import com.Airtribe.Student_Management_System.Entity.Course;
import com.Airtribe.Student_Management_System.Entity.Enrollment;
import com.Airtribe.Student_Management_System.Entity.Student;
import com.Airtribe.Student_Management_System.Helper.Status;
import com.Airtribe.Student_Management_System.Repository.CourseRepository;
import com.Airtribe.Student_Management_System.Repository.EnrollmentRepository;
import com.Airtribe.Student_Management_System.Repository.StudentRepository;
import com.Airtribe.Student_Management_System.Service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService implements IEnrollmentService
{

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Enrollment enrollStudentInCourse(Long studentId, Long courseId) throws Exception {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isEmpty())
            throw new Exception("Student does not exist with that id" + studentId);

        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isEmpty())
            throw new Exception("Course does not exist with that id" + courseId);

        Enrollment existingEnrollment = enrollmentRepository.findByStudent_IdAndCourse_Id(studentId, courseId);
        if(existingEnrollment != null)
            throw new Exception("Student is already enrolled in the course");

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student.get());
        enrollment.setCourse(course.get());
        enrollment.setStatus(Status.Active);
        Enrollment newEnrollment = enrollmentRepository.save(enrollment);

        return newEnrollment;
    }

    @Override
    public Enrollment changeEnrollmentStatus(Long studentId, Long courseId, Status status) throws Exception {
        Enrollment enrollment = enrollmentRepository.findByStudent_IdAndCourse_Id(studentId, courseId);
        if(enrollment != null) {
            enrollment.setStatus(status);
            return enrollmentRepository.save(enrollment);
        }
        throw new Exception("Enrollment does not exist");
    }

    @Override
    public List<Enrollment> getEnrollmentsByStudent(Long studentId) {
        List<Enrollment> enrollments = enrollmentRepository.findByStudent_Id(studentId);
        if(!enrollments.isEmpty())
            return enrollments;
        return List.of();
    }

    @Override
    public List<Enrollment> getEnrollmentsByCourse(Long courseId) {
        List<Enrollment> enrollments = enrollmentRepository.findByCourse_Id(courseId);
        if(!enrollments.isEmpty())
            return enrollments;
        return List.of();
    }

    @Override
    public List<Student> getActiveStudentsByCourse(Long courseId) {
        List<Enrollment> enrollments = enrollmentRepository.findByCourse_IdAndStatus(courseId, Status.Active);
        if(!enrollments.isEmpty())
            return enrollments.stream().map(Enrollment::getStudent).toList();
        return List.of();
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        if(!enrollments.isEmpty())
            return enrollments;
        return List.of();
    }
}
