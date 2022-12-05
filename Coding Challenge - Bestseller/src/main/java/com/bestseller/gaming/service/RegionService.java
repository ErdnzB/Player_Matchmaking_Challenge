package com.bestseller.gaming.service;

import com.bestseller.gaming.advice.exception.NoSuchRegionException;
import com.bestseller.gaming.persistence.entity.RegionEntity;
import com.bestseller.gaming.persistence.repository.RegionRepository;
import com.bestseller.gaming.service.inteface.IRegionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RegionService implements IRegionService {

    private final RegionRepository regionRepository;

    public RegionEntity getRegionEntityById(Long id) {
        return regionRepository.findById(id).orElseThrow(NoSuchRegionException::new);
    }


}
