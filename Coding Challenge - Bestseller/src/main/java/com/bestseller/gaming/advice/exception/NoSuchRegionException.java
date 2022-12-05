package com.bestseller.gaming.advice.exception;

import com.bestseller.gaming.advice.exception.base.BaseException;
import org.springframework.http.HttpStatus;

import static com.bestseller.gaming.advice.constants.ErrorCodes.NO_SUCH_REGION;

public class NoSuchRegionException extends BaseException {

    public NoSuchRegionException() {
        super(HttpStatus.NOT_FOUND, NO_SUCH_REGION, "No Such Region !");
    }
}
