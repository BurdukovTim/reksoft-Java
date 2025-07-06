package com.reksoft.exporter.repository.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RatingDto {
    private Integer id;
    private Integer score;
    private LocalDateTime atMoment;
    private Integer teamId;
    private TeamDto team;
}