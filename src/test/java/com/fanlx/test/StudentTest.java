package com.fanlx.test;

import com.alibaba.fastjson.JSON;
import com.fanlx.entity.Student;
import com.fanlx.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by fanlx on 26/02/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class StudentTest {
    @Resource
    private StudentService studentService;

    @Test
    public void listStudent() {
        int pageNum = 1, pageSize = 10;
        PageInfo<Student> pageInfo = studentService.getStudentPage(pageNum, pageSize);
        System.out.println(JSON.toJSONString(pageInfo));
    }
}
