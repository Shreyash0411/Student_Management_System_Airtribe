package com.Airtribe.Student_Management_System.Service;

import com.Airtribe.Student_Management_System.Entity.Course;
import com.Airtribe.Student_Management_System.Entity.Student;
import com.Airtribe.Student_Management_System.Helper.CourseRequestDTO;

import java.util.List;

public interface ICourseService
{
    Course createNewCourse(CourseRequestDTO course);

    Course getCourseById(Long Id) throws Exception;

    List<Course> getAllCourses();

    Course updateCourse(Long id, CourseRequestDTO course) throws Exception;

    String deleteCourse(Long id);

    List<Course> getCoursesByDepartment(Long departmentId);

    Course getCourseByCourseCode(String courseCode);

    List<Course> getCoursesByTeacher(Long teacherId);

    String assignTeacherToCourse(Long teacherId, Long courseId);

    List<Student> getStudentEnrolledInCourse(Long courseId);
}
