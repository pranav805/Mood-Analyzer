package com.bridgelabz;

import com.bridgelabz.exceptions.MoodAnalyzerException;

public class MoodAnalyzer {
    private String messege;

    public MoodAnalyzer() {
        messege = "Default";
    }

    public MoodAnalyzer(String messege) {
        this.messege = messege;
    }

    public String analyseMood(String messege){
        this.messege=messege;
        return analyzeMood();
    }

    public String analyzeMood() {
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
    public boolean equals(Object another){
        if (this.messege.equals(((MoodAnalyzer) another).messege))
            return true;
        return false;
    }

}
