package com.bestseller.gaming.model.request;

import com.bestseller.gaming.advice.validate.EnumValidator;
import com.bestseller.gaming.enums.PlayerLevels;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerLinkCreateRequest {

    @NotEmpty
    private String playerName;

    @NotNull
    private Long gameId;

    @NotNull
    private Long regionId;

    @NotEmpty
    @EnumValidator(enumClazz = PlayerLevels.class, message = "Invalid Player Level Definition")
    private String playerLevel;

}




