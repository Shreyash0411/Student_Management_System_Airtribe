package com.Airtribe.Student_Management_System.Controller;

import com.Airtribe.Student_Management_System.Entity.Course;
import com.Airtribe.Student_Management_System.Entity.Teacher;
import com.Airtribe.Student_Management_System.Helper.TeacherRequestDTO;
import com.Airtribe.Student_Management_System.Service.ITeacherService;
import com.Airtribe.Student_Management_System.ServiceImpl.TeacherService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    @PostMapping("/addTeacher")
    public ResponseEntity<Teacher> addTeacher(@RequestBody TeacherRequestDTO teacher) {
        Teacher newTeacher = teacherService.createTeacher(teacher);
        return new ResponseEntity<>(newTeacher, HttpStatus.OK);
    }

    @GetMapping("id/{teacherId}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long teacherId) throws Exception {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @GetMapping("email/{email}")
    public ResponseEntity<Teacher> getTeacherByEmail(@PathVariable String email) throws Exception {
        Teacher teacher = teacherService.getTeacherByEmail(email);
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @GetMapping("getAllTeachers")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        if (teachers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("getAllTeachersByDepartment/{departmentId}")
    public ResponseEntity<List<Teacher>> getAllTeachersByDepartment(@PathVariable Long departmentId) {
        List<Teacher> teachers = teacherService.getTeachersByDepartment(departmentId);
        if (teachers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @PutMapping("updateTeacher/{teacherId}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long teacherId, @RequestBody TeacherRequestDTO teacher) throws Exception {
        Teacher existingTeacher = teacherService.getTeacherById(teacherId);
        if (existingTeacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Teacher updatedTeacher = teacherService.updateTeacher(teacherId, teacher);
        return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);
    }

    @DeleteMapping("deleteTeacher/{teacherId}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long teacherId) throws Exception {
        String message = teacherService.deleteTeacher(teacherId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("getCoursesTaughtByTeacher/{teacherId}")
    public ResponseEntity<List<Course>> getCoursesTaughtByTeacher(@PathVariable Long teacherId) throws Exception {
        List<Course> courses = teacherService.getCoursesTaughtByTeacher(teacherId);
        if (courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
