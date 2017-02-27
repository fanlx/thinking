package com.fanlx.controller;

import com.fanlx.entity.Student;
import com.fanlx.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by fanlx on 24/02/2017.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    private static Logger log = LoggerFactory.getLogger(StudentController.class);

    @Resource
    private StudentService studentService;

    @RequestMapping("/listStudent")
    public String listStudent(Model model, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        log.info("query all students");
        PageInfo<Student> pageInfo = studentService.getStudentPage(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "list_student";
    }
}
