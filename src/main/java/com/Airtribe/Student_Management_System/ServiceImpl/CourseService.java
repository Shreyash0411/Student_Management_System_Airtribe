package com.Airtribe.Student_Management_System.ServiceImpl;

import com.Airtribe.Student_Management_System.Entity.Course;
import com.Airtribe.Student_Management_System.Entity.Enrollment;
import com.Airtribe.Student_Management_System.Entity.Student;
import com.Airtribe.Student_Management_System.Entity.Teacher;
import com.Airtribe.Student_Management_System.Helper.Status;
import com.Airtribe.Student_Management_System.Repository.CourseRepository;
import com.Airtribe.Student_Management_System.Repository.EnrollmentRepository;
import com.Airtribe.Student_Management_System.Repository.TeacherRepository;
import com.Airtribe.Student_Management_System.Service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CourseService implements ICourseService
{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public Course createNewCourse(Course course) {
        Course newCourse = new Course();

        newCourse.setCourseCode(course.getCourseCode());
        newCourse.setCourseName(course.getCourseName());
        newCourse.setCourseDescription(course.getCourseDescription());
        newCourse.setDepartment(course.getDepartment());
        newCourse.setTeacher(course.getTeacher());
        Course savedCourse = courseRepository.save(newCourse);

        return savedCourse;
    }

    @Override
    public Course getCourseById(Long Id) throws Exception {

        Optional<Course> course = courseRepository.findById(Id);
        if (course.isPresent()) {
            return course.get();
        }
        throw new RuntimeException("Course does not exist with that id" + Id);
    }

    @Override
    public List<Course> getAllCourses() {

        List<Course> courses = courseRepository.findAll();
        if (!courses.isEmpty()) {
            return courses;
        }
        return List.of();
    }

    @Override
    public Course updateCourse(Long id, Course course) throws Exception {

        Optional<Course> courseToUpdate = courseRepository.findById(id);
        if (courseToUpdate.isPresent()) {
            courseToUpdate.get().setCourseCode(course.getCourseCode());
            courseToUpdate.get().setCourseName(course.getCourseName());
            courseToUpdate.get().setCourseDescription(course.getCourseDescription());
            courseToUpdate.get().setDepartment(course.getDepartment());
            courseToUpdate.get().setTeacher(course.getTeacher());
            return courseRepository.save(courseToUpdate.get());
        }
        throw new Exception("Course does not exist with that id" + id);
    }

    @Override
    public String deleteCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isEmpty()) {
            return "Course does not exist with that id";
        }

        List<Enrollment> enrollments = enrollmentRepository.findByCourseIdAndStatus(id, Status.Active);
        if (!enrollments.isEmpty()) {
            return "Course has active enrolled students and cannot be deleted";
        }
        courseRepository.deleteById(id);
        return "course is successfully deleted";
    }

    @Override
    public List<Course> getCoursesByDepartment(Long departmentId) {

        List<Course> courses = courseRepository.findByDepartmentId(departmentId);
        if (!courses.isEmpty()) {
            return courses;
        }
        return List.of();
    }

    @Override
    public Course getCourseByCourseCode(String courseCode) {

        Course course = courseRepository.findByCourseCode(courseCode);
        if (course != null) {
            return course;
        }
        return null;
    }

    @Override
    public List<Course> getCoursesByTeacher(Long teacherId) {

        List<Course> courses = courseRepository.findByTeacherId(teacherId);
        if (!courses.isEmpty()) {
            return courses;
        }
        return List.of();
    }

    @Override
    public String assignTeacherToCourse(Long teacherId, Long courseId) {

        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isEmpty()) {
            return "Course does not exist with that id";
        }

        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        if (teacher.isEmpty()) {
            return "Teacher does not exist with that id";
        }
        course.get().setTeacher(teacher.get());
        courseRepository.save(course.get());
        return "";
    }


    // to do : check this before going to other services
    @Override
    public List<Student> getStudentEnrolledInCourse(Long courseId) {

        List<Enrollment> enrollments = enrollmentRepository.findByCourseIdAndStatus(courseId, Status.Active);
        if (!enrollments.isEmpty()) {
            var res =  enrollments.stream().map(Enrollment::getStudent).toList();
            return res;
        }
        return List.of();
    }
}
