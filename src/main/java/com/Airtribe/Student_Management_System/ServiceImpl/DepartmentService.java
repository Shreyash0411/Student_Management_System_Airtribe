package com.Airtribe.Student_Management_System.ServiceImpl;

import com.Airtribe.Student_Management_System.Entity.Course;
import com.Airtribe.Student_Management_System.Entity.Department;
import com.Airtribe.Student_Management_System.Entity.Student;
import com.Airtribe.Student_Management_System.Entity.Teacher;
import com.Airtribe.Student_Management_System.Helper.DepartmentRequestDTO;
import com.Airtribe.Student_Management_System.Repository.DepartmentRepository;
import com.Airtribe.Student_Management_System.Service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department createNewDepartment(DepartmentRequestDTO department) {
        Department newDepartment = new Department();

        newDepartment.setName(department.getName());
        newDepartment.setCode(department.getCode());
        newDepartment.setDescription(department.getDescription());

        Department savedDepartment = departmentRepository.save(newDepartment);
        return savedDepartment;
    }

    @Override
    public String deleteDepartment(Long departmentId) {

        Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isEmpty()){
            return "Department with that id not found";
        }

        List<Student> students = department.get().getStudents();
        if (!students.isEmpty()){
            return "Department has students so can't delete the department";
        }

        List<Course> courses = department.get().getCourses();
        if (!courses.isEmpty()){
            return "Department has courses so can't delete the department";
        }

        List<Teacher> teachers = department.get().getTeachers();
        if (!teachers.isEmpty()){
            return "Department has teachers so can't delete the department";
        }

        departmentRepository.delete(department.get());
        return "Department Deleted Successfully";
    }

    @Override
    public Department updateDepartment(Long departmentId, DepartmentRequestDTO department)  throws Exception {
        Optional<Department> currentDepartment = departmentRepository.findById(departmentId);
        if (currentDepartment.isEmpty()){
            throw new Exception("Department with that id not found");
        }

        Department oldDepartment = currentDepartment.get();

        oldDepartment.setName(department.getName());
        oldDepartment.setCode(department.getCode());
        oldDepartment.setDescription(department.getDescription());

        Department updatedDepartment = departmentRepository.save(oldDepartment);
        return updatedDepartment;
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        if (departments.isEmpty()){
            return List.of();
        }
        return departments;
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
       Optional<Department> department = departmentRepository.findById(departmentId);
       if (department.isEmpty()){
           return null;
       }
       return department.get();
    }

    @Override
    public List<Student> getStudentsByDepartment(Long departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isEmpty()) {
            return null;
        }
        return department.get().getStudents();
    }

    @Override
    public List<Course> getCoursesByDepartment(Long departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isEmpty()) {
            return null;
        }
        return department.get().getCourses();
    }

    @Override
    public List<Teacher> getTeachersByDepartment(Long departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isEmpty()) {
            return null;
        }
        return department.get().getTeachers();
    }
}
