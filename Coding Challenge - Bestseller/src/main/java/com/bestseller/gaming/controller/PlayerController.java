package com.bestseller.gaming.controller;


import com.bestseller.gaming.enums.PlayerLevels;
import com.bestseller.gaming.model.dto.PlayerDto;
import com.bestseller.gaming.model.request.PlayerLinkCreateRequest;
import com.bestseller.gaming.service.inteface.IPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/player")
public class PlayerController {

    private final IPlayerService IplayerService;

    @PostMapping("/link-player")
    private Long linkPlayerToGame(@Valid @RequestBody PlayerLinkCreateRequest createRequest) {
        return IplayerService.linkPlayerToGame(createRequest);
    }

    @GetMapping("/all-players-by-level")
    private Map<String, List<PlayerDto>> getPlayersForPerGameByLevel(@RequestParam PlayerLevels playerLevel) {
        return IplayerService.getPlayersForPerGameByLevel(playerLevel);
    }


}
