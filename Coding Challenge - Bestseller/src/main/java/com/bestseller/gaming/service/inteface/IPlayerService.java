package com.bestseller.gaming.service.inteface;

import com.bestseller.gaming.enums.PlayerLevels;
import com.bestseller.gaming.model.dto.PlayerDto;
import com.bestseller.gaming.model.request.PlayerLinkCreateRequest;

import java.util.List;
import java.util.Map;

public interface IPlayerService {

    Long linkPlayerToGame(PlayerLinkCreateRequest createRequest);

    Map<String, List<PlayerDto>> getPlayersForPerGameByLevel(PlayerLevels playerLevel);

    List<PlayerDto> searchPlayersByParams(PlayerLevels playerLevel, Long gameId, Long regionId);
}
