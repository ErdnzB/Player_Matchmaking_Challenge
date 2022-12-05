package com.bestseller.gaming.persistence.repository;

import com.bestseller.gaming.persistence.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Long> {

    List<GameEntity> findByActive(boolean isActive);
}
