package com.reksoft.exporter.repository.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamViewDto {
    private Integer id;
    private String name;
    private List<PlayerViewDto> players;
}
