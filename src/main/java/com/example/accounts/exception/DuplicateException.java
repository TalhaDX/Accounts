package com.example.accounts.exception;

public class DuplicateException extends Exception {

    private final static String ERROR = "Account already exists";

    public DuplicateException() {
        super(ERROR);
    }
}
