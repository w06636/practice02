package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController3 {

    @RequestMapping("/test11")
    public ResponseEntity<String> test() { // 可以使用ResponseEntity自定義http狀態碼
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("test11");
    }

    @RequestMapping("/test12")
    public String test1() {
        throw new RuntimeException("test12 error");
    }

    @RequestMapping("/test13")
    public String test2() {
        throw new IllegalArgumentException("test13 error");
    }
}
