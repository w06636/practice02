package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getById() throws Exception {

        // 設定請求參數 創建一個http出來 設定URL路徑 header
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/students2/selectStudent/{studentId}", 2)
                .header("headerName", "headerValue")
                .queryParam("graduate", "true");

        // 發起http request (驗證結果)
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                // 輸出API執行結果
                .andDo(print())
                // 驗證結果
                .andExpect(status().is(200))
                // 第一個參數:想要取得json中的key值，第二個參數:預期結果值
                // https://jsonpath.com/
                .andExpect(jsonPath("$.id", equalTo(2)))
                .andExpect(jsonPath("$.name", notNullValue()))
                .andReturn();

        String body = mvcResult.getResponse().getContentAsString();
        System.out.println("body: " + body);
    }

    @Test
    public void create() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/students2")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"name\": \"qqq\"\n" +
                        "}");
        mockMvc.perform(requestBuilder)
                .andExpect(status().is(503));
    }
}