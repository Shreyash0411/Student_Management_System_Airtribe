package com.Airtribe.Student_Management_System.Controller;

import com.Airtribe.Student_Management_System.Entity.Course;
import com.Airtribe.Student_Management_System.Entity.Student;
import com.Airtribe.Student_Management_System.Helper.CourseRequestDTO;
import com.Airtribe.Student_Management_System.Service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @PostMapping("/addCourse")
    public ResponseEntity<Course> addCourse(@RequestBody CourseRequestDTO course) {
        Course newCourse = courseService.createNewCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.OK);
    }

    @GetMapping("/getCourseById/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long courseId) throws Exception {
        Course course = courseService.getCourseById(courseId);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("/getAllCourses")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PutMapping("/updateCourse/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long courseId, @RequestBody CourseRequestDTO course) throws Exception {
        Course updatedCourse = courseService.updateCourse(courseId, course);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long courseId) throws Exception {
        String message = courseService.deleteCourse(courseId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/getCoursesByDepartment/{departmentId}")
    public ResponseEntity<List<Course>> getCoursesByDepartment(@PathVariable Long departmentId) throws Exception {
        List<Course> courses = courseService.getCoursesByDepartment(departmentId);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/getCourseByCourseCode/{courseCode}")
    public ResponseEntity<Course> getCourseByCourseCode(@PathVariable String courseCode) throws Exception {
        Course course = courseService.getCourseByCourseCode(courseCode);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("/getCoursesByTeacher/{teacherId}")
    public ResponseEntity<List<Course>> getCoursesByTeacher(@PathVariable Long teacherId) throws Exception {
        List<Course> courses = courseService.getCoursesByTeacher(teacherId);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PutMapping("/assignTeacherToCourse/{teacherId}/{courseId}")
    public ResponseEntity<String> assignTeacherToCourse(@PathVariable Long teacherId, @PathVariable Long courseId) throws Exception {
        String message = courseService.assignTeacherToCourse(teacherId, courseId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/getStudentEnrolledInCourse/{courseId}")
    public ResponseEntity<List<Student>> getStudentEnrolledInCourse(@PathVariable Long courseId) throws Exception {
        List<Student> students = courseService.getStudentEnrolledInCourse(courseId);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

}
