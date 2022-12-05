package com.bestseller.gaming.advice.exception;

import com.bestseller.gaming.advice.exception.base.BaseException;
import org.springframework.http.HttpStatus;

import static com.bestseller.gaming.advice.constants.ErrorCodes.ALREADY_LINKED_PLAYER;

public class AlreadyLinkedPlayerException extends BaseException {

    public AlreadyLinkedPlayerException() {
        super(HttpStatus.BAD_REQUEST, ALREADY_LINKED_PLAYER, "Player That You Entered Already Defined For This Game And Region.Pls Try Different Game,Name Or Region !");
    }
}
