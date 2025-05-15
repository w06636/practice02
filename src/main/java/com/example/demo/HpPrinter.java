package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HpPrinter implements Printer {

//    @Value("${printer.name}")
//    private String name;
//
//    @Value("${printer.count:20}")
//    private int count;

//    @PostConstruct
//    public void init() {
//        System.out.println("初始化....");
//        count = 5;
//    }

    @Override
    public void print(String message) {

        System.out.println("HP印表機: " + message);

//        count--;
//        System.out.println("name: " + name);
//        System.out.println("HP印表機: " + message);
//        System.out.println("剩餘使用次數: " + count);
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        count = 5;
//    }
}
