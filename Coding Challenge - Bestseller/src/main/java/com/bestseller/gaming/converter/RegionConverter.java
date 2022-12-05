package com.bestseller.gaming.converter;

import com.bestseller.gaming.model.dto.RegionDto;
import com.bestseller.gaming.persistence.entity.RegionEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegionConverter {

    public static RegionDto regionDto(final RegionEntity regionEntity) {
        return RegionDto.builder()
                .id(regionEntity.getId())
                .country(regionEntity.getCountry())
                .build();
    }
}
