package com.reksoft.exporter.repository.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TournamentDto {
    private Integer id;
    private String name;
    private String organizer;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<TournamentParticipantInfoDto> teamParticipantInfos;
    private List<TournamentPrizeDto> tournamentPrizes;
}
