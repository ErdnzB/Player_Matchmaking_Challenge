package com.bestseller.gaming.service.inteface;

import com.bestseller.gaming.model.dto.GameDto;
import com.bestseller.gaming.persistence.entity.GameEntity;

import java.util.List;

public interface IGameService {

    GameEntity getGameEntityById(Long id);

    List<GameDto> getAllActiveGameIds();

}
