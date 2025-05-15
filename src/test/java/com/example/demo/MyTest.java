package com.example.demo;

import org.junit.jupiter.api.*;

public class MyTest {

    // 會先執行
    @BeforeEach
    public void beforeEach() {

        System.out.println("執行 beforeEach");
    }

    @AfterEach
    public void afterEach() {

        System.out.println("執行 afterEach");
    }

    @BeforeAll
    public static void beforeAll() {

        System.out.println("執行 beforeAll");
    }

    @AfterAll
    public static void afterAll() {

        System.out.println("執行 afterAll");
    }

    @Test
    public void test1() {

        System.out.println("執行 test1");
    }

    @Test
    public void test2() {

        System.out.println("執行 test2");
    }
}
