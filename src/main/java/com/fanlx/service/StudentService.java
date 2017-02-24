package com.fanlx.service;

import com.fanlx.entity.Student;

import java.util.List;

/**
 * Created by fanlx on 24/02/2017.
 */
public interface StudentService {

    List<Student> listStudent();

    Student getStudent(Integer id);

    int save(Student student);
}
