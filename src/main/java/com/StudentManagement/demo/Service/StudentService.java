package com.StudentManagement.demo.Service;

import com.StudentManagement.demo.Model.Student;
import com.StudentManagement.demo.Repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public List<Student> getStudents() {
        return studentRepo.getAllStudents();
    }

    public String saveStudent(Student student) {
        studentRepo.save(student);
        return "data saved";
    }

    public Student findStudentbyId(Integer rollno) {
        return studentRepo.findById(rollno);
    }

    public Student updateStudent(Student student) {
        return studentRepo.update(student);
    }

    public String deleteStudent(int rollno) {
        studentRepo.delete(rollno);
        return "student data removed !!";
    }
}
