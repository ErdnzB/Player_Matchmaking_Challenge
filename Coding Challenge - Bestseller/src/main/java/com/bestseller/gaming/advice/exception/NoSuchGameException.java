package com.bestseller.gaming.advice.exception;

import com.bestseller.gaming.advice.exception.base.BaseException;
import org.springframework.http.HttpStatus;

import static com.bestseller.gaming.advice.constants.ErrorCodes.NO_SUCH_GAME;

public class NoSuchGameException extends BaseException {


    public NoSuchGameException() {
        super(HttpStatus.NOT_FOUND, NO_SUCH_GAME, "No Such Game With That ID !");
    }
}
