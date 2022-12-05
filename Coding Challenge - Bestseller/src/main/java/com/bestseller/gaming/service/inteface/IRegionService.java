package com.bestseller.gaming.service.inteface;

import com.bestseller.gaming.persistence.entity.RegionEntity;

public interface IRegionService {

    RegionEntity getRegionEntityById(Long id);
}
