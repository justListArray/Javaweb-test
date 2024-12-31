package com.example.test2;

import com.example.test2.POJO.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT stuno, stuname, birthday, gender, score FROM student")
    public List<Student> getAllStudents();

    @Insert("INSERT INTO student (stuno, stuname, birthday, gender, score) VALUES (#{stuno}, #{stuname}, #{birthday}, #{gender}, #{score})")
    public void addStudent(Student student);

    @Delete("DELETE FROM student WHERE stuno = #{stuno}")
    public void deleteStudent(int stuno);

    @Update("UPDATE student SET score = #{score} WHERE stuno = #{stuno}")
    public void updateStudentScore(int stuno, int score);

    @Select("SELECT stuno, stuname, birthday, gender, score FROM student WHERE stuno = #{stuno}")
    public Student getStudentByStuno(int stuno);

    @Select("SELECT stuno, stuname, birthday, gender, score FROM student WHERE gender = '女' AND MONTH(birthday) = 7")
    public List<Student> getJulyFemaleStudents();
}
