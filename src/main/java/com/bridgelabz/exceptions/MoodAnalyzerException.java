package com.bridgelabz.exceptions;

public class MoodAnalyzerException extends RuntimeException {
    public enum ExceptionType{EXCEPTION_NULL,EXCEPTION_EMPTY, EXCEPTION_CLASS_NOT_FOUND, EXCEPTION_METHOD_NOT_FOUND, EXCEPTION_FIELD_NOT_FOUND, EXCEPTION_INVOKE_ISSUE }
    public ExceptionType type;
    public MoodAnalyzerException(String message,ExceptionType type) {
        super(message);
        this.type=type;
    }
}
