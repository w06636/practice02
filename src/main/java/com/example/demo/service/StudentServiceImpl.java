package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao; // 使用Interface作為變數類型

    @Override
    public Student2 getById(Integer studentId) {

        return studentDao.getById(studentId);
    }
}
