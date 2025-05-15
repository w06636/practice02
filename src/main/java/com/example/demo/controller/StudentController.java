package com.example.demo.controller;

import com.example.demo.Student;
import com.example.demo.StudentRepository;
import com.example.demo.mapper.StudentRowMapper;
import com.example.demo.model.Student2;
import com.example.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// JDBC單筆
@RestController
public class StudentController {
	

    private final static Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private StudentService studentService; // 注入Interface層

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/students2")
    public String insert(@RequestBody Student2 student2) {

        String sql = "insert into student (name) value (:studentName)";

        Map<String, Object> map = new HashMap<>();
        map.put("studentName", student2.getName());

        KeyHolder k = new GeneratedKeyHolder(); // 取得自動生成的id的值
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), k);

        int id = k.getKey() != null ? k.getKey().intValue() : 0;
        System.out.println("id: " + id);

        return "執行 insert";
    }

    @PostMapping("/students2/batch")
    public String insertList(@RequestBody List<Student2> studentList) {

        String sql = "insert into student (name) value (:studentName)";

        MapSqlParameterSource[] ms = new MapSqlParameterSource[studentList.size()];
        for (int i = 0; i < studentList.size(); i++) {
            Student2 student2 = studentList.get(i);
            ms[i] = new MapSqlParameterSource();
            ms[i].addValue("studentName", student2.getName());
        }
        namedParameterJdbcTemplate.batchUpdate(sql, ms);

        return "執行 insertList";
    }

    @DeleteMapping("/students2/{studentId}")
    public String delete(@PathVariable Integer studentId) {

        String sql = "delete from student where id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);

        namedParameterJdbcTemplate.update(sql, map);

        return "執行 delete";
    }

    @GetMapping("/students2/getAll")
    public List<Student2> select() {

        String sql = "select id as id, name as name from student";
        Map<String, Object> map = new HashMap<>();

        return namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
    }

    @GetMapping("/students2/selectStudent/{studentId}")
    public Student2 selectStudent(@PathVariable Integer studentId) {

        return studentService.getById(studentId);
    }

    @GetMapping("/students2/selectCount")
    public Integer selectCount() {

        String sql = "select count(*) from student";
        Map<String, Object> map = new HashMap<>();

        return namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);
    }

    @GetMapping("/student2/{studentId}")
    public Student read(@PathVariable Integer studentId) {

        log.info("取得student {}", studentId);

        return studentRepository.findById(studentId).orElse(null);
    }
}
