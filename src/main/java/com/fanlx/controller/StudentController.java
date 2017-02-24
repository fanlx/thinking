package com.fanlx.controller;

import com.fanlx.entity.Student;
import com.fanlx.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public String listStudent(HttpServletRequest request, Model model) {
        log.info("query all students");
        List<Student> list = studentService.listStudent();
        model.addAttribute("list", list);
        return "list_student";
    }
}
