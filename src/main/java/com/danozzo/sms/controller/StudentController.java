package com.danozzo.sms.controller;

import com.danozzo.sms.model.Student;
import com.danozzo.sms.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    //handler method to handle list students and return mode view

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        //create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";


    }

    @PostMapping
    public String saveStudent(@ModelAttribute("student") Student student) {
        //save a new student in database
        studentService.saveStudent(student);
        return "redirect:/students";
    }

}
