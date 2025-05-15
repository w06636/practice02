package com.example.demo.dao;

import com.example.demo.Student;
import com.example.demo.mapper.StudentDataRowMapper;
import com.example.demo.mapper.StudentRowMapper;
import com.example.demo.model.Student2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Student2 getById(Integer studentId) {
        String sql = "select id, name from student where id = :studentId";
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);

        List<Student2> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());

        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public Student findById(Integer studentId) {

        String sql = "select id, name, score, graduate, create_date from student where id = :studentId";
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);

        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentDataRowMapper());

        return !list.isEmpty() ? list.get(0) : null;
    }
}
