package com.reksoft.exporter.service;

import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.repository.PlayerApiRepository;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerApiRepository playerApiRepository;

    @Override
    public List<Player> getPlayers() {
        List<PlayerViewDto> playerViewDtos = playerApiRepository.getPlayers();
        return playerViewDtos.stream().map(this::map).toList();
    }

    private Player map(PlayerViewDto dto) {
        Player player = new Player();
        player.setId(dto.getId());
        player.setCombinedName(dto.getCombinedName());
        player.setNickName(dto.getNickName());
        player.setCountry(dto.getCountry());
        player.setTeamName(dto.getTeamName());

        String[] parts = player.getCombinedName().trim().split("\\s+", 2);
        String firstName = parts[0];
        String lastName = parts[1];
        // Можно было бы обработать то, что у некоторых игроков незаполнены какие-то инициалы, но не в этой версии
        player.setFullName(firstName + " \"" + player.getNickName() + "\" " + lastName);

        return player;
    }
}
