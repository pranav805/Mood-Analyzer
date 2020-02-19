package com.bridgelabz.exceptions;

public class MoodAnalyzerException extends Exception {
    public enum ExceptionType{EXCEPTION_NULL,EXCEPTION_EMPTY}
    public ExceptionType type;
    public MoodAnalyzerException(String message,ExceptionType type) {
        super(message);
        this.type=type;
    }
}
