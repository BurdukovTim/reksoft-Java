package com.reksoft.exporter.model;

import lombok.Data;

@Data
public class Player {
    private Integer id;
    private String fullName;
    private String nickName;
    private Integer country;
    private String teamName;
    private String combinedName;
}
