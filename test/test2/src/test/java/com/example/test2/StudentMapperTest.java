package com.example.test2;

import com.example.test2.POJO.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ApplicationContext applicationContext;

    @BeforeEach
    public void setUp() {
        // Ensure the database is in a known state before each test
    }

    @Test
    public void testGetAllStudents() {
        List<Student> students = studentMapper.getAllStudents();
        assertNotNull(students);
        assertFalse(students.isEmpty());
    }

    @Test
    public void testAddFiveStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", new Date(2000-1900, 6, 15), "女", 85));
        students.add(new Student(2, "Bob", new Date(1999-1900, 11, 20), "男", 90));
        students.add(new Student(3, "Carol", new Date(1998-1900, 6, 25), "女", 95));
        students.add(new Student(4, "David", new Date(2001-1900, 3, 10), "男", 100));
        students.add(new Student(5, "Eve", new Date(2002-1900, 7, 30), "女", 105));
        studentMapper.addStudent(students.get(0));
        studentMapper.addStudent(students.get(1));
        studentMapper.addStudent(students.get(2));
        studentMapper.addStudent(students.get(3));
        studentMapper.addStudent(students.get(4));
    }
    @Test
    public void testAddStudent() {
        Student student = new Student();
        student.setStuno(6); // Assuming auto-increment is disabled, otherwise remove this line
        student.setStuname("John");
        student.setBirthday(new Date());
        student.setGender("男");
        student.setScore(85);
        studentMapper.addStudent(student);

        Student fetchedStudent = studentMapper.getStudentByStuno(6);
        assertNotNull(fetchedStudent);
        assertEquals("John", fetchedStudent.getStuname());
    }

    @Test
    public void testDeleteStudent() {
        studentMapper.deleteStudent(1); // Assuming student with stuno 1 exists
        Student student = studentMapper.getStudentByStuno(1);
        assertNull(student);
    }

    @Test
    public void testUpdateStudentScore() {
        studentMapper.updateStudentScore(2, 95); // Assuming student with stuno 2 exists
        Student student = studentMapper.getStudentByStuno(2);
        assertNotNull(student);
        assertEquals(277, student.getScore());
    }

    @Test
    public void testGetStudentByStuno() {
        Student student = studentMapper.getStudentByStuno(3); // Assuming student with stuno 3 exists
        assertNotNull(student);
        assertEquals(3, student.getStuno());
    }

    @Test
    public void testGetJulyFemaleStudents() {
        List<Student> students = studentMapper.getJulyFemaleStudents();
        assertNotNull(students);
        for (Student student : students) {
            assertEquals("女", student.getGender());
            assertEquals(7, student.getBirthday().getMonth() + 1); // Month is 0-based
        }
    }
}
