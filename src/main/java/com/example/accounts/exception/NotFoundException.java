package com.example.accounts.exception;

public class NotFoundException extends Exception {

    private final static String ERROR = "Account not found";

    public NotFoundException() {
        super(ERROR);
    }
}
