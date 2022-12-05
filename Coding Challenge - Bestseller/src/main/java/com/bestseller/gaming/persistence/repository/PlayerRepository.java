package com.bestseller.gaming.persistence.repository;

import com.bestseller.gaming.enums.PlayerLevels;
import com.bestseller.gaming.persistence.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

    List<PlayerEntity> findByGame_IdAndPlayerLevel(Long gameId, PlayerLevels playerLevel);

    List<PlayerEntity> findByGame_IdAndPlayerLevelAndRegion_Id(Long gameId, PlayerLevels playerLevel, Long regionId);

    PlayerEntity findByGame_IdAndNameAndRegion_Id(Long gameId, String name, Long regionId);

    PlayerEntity findByGame_IdAndName(Long gameId, String name);

}
