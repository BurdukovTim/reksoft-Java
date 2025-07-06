package com.reksoft.exporter.model;

import lombok.Data;
import java.util.List;

@Data
public class Team {
    private Integer id;
    private String name;
    private List<Player> players;
}
