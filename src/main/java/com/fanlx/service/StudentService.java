package com.fanlx.service;

import com.fanlx.entity.Student;
import com.github.pagehelper.PageInfo;

/**
 * Created by fanlx on 24/02/2017.
 */
public interface StudentService {

    PageInfo<Student> getStudentPage(int pageNum, int pageSize);

    Student getStudent(Integer id);

    int save(Student student);
}
