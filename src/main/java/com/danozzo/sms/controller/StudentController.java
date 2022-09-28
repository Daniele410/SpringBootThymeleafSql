package com.danozzo.sms.controller;

import com.danozzo.sms.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    //handler method to handle list students and return mode view

    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }

}
