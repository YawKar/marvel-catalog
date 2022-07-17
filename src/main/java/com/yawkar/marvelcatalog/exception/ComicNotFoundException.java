package com.yawkar.marvelcatalog.exception;

public class ComicNotFoundException extends RuntimeException {

    public ComicNotFoundException() {
        super();
    }

    public ComicNotFoundException(String message) {
        super(message);
    }
}
