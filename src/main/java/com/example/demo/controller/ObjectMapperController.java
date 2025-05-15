package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ObjectMapperController {

    private final static Logger log = LoggerFactory.getLogger(ObjectMapperController.class);

    @GetMapping("/convert")
    public String convert() {

        User user = new User();
        user.setId(1);
        user.setName("aaa");
        user.setContactEmail("test.com");

        // 物件轉字串
        ObjectMapper om = new ObjectMapper();
        String json = "";
        try {
            json = om.writeValueAsString(user);
            log.info("json: {}", json);
        } catch (Exception e) {
            log.error("convert error");
        }
        // 字串轉物件
        String str = "{\"id\":10,\"name\":\"bbb\",\"contact_email\":\"test.com\"}";
        try {
            User userResult = om.readValue(str, User.class);
            log.info("id: {}", userResult.getId());
            log.info("name: {}", userResult.getName());
            log.info("contact_email: {}", userResult.getContactEmail());

        } catch (Exception e) {
            log.error("userResult error");
        }
        return "convert success";
    }
}
