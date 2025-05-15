package com.example.demo.mapper;

import com.example.demo.model.Student2;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// 取得資料庫中的數據
public class StudentRowMapper implements RowMapper<Student2> {

    @Override
    public Student2 mapRow(ResultSet rs, int rowNum) throws SQLException {
        // rs:從資料庫中取得的數據
        // rowNum:取得第幾筆數據
//        Integer id = rs.getInt("id");
//        String name = rs.getString("name");
//
//        Student2 student2 = new Student2();
//        student2.setId(id);
//        student2.setName(name);

        Student2 student2 = new Student2();
        student2.setId(rs.getInt("id"));
        student2.setName(rs.getString("name"));

        return student2;
    }
}
