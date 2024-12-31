package com.example.project01.service.implement;

import com.example.project01.POJO.Student;
import com.example.project01.mapper.DormitoryMapper;
import com.example.project01.service.DormitoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DormitoryServiceImplement implements DormitoryService {
    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public List<Student> getStudents(){
        return dormitoryMapper.getStudents();
    };

    @Override
    public void addStudent(Student student){
        dormitoryMapper.addStudent(student);
    }

    @Override
    public void deleteStudent(Integer ID){
        dormitoryMapper.deleteStudent(ID);
    }

    @Override
    public List<Student> searchStudent(String roomNumber){
         return  dormitoryMapper.searchStudent(roomNumber);
    }
}
