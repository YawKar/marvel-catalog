package com.yawkar.marvelcatalog.configuration.exception;

public class HeroNotFoundException extends RuntimeException {

    public HeroNotFoundException() {
        super();
    }

    public HeroNotFoundException(String message) {
        super(message);
    }
}
