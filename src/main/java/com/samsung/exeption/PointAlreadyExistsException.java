package com.samsung.exeption;

public class PointAlreadyExistsException extends RuntimeException {
    public PointAlreadyExistsException(String message) {
        super(message);
    }
}
