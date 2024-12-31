package com.example.shiyan002.;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentDAOTest {
    private StudentDAO studentDAO;

    @Before
    public void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentDAO = (StudentDAO) context.getBean("studentDAO");
    }

    @Test
    public void testCreateTable() {
        studentDAO.createTable();
    }

    @Test
    public void testInsertData() {
        studentDAO.insertData();
    }

    @Test
    public void testUpdateData() {
        studentDAO.updateData();
    }

    @Test
    public void testQueryData() {
        studentDAO.queryData();
    }

    @Test
    public void testDeleteData() {
        try {
            studentDAO.deleteData();
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
