package com.bridgelabz;

import com.bridgelabz.exceptions.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzertest {
    @Test
    public void givenMessege_WhenContainsSad_ShouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("This is sad message");
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals("sad",mood);
    }

    @Test
    public void givenMessege_WhenContainsAnyMood_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("This is happy message");
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals("happy", mood);
    }

    @Test
    public void givenMessege_WhenNull_ShouldReturnException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.EXCEPTION_NULL,e.type);
        }
    }

    @Test
    public void givenMessege_WhenEmpty_ShouldReturnException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(" ");
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.EXCEPTION_EMPTY,e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObject() {
        MoodAnalyzer moodAnalyzer = MoodAnalyserFactory.createMoodAnalyser();
        Assert.assertEquals(new MoodAnalyzer(), moodAnalyzer);
    }

    @Test
    public void givenMoodAnalyserClass_WhenImproper_ShouldReturnClassNotFoundException() {
        try {
            MoodAnalyserFactory.createMoodAnalyser("I am in happy mood","com.bridgelabz.MoodAnayzer",String.class);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.EXCEPTION_CLASS_NOT_FOUND, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserConstructor_WhenImproper_ShouldReturnMethodNotFoundException(){
        try {
            MoodAnalyserFactory.createMoodAnalyser("I am in happy mood","com.bridgelabz.MoodAnalyzer",Integer.class);
        } catch (MoodAnalyzerException e){
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.EXCEPTION_METHOD_NOT_FOUND, e.type);
        }
    }

    @Test
    public void givenMessegeUsingReflection_WhenProper_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("I am in happy mood", "com.bridgelabz.MoodAnalyzer", String.class);
        String mood = MoodAnalyserFactory.invokeMethod("analyzeMood",moodAnalyser);
        Assert.assertEquals("happy", mood);
    }

    @Test
    public void givenMessegeUsingReflection_WhenImProper_ShouldReturnException() {
        try {
            MoodAnalyzer moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("I am in happy mood", "com.bridgelabz.MoodAnalyzer", String.class);
            String mood = MoodAnalyserFactory.invokeMethod("analyzeMoo", moodAnalyser);
            Assert.assertEquals("happy", mood);
        }catch (MoodAnalyzerException e){
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.EXCEPTION_METHOD_NOT_FOUND, e.type);
        }
    }

    @Test
    public void givenMessegeInField_WhenProper_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("I am in happy mood", "com.bridgelabz.MoodAnalyzer", String.class);
        String mood = MoodAnalyserFactory.setField(moodAnalyser, "messege", "I am in happy mood");
        Assert.assertEquals("happy", mood);
    }

    @Test
    public void givenMessegeInField_WhenImProper_ShouldReturnNoSuchFieldException() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyserFactory.createMoodAnalyser("I am in happy mood", "com.bridgelabz.MoodAnalyzer", String.class);
            String mood = MoodAnalyserFactory.setField(moodAnalyzer, "mesege", "I am in happy mood");
        }catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.EXCEPTION_FIELD_NOT_FOUND, e.type);
        }
    }

    @Test
    public void givenMessegeInField_WhenNull_ShouldReturnNullException() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyserFactory.createMoodAnalyser("I am in happy mood", "com.bridgelabz.MoodAnalyzer", String.class);
            String mood = MoodAnalyserFactory.setField(moodAnalyzer, "messege", null);
        }catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.EXCEPTION_INVOKE_ISSUE, e.type);
        }
    }
}
