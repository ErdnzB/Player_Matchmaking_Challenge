package com.bestseller.gaming.advice.exception;

import com.bestseller.gaming.advice.exception.base.BaseException;
import org.springframework.http.HttpStatus;

import static com.bestseller.gaming.advice.constants.ErrorCodes.NO_DEFINED_GAME;

public class NoDefinedGamesException extends BaseException {

    public NoDefinedGamesException() {
        super(HttpStatus.NOT_FOUND, NO_DEFINED_GAME, "There Is None Game Defined!");
    }
}
