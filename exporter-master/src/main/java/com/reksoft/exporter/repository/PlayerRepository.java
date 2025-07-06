package com.reksoft.exporter.repository;

import com.reksoft.exporter.repository.dto.PlayerViewDto;

import java.util.List;

public interface PlayerRepository {

    List<PlayerViewDto> getPlayers();
}
