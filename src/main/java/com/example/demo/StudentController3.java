package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController3 {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/student3")
    public String insert(@RequestBody Student student) {

        studentRepository.save(student);

        return "insert3";
    }

    @PutMapping("/student3/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student) {

        Student s = studentRepository.findById(studentId).orElse(null);
        if (s != null) {
            s.setName(student.getName());
            studentRepository.save(s);

            return "update";
        }
        return "update fail";
    }

    @DeleteMapping("/student3/{studentId}")
    public String delete(@PathVariable Integer studentId) {

        studentRepository.deleteById(studentId);

        return "delete";
    }

    @GetMapping("/student3/{studentId}")
    public Student read(@PathVariable Integer studentId) {

        return studentRepository.findById(studentId).orElse(null);
    }
}
