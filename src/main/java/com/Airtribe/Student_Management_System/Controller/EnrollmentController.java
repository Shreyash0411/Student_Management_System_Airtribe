package com.Airtribe.Student_Management_System.Controller;

import com.Airtribe.Student_Management_System.Entity.Enrollment;
import com.Airtribe.Student_Management_System.Entity.Student;
import com.Airtribe.Student_Management_System.Helper.Status;
import com.Airtribe.Student_Management_System.Service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    private IEnrollmentService enrollmentService;

    @PostMapping("/enrollStudentInCourse/{studentId}/{courseId}")
    public ResponseEntity<Enrollment> enrollStudentInCourse(@PathVariable Long studentId, @PathVariable Long courseId) throws Exception {
        Enrollment enrollment = enrollmentService.enrollStudentInCourse(studentId, courseId);
        return new ResponseEntity<>(enrollment, HttpStatus.OK);
    }

    @GetMapping("/getAllEnrollments")
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @PutMapping("/changeEnrollmentStatus/{studentId}/{courseId}/{status}")
    public ResponseEntity<Enrollment> changeEnrollmentStatus(@PathVariable Long studentId, @PathVariable Long courseId, @PathVariable Status status) throws Exception {
        Enrollment enrollment = enrollmentService.changeEnrollmentStatus(studentId, courseId, status);
        return new ResponseEntity<>(enrollment, HttpStatus.OK);
    }

    @GetMapping("/getEnrollmentsByStudentId/{studentId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByStudentId(@PathVariable Long studentId) throws Exception {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudent(studentId);
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @GetMapping("/getEnrollmentsByCourseId/{courseId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByCourseId(@PathVariable Long courseId) throws Exception {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByCourse(courseId);
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @GetMapping("/getActiveStudentsByCourseId/{courseId}")
    public ResponseEntity<List<Student>> getActiveStudentsByCourseId(@PathVariable Long courseId) throws Exception {
        List<Student> enrollments = enrollmentService.getActiveStudentsByCourse(courseId);
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }
}
