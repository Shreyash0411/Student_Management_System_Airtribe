package com.Airtribe.Student_Management_System.Controller;

import com.Airtribe.Student_Management_System.Entity.Course;
import com.Airtribe.Student_Management_System.Entity.Department;
import com.Airtribe.Student_Management_System.Entity.Student;
import com.Airtribe.Student_Management_System.Entity.Teacher;
import com.Airtribe.Student_Management_System.ServiceImpl.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public ResponseEntity<Department> addDepartment(Department department) {
        Department newDepartment = departmentService.createNewDepartment(department);
        return new ResponseEntity<>(newDepartment, HttpStatus.OK);
    }

    @DeleteMapping("/deleteDepartment/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long departmentId) throws Exception {
        String message = departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/updateDepartment/{departmentId}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long departmentId, Department department) throws Exception {
        Department updatedDepartment = departmentService.updateDepartment(departmentId, department);
        if (updatedDepartment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    @GetMapping("/getAllDepartments")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/getDepartmentById/{departmentId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long departmentId) {
        Department department = departmentService.getDepartmentById(departmentId);
        if (department == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping("/getStudentsByDepartment/{departmentId}")
    public ResponseEntity<List<Student>> getStudentsByDepartment(@PathVariable Long departmentId) {
        List<Student> departments = departmentService.getStudentsByDepartment(departmentId);
        if (departments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/getTeachersByDepartment/{departmentId}")
    public ResponseEntity<List<Teacher>> getTeachersByDepartment(@PathVariable Long departmentId) {
        List<Teacher> departments = departmentService.getTeachersByDepartment(departmentId);
        if (departments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/getCoursesByDepartment/{departmentId}")
    public ResponseEntity<List<Course>> getCoursesByDepartment(@PathVariable Long departmentId) {
        List<Course> departments = departmentService.getCoursesByDepartment(departmentId);
        if (departments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

}
