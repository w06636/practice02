package com.example.demo.resttemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {

    private static final Logger log = LoggerFactory.getLogger(RestTemplateController.class);

    @GetMapping("/getForObject")
    public String getForObject() {

        // 請求外部API
        RestTemplate restTemplate = new RestTemplate();
        Student student = restTemplate.getForObject(
                "https://mocki.io/v1/ee56844c-8faa-424b-8424-7a8e0ca8bca2",
                Student.class);

        if (student != null) {
            log.info("id: {}", student.getId());
            log.info("name: {}", student.getName());
            log.info("phone: {}", student.getContactPhone());
        }
        return "getForObject success";
    }
}
