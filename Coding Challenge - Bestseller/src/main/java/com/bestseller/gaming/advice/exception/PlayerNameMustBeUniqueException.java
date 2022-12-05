package com.bestseller.gaming.advice.exception;

import com.bestseller.gaming.advice.exception.base.BaseException;
import org.springframework.http.HttpStatus;

import static com.bestseller.gaming.advice.constants.ErrorCodes.PLAYER_NAME_MUST_BE_UNQ;

public class PlayerNameMustBeUniqueException extends BaseException {

    public PlayerNameMustBeUniqueException() {
        super(HttpStatus.BAD_REQUEST, PLAYER_NAME_MUST_BE_UNQ, "Player Name That You Entered Already Defined For This Game.Try Another Name Or Enter Different Game !");
    }
}
