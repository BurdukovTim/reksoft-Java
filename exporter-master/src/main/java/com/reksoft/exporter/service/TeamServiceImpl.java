package com.reksoft.exporter.service;

import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.model.Team;
import com.reksoft.exporter.repository.TeamApiRepository;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import com.reksoft.exporter.repository.dto.TeamViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamApiRepository teamApiRepository;

    @Override
    public List<Team> getTeams() {
        List<TeamViewDto> teamViewDtos = teamApiRepository.getTeams();
        return teamViewDtos.stream()
                .map(this::mapTeamFromViewDto)
                .collect(Collectors.toList());
    }


    private Team mapTeamFromViewDto(TeamViewDto dto) {
        Team team = new Team();
        team.setId(dto.getId());
        team.setName(dto.getName());

        List<Player> players = dto.getPlayers() != null
                ? dto.getPlayers().stream()
                .map(this::mapPlayer)
                .collect(Collectors.toList())
                : Collections.emptyList();

        team.setPlayers(players);
        return team;
    }


    private Player mapPlayer(PlayerViewDto dto) {
        Player player = new Player();
        player.setId(dto.getId());
        player.setCombinedName(dto.getCombinedName());
        player.setNickName(dto.getNickName());
        player.setCountry(dto.getCountry());
        player.setTeamName(dto.getTeamName());

        String[] parts = dto.getCombinedName() != null ? dto.getCombinedName().trim().split("\\s+", 2) : new String[0];
        String firstName = parts.length > 0 ? parts[0] : "";
        String lastName = parts.length > 1 ? parts[1] : "";
        player.setFullName(firstName + " \"" + dto.getNickName() + "\" " + lastName);

        return player;
    }
}