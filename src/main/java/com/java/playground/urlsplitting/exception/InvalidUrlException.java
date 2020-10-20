package com.java.playground.urlsplitting.exception;

public class InvalidUrlException extends RuntimeException{

    public InvalidUrlException() {
    }

    public InvalidUrlException(String message) {
        super(message);
    }
}
