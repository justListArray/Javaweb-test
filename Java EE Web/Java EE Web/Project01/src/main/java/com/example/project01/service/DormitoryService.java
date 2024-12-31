package com.example.project01.service;

import com.example.project01.POJO.Student;

import java.util.List;

public interface DormitoryService {
    public List<Student> getStudents();

    public void addStudent(Student student);
    public void deleteStudent(Integer ID);
    public List<Student> searchStudent(String roomNumber);
}
