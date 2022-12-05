package com.bestseller.gaming.converter;

import com.bestseller.gaming.model.dto.PlayerDto;
import com.bestseller.gaming.persistence.entity.PlayerEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlayerConverter {

    public static PlayerDto playerDto(final PlayerEntity playerEntity) {
        return PlayerDto.builder()
                .id(playerEntity.getId())
                .name(playerEntity.getName())
                .gameId(playerEntity.getGame().getId())
                .regionId(playerEntity.getRegion().getId())
                .playerLevel(playerEntity.getPlayerLevel())
                .build();

    }
}
