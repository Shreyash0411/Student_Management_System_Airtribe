package com.Airtribe.Student_Management_System.ServiceImpl;

import com.Airtribe.Student_Management_System.Entity.Course;
import com.Airtribe.Student_Management_System.Entity.Teacher;
import com.Airtribe.Student_Management_System.Helper.TeacherRequestDTO;
import com.Airtribe.Student_Management_System.Repository.CourseRepository;
import com.Airtribe.Student_Management_System.Repository.DepartmentRepository;
import com.Airtribe.Student_Management_System.Repository.TeacherRepository;
import com.Airtribe.Student_Management_System.Service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements ITeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Teacher createTeacher(TeacherRequestDTO teacher) {
        Teacher newTeacher = new Teacher();

        newTeacher.setFirstName(teacher.getFirstName());
        newTeacher.setLastName(teacher.getLastName());
        newTeacher.setEmail(teacher.getEmail());
        newTeacher.setPhoneNo(teacher.getPhoneNo());
        newTeacher.setBirthDate(teacher.getBirthDate());
        newTeacher.setSpecialization(teacher.getSpecialization());

        if (teacher.getDepartmentId() != 0) {
            newTeacher.setDepartment(departmentRepository.findById(teacher.getDepartmentId()).get());
        }

        newTeacher.setCreatedAt(LocalDateTime.now());

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
        List<Teacher> teachers = teacherRepository.findByDepartment_Id(departmentId);
        if (!teachers.isEmpty()) {
            return teachers;
        }
        return List.of();
    }

    @Override
    public Teacher updateTeacher(Long id, TeacherRequestDTO teacher) throws Exception {

        Teacher existingTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new Exception("Teacher not found with id: " + id));

        if (teacher.getFirstName() != null && !teacher.getFirstName().isBlank()) {
            existingTeacher.setFirstName(teacher.getFirstName());
        }

        if (teacher.getLastName() != null && !teacher.getLastName().isBlank()) {
            existingTeacher.setLastName(teacher.getLastName());
        }

        if (teacher.getEmail() != null && !teacher.getEmail().isBlank()) {
            existingTeacher.setEmail(teacher.getEmail());
        }

        if (teacher.getPhoneNo() != null && !teacher.getPhoneNo().isBlank()) {
            existingTeacher.setPhoneNo(teacher.getPhoneNo());
        }

        if (teacher.getBirthDate() != null) {
            existingTeacher.setBirthDate(teacher.getBirthDate());
        }

        if (teacher.getSpecialization() != null && !teacher.getSpecialization().isBlank()) {
            existingTeacher.setSpecialization(teacher.getSpecialization());
        }

        if (teacher.getDepartmentId() != 0) {
            existingTeacher.setDepartment(departmentRepository.findById(teacher.getDepartmentId()).get());
        }

        existingTeacher.setModifyAt(LocalDateTime.now());

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
        return courseRepository.findByTeacher_Id(id);
    }
}
