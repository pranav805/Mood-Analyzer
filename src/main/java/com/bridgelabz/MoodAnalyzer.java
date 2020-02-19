package com.bridgelabz;

import com.bridgelabz.exceptions.MoodAnalyzerException;

public class MoodAnalyzer {
    private String messege;

    public MoodAnalyzer() {
    }

    public MoodAnalyzer(String messege) {
        this.messege = messege;
    }

    public String analyzeMood() throws MoodAnalyzerException {
        try {
            if (messege.length() == 0){
                throw new MoodAnalyzerException("please enter valid messege", MoodAnalyzerException.ExceptionType.EXCEPTION_EMPTY);
            }
            if(messege.contains("sad")){
                return "sad";
            }
            else
                return "happy";
        } catch (Exception e) {
            throw new MoodAnalyzerException("Please enter valid messege", MoodAnalyzerException.ExceptionType.EXCEPTION_NULL);
        }
    }
}
