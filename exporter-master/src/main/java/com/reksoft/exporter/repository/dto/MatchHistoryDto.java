package com.reksoft.exporter.repository.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MatchHistoryDto {
    private Integer id;
    private Integer winnerId;
    private Integer loserId;
    private Integer tournamentId;
    private LocalDateTime date;
    private TeamDto winner;
    private TeamDto loser;
    private TournamentDto tournament;
}
