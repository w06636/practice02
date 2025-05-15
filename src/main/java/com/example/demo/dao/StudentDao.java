package com.example.demo.dao;

import com.example.demo.Student;
import com.example.demo.model.Student2;

public interface StudentDao {

    Student2 getById(Integer studentId);

    Student findById(Integer studentId);
}
