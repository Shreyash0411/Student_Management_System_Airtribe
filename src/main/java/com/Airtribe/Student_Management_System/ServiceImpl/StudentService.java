package com.Airtribe.Student_Management_System.ServiceImpl;

import com.Airtribe.Student_Management_System.Entity.Student;
import com.Airtribe.Student_Management_System.Repository.StudentRepository;
import com.Airtribe.Student_Management_System.Service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createNewStudent(Student student) {
        Student newStudent = new Student();

        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setEmail(student.getEmail());
        newStudent.setPhoneNo(student.getPhoneNo());
        newStudent.setBirthDate(student.getBirthDate());
        newStudent.setRollNumber(student.getRollNumber());
        newStudent.setGender(student.getGender());
        newStudent.setDepartment(student.getDepartment());
        LocalDateTime createdAt = LocalDateTime.now();
        newStudent.setCreatedAt(createdAt);

        Student savedStudent = studentRepository.save(newStudent);
        return savedStudent;
    }

    @Override
    public Student findStudentById(Long studentId) throws Exception {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            return student.get();
        }
        throw new Exception("Student does not exist with that id" + studentId);
    }

    @Override
    public Student findStudentByEmail(String email)  throws Exception{
        Student student = studentRepository.findByEmail(email);
        if (student != null) {
            return student;
        }
        throw new Exception("Student does not exist with that email" + email);
    }

    @Override
    public Student findStudentByRolllNumber(String rollNumber) throws Exception{
        Student student = studentRepository.findByRollNumber(rollNumber);
        if (student != null) {
            return student;
        }
        throw new Exception("Student does not exist with that roll number" + rollNumber);
   }

    @Override
    public Student updateStudent(Long studentId, Student student) throws Exception {
        Optional<Student> currentStudent = studentRepository.findById(studentId);

        if (currentStudent.isEmpty()) {
            throw new Exception("Student not found with id: " + studentId);
        }

        Student oldStudent = currentStudent.get();

        if (student.getFirstName() != null) {
            oldStudent.setFirstName(student.getFirstName());
        }

        if (student.getLastName() != null) {
            oldStudent.setLastName(student.getLastName());
        }

        if (student.getEmail() != null) {
            oldStudent.setEmail(student.getEmail());
        }

        if (student.getPhoneNo() != null) {
            oldStudent.setPhoneNo(student.getPhoneNo());
        }

        if (student.getBirthDate() != null) {
            oldStudent.setBirthDate(student.getBirthDate());
        }

        if (student.getRollNumber() != null) {
            oldStudent.setRollNumber(student.getRollNumber());
        }

        if (student.getGender() != null) {
            oldStudent.setGender(student.getGender());
        }

        if (student.getDepartment() != null) {
            oldStudent.setDepartment(student.getDepartment());
        }

        LocalDateTime modifyAt = LocalDateTime.now();
        oldStudent.setModifyAt(modifyAt);

        return studentRepository.save(oldStudent);
    }

    @Override
    public List<Student> getAllStudents() {

        List<Student> students = studentRepository.findAll();
        if (!students.isEmpty()) {
            return students;
        }
        return List.of();
    }

    @Override
    public List<Student> getAllStudentsByDepartment(Long departmentId) {
        List<Student> students = studentRepository.findByDepartmentId(departmentId);

        return students;
    }

    @Override
    public String deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        studentRepository.delete(student);
        return "Student Deleted";
    }
}
