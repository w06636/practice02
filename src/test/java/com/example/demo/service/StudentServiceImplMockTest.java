package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StudentServiceImplMockTest {

    @Autowired
    private StudentService studentService;

    @MockitoBean
    private StudentDao studentDao;

    @BeforeEach
    public void beforeEach() {

        Student2 mStudent2 = new Student2();
        mStudent2.setId(3);
        mStudent2.setName("mmm");

        // 可返回固定的查詢結果，降低與Dao層的耦合度
        Mockito.when(studentDao.getById(Mockito.any())).thenReturn(mStudent2);
    }

    @Test
    public void getById() {

        Student2 student2 = studentService.getById(2);
        assertNotNull(student2);
        assertEquals(3, student2.getId());
    }

    @Test
    public void getById2() {

        Student2 student2 = studentService.getById(3);
        assertNotNull(student2);
        assertEquals(3, student2.getId());
    }
}