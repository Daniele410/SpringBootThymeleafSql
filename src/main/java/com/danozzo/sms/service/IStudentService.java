package com.danozzo.sms.service;

import com.danozzo.sms.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);
}
