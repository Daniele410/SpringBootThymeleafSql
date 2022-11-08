package com.danozzo.sms.service;

import com.danozzo.sms.model.Student;
import com.danozzo.sms.model.Teacher;

import java.util.List;

public interface ITeacherService {

    List<Teacher> getAllTeacher();

    Teacher saveTeacher(Teacher teacher);

    Teacher getTeacherById(Long id);

    Teacher updateTeacher(Teacher teacher);

    void deleteTeacherById(Long id);

}
