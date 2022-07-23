package com.yawkar.marvelcatalog.configuration.exception;

public class ComicNotFoundException extends RuntimeException {

    public ComicNotFoundException() {
        super();
    }

    public ComicNotFoundException(String message) {
        super(message);
    }
}
