package com.Airtribe.Student_Management_System.ServiceImpl;

import com.Airtribe.Student_Management_System.Entity.Course;
import com.Airtribe.Student_Management_System.Entity.Teacher;
import com.Airtribe.Student_Management_System.Repository.CourseRepository;
import com.Airtribe.Student_Management_System.Repository.TeacherRepository;
import com.Airtribe.Student_Management_System.Service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements ITeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Teacher createTeacher(Teacher teacher) {
        Teacher newTeacher = new Teacher();

        newTeacher.setFirstName(teacher.getFirstName());
        newTeacher.setLastName(teacher.getLastName());
        newTeacher.setEmail(teacher.getEmail());
        newTeacher.setPhoneNo(teacher.getPhoneNo());
        newTeacher.setBirthDate(teacher.getBirthDate());
        newTeacher.setSpecialization(teacher.getSpecialization());
        newTeacher.setDepartment(teacher.getDepartment());
        newTeacher.setCreatedAt(teacher.getCreatedAt());

        Teacher savedTeacher = teacherRepository.save(newTeacher);
        return  savedTeacher;
    }

    @Override
    public Teacher getTeacherById(Long id) throws Exception {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            return teacher.get();
        }
        throw new Exception("Teacher does not exist with that id" + id);
    }

    @Override
    public Teacher getTeacherByEmail(String email) throws  Exception{
        Teacher teacher = teacherRepository.findByEmail(email);
        if(teacher != null) {
            return  teacher;
        }
        throw new Exception("Teacher does not exist with that email" + email);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        if (!teachers.isEmpty()) {
            return teachers;
        }
        return List.of();
    }

    @Override
    public List<Teacher> getTeachersByDepartment(Long departmentId) {
        List<Teacher> teachers = teacherRepository.findByDepartmentId(departmentId);
        if (!teachers.isEmpty()) {
            return teachers;
        }
        return List.of();
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher teacher) throws Exception {

        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
       Teacher existingTeacher = optionalTeacher.get();
        existingTeacher.setFirstName(teacher.getFirstName());
        existingTeacher.setLastName(teacher.getLastName());
        existingTeacher.setEmail(teacher.getEmail());
        existingTeacher.setPhoneNo(teacher.getPhoneNo());
        existingTeacher.setBirthDate(teacher.getBirthDate());
        existingTeacher.setSpecialization(teacher.getSpecialization());
        existingTeacher.setDepartment(teacher.getDepartment());
        existingTeacher.setModifyAt(teacher.getModifyAt());

        return teacherRepository.save(existingTeacher);
    }

    @Override
    public String deleteTeacher(Long id) {

        Teacher teacher = teacherRepository.findById(id).get();
        teacherRepository.delete(teacher);
        return "Teacher Deleted";
    }

    @Override
    public List<Course> getCoursesTaughtByTeacher(long id) {
        return courseRepository.findByTeacherId(id);
    }
}
