package com.reksoft.exporter.repository;

import com.reksoft.exporter.repository.dto.TeamViewDto;

import java.util.List;

public interface TeamRepository {
    List<TeamViewDto> getTeams();
}
