package com.reksoft.exporter.repository;

import com.reksoft.exporter.properties.ApiProperties;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Repository
@RequiredArgsConstructor
public class PlayerApiRepository implements PlayerRepository {

    private final RestTemplate restTemplate;
    private final ApiProperties apiProperties;

    public List<PlayerViewDto> getPlayers() {
        ResponseEntity<List<PlayerViewDto>> response = restTemplate.exchange(
                apiProperties.getBaseUrl() + "/api/Players",
                GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

    public List<PlayerViewDto> getFilteredPlayers(String filter) {
        String uri = UriComponentsBuilder.fromHttpUrl(apiProperties.getBaseUrl() + "/api/Players/filter")
                .queryParam("filter", filter)
                .toUriString();

        ResponseEntity<List<PlayerViewDto>> response = restTemplate.exchange(
                uri,
                GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

}
