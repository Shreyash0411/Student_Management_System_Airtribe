package com.Airtribe.Student_Management_System.Service;

import com.Airtribe.Student_Management_System.Entity.Student;
import com.Airtribe.Student_Management_System.Helper.StudentRequestDTO;

import java.util.List;

public interface IStudentService
{
    Student createNewStudent(StudentRequestDTO student);

    Student findStudentById(Long studentId) throws Exception;

    Student findStudentByEmail(String email) throws Exception;

    Student findStudentByRolllNumber(String rollNumber) throws Exception;

    Student updateStudent(Long studentId, StudentRequestDTO student) throws Exception;

    List<Student> getAllStudents();

    List<Student> getAllStudentsByDepartment(Long departmentId);

    String deleteStudent(Long studentId);
}
