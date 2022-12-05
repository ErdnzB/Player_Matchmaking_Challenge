package com.bestseller.gaming.service;

import com.bestseller.gaming.advice.exception.NoDefinedGamesException;
import com.bestseller.gaming.advice.exception.NoSuchGameException;
import com.bestseller.gaming.converter.GameConverter;
import com.bestseller.gaming.model.dto.GameDto;
import com.bestseller.gaming.persistence.entity.GameEntity;
import com.bestseller.gaming.persistence.repository.GameRepository;
import com.bestseller.gaming.service.inteface.IGameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class GameService implements IGameService {

    private final GameRepository gameRepository;


    public GameEntity getGameEntityById(Long id) {
        Optional<GameEntity> byId = Optional.of(gameRepository.findById(id).orElseThrow(NoSuchGameException::new));
        return byId.get();
    }

    public List<GameDto> getAllActiveGameIds() {
        return getAllActiveGameEntities().stream().map(GameConverter::gameDto).collect(Collectors.toList());
    }

    private List<GameEntity> getAllActiveGameEntities() {
        return Optional.of(gameRepository.findByActive(true)).orElseThrow(NoDefinedGamesException::new);
    }


}
