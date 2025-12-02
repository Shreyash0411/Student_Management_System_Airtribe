package com.Airtribe.Student_Management_System.Controller;
import com.Airtribe.Student_Management_System.Entity.Student;
import com.Airtribe.Student_Management_System.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController
{
    @Autowired
    private IStudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student newStudent = studentService.createNewStudent(student);
        return new ResponseEntity<>(newStudent,HttpStatus.OK);
    }

    @GetMapping("/student/id/{studentId}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long studentId) throws Exception{
        Student student = studentService.findStudentById(studentId);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @GetMapping("/student/email/{email}")
    public ResponseEntity<Student> findStudentByEmail(@PathVariable String email) throws Exception{
        Student student = studentService.findStudentByEmail(email);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @GetMapping("/student/rollNumber/{rollNumber}")
    public ResponseEntity<Student> findStudentByRollNumber(@PathVariable String rollNumber) throws Exception{
        Student student = studentService.findStudentByRolllNumber(rollNumber);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PutMapping("/updateStudent/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId,@RequestBody Student student) throws Exception{
        Student updatedStudent = studentService.updateStudent(studentId,student);
        return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @GetMapping("/getAllStudentsByDepartment/{departmentId}")
    public ResponseEntity<List<Student>> getAllStudentsByDepartment(@PathVariable Long departmentId){
        List<Student> students = studentService.getAllStudentsByDepartment(departmentId);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) throws Exception{
        String message = studentService.deleteStudent(studentId);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}
