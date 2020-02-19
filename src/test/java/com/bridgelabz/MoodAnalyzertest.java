package com.bridgelabz;

import com.bridgelabz.exceptions.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzertest {
    @Test
    public void givenMessege_WhenContainsSad_ShouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("This is sad message");
        String mood = null;
        try {
            mood = moodAnalyzer.analyzeMood();
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("sad",mood);
    }

    @Test
    public void givenMessege_WhenContainsAnyMood_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("This is happy message");
        String mood = null;
        try {
            mood = moodAnalyzer.analyzeMood();
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("happy", mood);
    }

    @Test
    public void givenMessege_WhenNull_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        String mood=null;
        try {
            mood = moodAnalyzer.analyzeMood();
        } catch (MoodAnalyzerException e) {
           // e.printStackTrace();
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.EXCEPTION_NULL,e.type);
        }
    }

    @Test
    public void givenMessege_WhenEmpty_ShouldReturnException() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(" ");
        try {
            String mood = moodAnalyzer.analyzeMood();
        } catch (MoodAnalyzerException e) {
            //e.printStackTrace();
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.EXCEPTION_EMPTY,e.type);
        }
    }
}
