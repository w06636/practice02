package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class MyAspect {

    @Around("execution(* com.example.demo.HpPrinter.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before...");
        Date start = new Date();

        // 執行切入點的方法
        Object obj = pjp.proceed();

        Date end = new Date();
        long time = end.getTime() - start.getTime();
        System.out.println("around after...");
        System.out.println("執行: " + time + "ms");

        return obj;
    }

//    @Before("execution(* com.example.demo.HpPrinter.*(..))") // 切入點
//    public void before() {
//        System.out.println("before...");
//    }
//
//    @After("execution(* com.example.demo.HpPrinter.*(..))") // 切入點
//    public void after() {
//        System.out.println("after...");
//    }
}
