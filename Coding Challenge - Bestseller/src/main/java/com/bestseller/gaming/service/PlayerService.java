package com.bestseller.gaming.service;


import com.bestseller.gaming.advice.exception.AlreadyLinkedPlayerException;
import com.bestseller.gaming.advice.exception.PlayerNameMustBeUniqueException;
import com.bestseller.gaming.converter.PlayerConverter;
import com.bestseller.gaming.enums.PlayerLevels;
import com.bestseller.gaming.model.dto.PlayerDto;
import com.bestseller.gaming.model.request.PlayerLinkCreateRequest;
import com.bestseller.gaming.persistence.entity.PlayerEntity;
import com.bestseller.gaming.persistence.repository.PlayerRepository;
import com.bestseller.gaming.service.inteface.IGameService;
import com.bestseller.gaming.service.inteface.IPlayerService;
import com.bestseller.gaming.service.inteface.IRegionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class PlayerService implements IPlayerService {

    private final PlayerRepository playerRepository;

    private final IRegionService IregionService;

    private final IGameService IgameService;


    public Long linkPlayerToGame(PlayerLinkCreateRequest createRequest) {

        assertGameIdRegionIdAndPlayerNameIsValid(createRequest.getGameId(), createRequest.getPlayerName(), createRequest.getRegionId());
        assertGameIdAndPlayerNameIsValid(createRequest.getGameId(), createRequest.getPlayerName());

        PlayerEntity entity = new PlayerEntity();
        entity.setGame(IgameService.getGameEntityById(createRequest.getGameId()));
        entity.setRegion(IregionService.getRegionEntityById(createRequest.getRegionId()));
        entity.setPlayerLevel(PlayerLevels.valueOf(createRequest.getPlayerLevel().toUpperCase(Locale.ROOT)));
        entity.setName(createRequest.getPlayerName());
        return playerRepository.save(entity).getId();

    }

    public Map<String, List<PlayerDto>> getPlayersForPerGameByLevel(PlayerLevels playerLevel) {
        Map<String, List<PlayerDto>> result = new HashMap<>();
        IgameService.getAllActiveGameIds().forEach(gameDto -> {
            result.put(gameDto.getGameName(), getAllPlayerByGameIdAndLevel(playerLevel, gameDto.getId()));
        });
        return result;
    }

    public List<PlayerDto> searchPlayersByParams(PlayerLevels playerLevel, Long gameId, Long regionId) {
        return playerRepository.findByGame_IdAndPlayerLevelAndRegion_Id(
                gameId,
                playerLevel,
                regionId)
                .stream().map(PlayerConverter::playerDto).collect(Collectors.toList());
    }

    private List<PlayerDto> getAllPlayerByGameIdAndLevel(PlayerLevels playerLevels, Long gameId) {
        return playerRepository.findByGame_IdAndPlayerLevel(gameId, playerLevels).stream()
                .map(PlayerConverter::playerDto).collect(Collectors.toList());
    }

    private void assertGameIdRegionIdAndPlayerNameIsValid(final Long gameId, final String playerName, final Long regionId) {
        Optional<PlayerEntity> playerEntity = Optional.ofNullable(playerRepository.findByGame_IdAndNameAndRegion_Id(
                gameId,
                playerName,
                regionId));
        if (playerEntity.isPresent()) {
            throw new AlreadyLinkedPlayerException();
        }
    }

    private void assertGameIdAndPlayerNameIsValid(final Long gameId, final String playerName) {
        Optional<PlayerEntity> playerEntity = Optional.ofNullable(playerRepository.findByGame_IdAndName(
                gameId,
                playerName));
        if (playerEntity.isPresent()) {
            throw new PlayerNameMustBeUniqueException();
        }
    }


}
