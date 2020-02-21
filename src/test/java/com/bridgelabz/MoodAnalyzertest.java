package com.bridgelabz;

import com.bridgelabz.exceptions.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
    public void givenMessege_WhenNull_ShouldReturnException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalyzerException e) {
           // e.printStackTrace();
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.EXCEPTION_NULL,e.type);
        }
    }

    @Test
    public void givenMessege_WhenEmpty_ShouldReturnException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(" ");
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalyzerException e) {
            //e.printStackTrace();
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.EXCEPTION_EMPTY,e.type);
        }
    }

    //  Default constructor
    @Test
    public void givenMoodAnalyserDefaultConstructor_WhenProper_ShouldReturnObject() {
       MoodAnalyzer moodAnalyzer = MoodAnalyserFactory.createMoodAnalyser();
       Assert.assertEquals(new MoodAnalyzer(), moodAnalyzer);
    }

    @Test
    public void givenMoodAnalyserClass_WhenImproper_ShouldReturnClassNotFoundException() {
        try {
            MoodAnalyserFactory.createMoodAnalyser("com.bridgelabz.Mood");
        } catch (MoodAnalyzerException e) {
           e.printStackTrace();
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.EXCEPTION_CLASS_NOT_FOUND, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserConstructor_WhenImproper_ShouldReturnMethodNotFoundException(){
        try {
            MoodAnalyserFactory.createMoodAnalyser("com.bridgelabz.MoodAnalyzer");
        } catch (MoodAnalyzerException e){
            e.printStackTrace();
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.EXCEPTION_METHOD_NOT_FOUND, e.type);
        }
    }
}
