package com.epam.exception;

public class ProductDoesNotExistException extends RuntimeException {
	final String message;
    public ProductDoesNotExistException(String s) {
        super();
        this.message = s;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
