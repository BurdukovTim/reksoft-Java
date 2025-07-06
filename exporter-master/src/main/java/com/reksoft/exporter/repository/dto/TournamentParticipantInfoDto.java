package com.reksoft.exporter.repository.dto;

import lombok.Data;

@Data
public class TournamentParticipantInfoDto {
    private Integer id;
    private Integer standing;
    private Integer place;
    private Integer teamId;
    private Integer tournamentId;
    private TeamDto team;
    private TournamentDto tournament;
}