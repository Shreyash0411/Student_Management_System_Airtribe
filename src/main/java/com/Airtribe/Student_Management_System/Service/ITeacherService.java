package com.Airtribe.Student_Management_System.Service;

import com.Airtribe.Student_Management_System.Entity.Course;
import com.Airtribe.Student_Management_System.Entity.Teacher;
import com.Airtribe.Student_Management_System.Helper.TeacherRequestDTO;

import java.util.List;

public interface ITeacherService
{
    Teacher createTeacher(TeacherRequestDTO teacher);

    Teacher getTeacherById(Long id) throws Exception;

    Teacher getTeacherByEmail(String email) throws Exception;

    List<Teacher> getAllTeachers();

    List<Teacher> getTeachersByDepartment(Long departmentId);

    Teacher updateTeacher(Long id, TeacherRequestDTO teacher) throws Exception;

    String deleteTeacher(Long id);

    List<Course> getCoursesTaughtByTeacher(long id);
}
