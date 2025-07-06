package com.reksoft.exporter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ExporterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExporterApplication.class, args);
    }

}
