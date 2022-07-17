package com.yawkar.marvelcatalog.exception;

public class HeroNotFoundException extends RuntimeException {

    public HeroNotFoundException() {
        super();
    }

    public HeroNotFoundException(String message) {
        super(message);
    }
}
