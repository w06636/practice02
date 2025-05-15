package com.example.demo.dao;

import com.example.demo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StudentDaoImplTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void getById() {

        Student s = studentDao.findById(4);
        assertNotNull(s);
        assertEquals("mmm", s.getName());
        assertEquals(87.2, s.getScore());
    }
}