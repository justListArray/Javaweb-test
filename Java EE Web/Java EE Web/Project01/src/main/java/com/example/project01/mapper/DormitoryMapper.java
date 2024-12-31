package com.example.project01.mapper;

import com.example.project01.POJO.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DormitoryMapper {
    @Select("Select ID, image, name, dormitoryNumber, roomNumber, gender From student")
     public List<Student> getStudents();

    @Insert("INSERT INTO student (ID, image, name, dormitoryNumber, roomNumber, gender) VALUES (#{ID}, #{image}, #{name}, #{dormitoryNumber}, #{roomNumber}, #{gender})")
    public void addStudent(Student student);

    @Delete("DELETE FROM student WHERE ID = #{ID}")
    public void deleteStudent(Integer ID);

    @Select("SELECT name, dormitoryNumber, roomNumber, gender FROM student WHERE roomNumber = #{roomNumber}")
    public List<Student> searchStudent(String roomNumber);

}
