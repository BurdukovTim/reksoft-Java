package com.reksoft.exporter.repository.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamDto {
    private Integer id;
    private String name;
    private List<PlayerDto> players;
    private List<TournamentParticipantInfoDto> teamTournamentResults;
    private List<RatingDto> teamRatings;
    private List<MatchHistoryDto> matchesWon;
    private List<MatchHistoryDto> matchesLost;
}
