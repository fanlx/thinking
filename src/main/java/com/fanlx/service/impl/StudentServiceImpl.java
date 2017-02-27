package com.fanlx.service.impl;

import com.fanlx.entity.Student;
import com.fanlx.entity.mapper.StudentMapper;
import com.fanlx.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by fanlx on 24/02/2017.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    public PageInfo<Student> getStudentPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> students = studentMapper.listAll();
        PageInfo<Student> pageInfo = new PageInfo<Student>(students);
        return pageInfo;
    }

    public Student getStudent(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    public int save(Student student) {
        return studentMapper.insert(student);
    }
}
