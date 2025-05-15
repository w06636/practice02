package com.example.demo;

import com.example.demo.model.Student2;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController2 {

    @RequestMapping("/test1")
    public String test1(@RequestParam Integer id,
                        @RequestParam(defaultValue = "kkk", name = "testName", required = false) String name) {
        System.out.println("id: " + id);
        System.out.println("name: " + name);

        return "test1";
    }

    @RequestMapping("/test2")
    public String test2(@RequestBody Student2 student2) {
        System.out.println("student id: " + student2.getId());
        System.out.println("student name: " + student2.getName());
        return "test2";
    }

    @RequestMapping("/test3")
    public String test3(@RequestHeader(defaultValue = "application/json", name = "Content-Type") String info) {
        System.out.println("header: " + info);
        return "test3";
    }

    @RequestMapping("/test4/{userId}/{name}")
    public String test4(@PathVariable Integer userId,
                        @PathVariable String name) {
        System.out.println("id: " + userId);
        System.out.println("name: " + name);
        return "test4";
    }

//    @RequestMapping("/product")
//    public Store product() {
//
//        Store store = new Store();
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        store.setProductList(list);
//
//        return store;
//    }
//
//    @RequestMapping("/user")
//    public Student2 user() {
//
//        Student2 student2 = new Student2();
//        student2.setName("user");
//
//        return student2;
//    }
}
