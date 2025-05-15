package com.example.demo.mapper;

import com.example.demo.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDataRowMapper implements RowMapper<Student> {


    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setScore(rs.getDouble("score"));
        student.setGraduate(rs.getBoolean("graduate"));
        student.setCreateDate(rs.getDate("create_date"));

        return student;
    }
}
