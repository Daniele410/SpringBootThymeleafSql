package com.danozzo.sms.controller;

import com.danozzo.sms.model.Student;
import com.danozzo.sms.model.Teacher;
import com.danozzo.sms.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherController {
    @Autowired
    ITeacherService teacherService;

    @GetMapping("/teachers")
    public String showAllTeacher(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeacher());
        return "teachers";
    }

    //crate new teacher
    @GetMapping("/teachers/new")
    public String createNewTeacherForm(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "create_teacher";
    }

    @PostMapping("/teachers")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teacher/edit/{id}")
    public String editTeacherForm(@PathVariable Long id, Model model) {
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        return "edit_teacher";
    }

    @PostMapping("/teacher/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("teacher") Teacher teacher,
                                Model model) {

        // get teacher from database by id
        Teacher existingTeacher = teacherService.getTeacherById(id);
        existingTeacher.setId(id);
        existingTeacher.setFirstName(teacher.getFirstName());
        existingTeacher.setLastName(teacher.getLastName());
        existingTeacher.setEmail(teacher.getEmail());

        // save updated student object
        teacherService.updateTeacher(existingTeacher);
        return "redirect:/teachers";
    }


}
