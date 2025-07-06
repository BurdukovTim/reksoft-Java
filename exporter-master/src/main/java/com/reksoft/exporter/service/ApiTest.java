package com.reksoft.exporter.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiTest implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://51.250.0.63:5002/api/Teams";
        String json = restTemplate.getForObject(url, String.class);
        System.out.println("Response JSON from /api/Teams:");
        System.out.println(json);
    }
}
