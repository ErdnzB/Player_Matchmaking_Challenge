package com.bestseller.gaming.advice.exception;

import com.bestseller.gaming.advice.exception.base.BaseException;
import org.springframework.http.HttpStatus;

import static com.bestseller.gaming.advice.constants.ErrorCodes.NO_SUCH_PLAYER_LEVEL;

public class NoSuchLevelTypeException extends BaseException {

    public NoSuchLevelTypeException() {
        super(HttpStatus.NOT_FOUND, NO_SUCH_PLAYER_LEVEL, "No Such Level Type !");
    }
}
