package com.reksoft.exporter.repository.dto;

import lombok.Data;

@Data
public class TournamentPrizeDto {
    private Integer id;
    private Integer place;
    private Integer prize;
    private Integer tournamentId;
    private TournamentDto tournament;
}
