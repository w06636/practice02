package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController4 {

    @RequestMapping("/test21")
    public String test1() {
        System.out.println("執行 test1 方法");
        return "test1";
    }

    @RequestMapping("/test22")
    public String test2() {
        System.out.println("執行 test2 方法");
        return "test2";
    }
}
