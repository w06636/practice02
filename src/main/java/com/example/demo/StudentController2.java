package com.example.demo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class StudentController2 {

    @PostMapping("/student2")
//    @RequestMapping(value = "/student3", method = RequestMethod.POST)
    public String create(@RequestBody @Valid Student3 student3) { // 物件前可加上@Valid，物件裡面就可加上@NotNull

//        if (student3.getId() == null) {
//            throw new RuntimeException("xxx");
//        }
        return "create";
    }

    @GetMapping("/students/{studentId}")
    public String read(@PathVariable @Min(100) Integer studentId) { // 這邊如果有加上@Min，那在class上就要加@Validated
        return "read";
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student3 student3) {
        return "update";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        return "delete";
    }
}
