package com.reksoft.exporter.properties;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@ConfigurationProperties("api")
public class ApiProperties {
    @NotBlank(message = "baseUrl must be set in application.properties")
    private String baseUrl;
}
