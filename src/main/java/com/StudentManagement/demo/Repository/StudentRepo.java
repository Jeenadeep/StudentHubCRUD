package com.StudentManagement.demo.Repository;

import com.StudentManagement.demo.Model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    List<Student> list = new ArrayList<Student>();
    @PostConstruct
//    public void init() {
//        createStudent();
//    }

    public void createStudent() {
        list.add(new Student("Deepak", 14, 1, 9, 88, 89, 90, 99));
        list.add(new Student("Rahul", 14, 2, 9, 84, 45, 80, 79));
        list.add(new Student("Pankaj", 14, 3, 9, 84, 45, 80, 79));
    }


    public List<Student> getAllStudents() {
        return list;
    }

    public Student save(Student s) {
        Student stu = new Student();
        stu.setName(s.getName());
        stu.setAge(s.getAge());
        stu.setRollno(s.getRollno());
        stu.setClassname(s.getClassname());
        stu.setEnglish(s.getEnglish());
        stu.setHindi(s.getHindi());
        stu.setMaths(s.getMaths());
        stu.setScience(s.getScience());
        list.add(stu);
        return stu;


    }

    public Student findById(Integer rollno) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollno() == (rollno)) {
                return list.get(i);
            }
        }
        return null;
    }

    public Student update(Student student) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollno() == (student.getRollno())) {
                id = student.getRollno();
                idx = i;
                break;
            }
        }

        Student stu=new Student();
        stu.setName(student.getName());
        stu.setAge(student.getAge());
        stu.setRollno(student.getRollno());
        stu.setClassname(student.getClassname());
        stu.setEnglish(student.getEnglish());
        stu.setMaths(student.getMaths());
        stu.setHindi(student.getHindi());
        stu.setScience(student.getScience());
        list.set(idx,student);
        return stu;
    }

    public Student delete(int rollno) {
        list.removeIf(x -> x.getRollno() == (rollno));
        return null;
    }
}
