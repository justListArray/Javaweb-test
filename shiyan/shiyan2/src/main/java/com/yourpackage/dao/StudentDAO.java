package com.yourpackage.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public class StudentDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable() {
        String query = "CREATE TABLE student (stuno INT AUTO_INCREMENT PRIMARY KEY, stuname VARCHAR(50), birthday DATE, gender VARCHAR(10), score INT)";
        jdbcTemplate.execute(query);
    }

    public void insertData() {
        jdbcTemplate.update("INSERT INTO student (stuname, birthday, gender, score) VALUES (?, ?, ?, ?)", "Alice", "2000-07-15", "女", 100);
        jdbcTemplate.update("INSERT INTO student (stuname, birthday, gender, score) VALUES (?, ?, ?, ?)", "Bob", "1999-06-20", "男", 150);
        jdbcTemplate.update("INSERT INTO student (stuname, birthday, gender, score) VALUES (?, ?, ?, ?)", "Carol", "2001-07-25", "女", 200);
        jdbcTemplate.update("INSERT INTO student (stuname, birthday, gender, score) VALUES (?, ?, ?, ?)", "David", "1998-05-10", "男", 250);
        jdbcTemplate.update("INSERT INTO student (stuname, birthday, gender, score) VALUES (?, ?, ?, ?)", "Eve", "2002-08-30", "女", 300);
    }

    public void updateData() {
        jdbcTemplate.update("UPDATE student SET score = 377 WHERE stuno = (SELECT MAX(stuno) FROM student)");
    }

    public void queryData() {
        String query = "SELECT * FROM student WHERE gender = '女' AND MONTH(birthday) = 7";
        List<Map<String, Object>> students = jdbcTemplate.queryForList(query);
        for (Map<String, Object> student : students) {
            System.out.println(student);
        }
    }

    @Transactional
    public void deleteData() {
        jdbcTemplate.update("DELETE FROM student WHERE score > 200");
        // 模拟异常
        if (true) {
            throw new RuntimeException("模拟异常");
        }
    }
}

