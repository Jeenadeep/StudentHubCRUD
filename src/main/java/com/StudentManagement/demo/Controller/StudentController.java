package com.StudentManagement.demo.Controller;

import com.StudentManagement.demo.Model.Student;
import com.StudentManagement.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
//@RequestMapping("/api/v1/getStudents")
public class StudentController {

    @Autowired
    StudentService studentService;

    // API to get all the data from the table
    @GetMapping("/")//getStudennt
    public String getAllData(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("p", students);
//        System.out.println("Received students from service: " + students);
        return "index";//students.toString();
    }

    @GetMapping("/Add-Student")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("Student", student);
        return "Add-Student";
    }

    //API to add Student detail in th table
    @PostMapping("/addDetail")
    public String addStudent(@ModelAttribute("Student") Student student) {

        studentService.saveStudent(student);
        return "redirect:/";
    }

    // API to find the detail with particular id
    @GetMapping("/findStudentbyID/{rollno}")
    public Student findStudentbyID(@PathVariable Integer rollno) {
        return studentService.findStudentbyId(rollno);


    }

    @GetMapping("/edit-Student/{rollno}")
    public String editStudent(@PathVariable int rollno, Model model) {
        Student student = studentService.findStudentbyId(rollno);
        System.out.println(student);
        model.addAttribute("Student", student);
        return "edit-Student";
    }


    // Api to update the data in the table
    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute("Student") Student student) {

        studentService.updateStudent(student);
        return "redirect:/";
    }

    //Api to delete a particular data in the table
    @GetMapping("/deleteStudent/{rollno}")

    public String deleteStudent(@PathVariable int rollno) {

        studentService.deleteStudent(rollno);
        return "redirect:/";
    }

}
