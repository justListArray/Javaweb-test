package com.example.project01.controller;

import com.example.project01.POJO.Result;
import com.example.project01.POJO.Student;
import com.example.project01.service.DormitoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;

    @GetMapping("/getStudents")
    public Result getStudents() {
        List<Student> studentList = dormitoryService.getStudents();
        return Result.success(studentList);
    }

    @GetMapping("/deleteStudent")
    public Result deleteStudent(@RequestParam Integer ID) {
        dormitoryService.deleteStudent(ID);
        return Result.success();
    }

    @GetMapping("/searchStudent")
    public Result searchStudent(@RequestParam String roomNumber) {
        List<Student> studentList = dormitoryService.searchStudent(roomNumber);
        return Result.success(studentList);
    }

    @PostMapping("/addStudent")
    public Result addStudent(@RequestParam Integer ID,
                             @RequestParam String image,
                             @RequestParam String name,
                             @RequestParam String dormitoryNumber,
                             @RequestParam String roomNumber,
                             @RequestParam String gender) {
        Student student = new Student(ID,image,name,dormitoryNumber,roomNumber,gender);
        dormitoryService.addStudent(student);
        return Result.success();
    }
}
