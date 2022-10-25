package com.testwork.calculator.exceptions;

public class CharacterLimitExceededException extends RuntimeException {
    public CharacterLimitExceededException(String message) {
        super(message);
    }
}
