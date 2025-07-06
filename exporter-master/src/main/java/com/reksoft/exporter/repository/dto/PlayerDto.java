package com.reksoft.exporter.repository.dto;

import lombok.Data;

@Data
public class PlayerDto {
    private Integer id;
    private String name;
    private String surname;
    private String nickname;
    private Integer country;
    private Integer teamId;
    private TeamDto team;
}
