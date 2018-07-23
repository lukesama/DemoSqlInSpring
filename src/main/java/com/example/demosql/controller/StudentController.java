package com.example.demosql.controller;

import com.example.demosql.entity.Grade;
import com.example.demosql.entity.Student;
import com.example.demosql.repositroy.StudentRepositroy;
import com.example.demosql.service.GradeService;
import com.example.demosql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping
public class StudentController {
@Autowired
private StudentService studentService;
@Autowired
private GradeService gradeService;
    @GetMapping
    public String getAllStu(Model model){
        List<Student> stu =studentService.getAllStudent();
        model.addAttribute("grade",gradeService.getAllGrade());
        model.addAttribute("stu",stu);
        return "index";
    }

    @GetMapping("add")
    public String  addPage(Model model){
        List<Grade> grade=gradeService.getAllGrade();
        model.addAttribute("grade",grade);
        return "addStu";
    }

    @PostMapping("add")
    public String addStu(Student student){
        studentService.addStudentInfo(student);
        return "redirect:/";
    }
    @GetMapping("update/{id}")
    public String updatePage(@PathVariable("id") Integer id,Model model){
        Student stu=studentService.getStudentById(id);
        List<Grade> grade=gradeService.getAllGrade();
        model.addAttribute("stu",stu);
        model.addAttribute("grade",grade);
        return "updateStu";
    }

    @PostMapping("update")
    public String updateStu(Student student){
        studentService.updateStudentInfo(student);
        return "redirect:/";
    }
    @GetMapping("delete/{id}")
    public String deletePage(@PathVariable("id")  Integer id){
        studentService.deleteById(id);
        return  "redirect:/";
    }
}
