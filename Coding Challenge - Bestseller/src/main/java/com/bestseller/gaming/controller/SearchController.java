package com.bestseller.gaming.controller;

import com.bestseller.gaming.enums.PlayerLevels;
import com.bestseller.gaming.model.dto.PlayerDto;
import com.bestseller.gaming.service.inteface.IPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/search")
public class SearchController {


    private final IPlayerService IplayerService;

    @GetMapping("/players-by-params")
    private List<PlayerDto> searchPlayersByParams(@RequestParam PlayerLevels playerLevel,
                                                  @RequestParam Long gameId,
                                                  @RequestParam Long regionId) {
        return IplayerService.searchPlayersByParams(playerLevel, gameId, regionId);
    }
}
