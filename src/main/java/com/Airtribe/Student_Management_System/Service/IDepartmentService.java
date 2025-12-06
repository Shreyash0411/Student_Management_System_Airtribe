package com.Airtribe.Student_Management_System.Service;

import com.Airtribe.Student_Management_System.Entity.Course;
import com.Airtribe.Student_Management_System.Entity.Department;
import com.Airtribe.Student_Management_System.Entity.Student;
import com.Airtribe.Student_Management_System.Entity.Teacher;

import java.util.List;

public interface IDepartmentService
{
    Department createNewDepartment(Department departmentName);
    String deleteDepartment(Long departmentId);
    Department updateDepartment(Long departmentId, Department department) throws Exception;
    List<Department> getAllDepartments();
    Department getDepartmentById(Long departmentId);

    List<Student> getStudentsByDepartment(Long departmentId);
    List<Course> getCoursesByDepartment(Long departmentId);
    List<Teacher> getTeachersByDepartment(Long departmentId);

}
