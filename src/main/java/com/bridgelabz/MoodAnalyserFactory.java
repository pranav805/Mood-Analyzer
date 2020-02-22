package com.bridgelabz;

import com.bridgelabz.exceptions.MoodAnalyzerException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserFactory {

    public static MoodAnalyzer createMoodAnalyser(String message, String classname, Class stringClass) {
        try {
            Constructor<?> constructor = Class.forName(classname).getConstructor(stringClass);
            Object obj = constructor.newInstance(message);
            return (MoodAnalyzer) obj;
        } catch (NoSuchMethodException ex) {
            throw new MoodAnalyzerException("Method not found", MoodAnalyzerException.ExceptionType.EXCEPTION_METHOD_NOT_FOUND);
        } catch (ClassNotFoundException ex) {
            throw new MoodAnalyzerException("Class not found", MoodAnalyzerException.ExceptionType.EXCEPTION_CLASS_NOT_FOUND);
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyzer createMoodAnalyser() {
        try {
            Constructor<?> constructor = Class.forName("com.bridgelabz.MoodAnalyzer").getConstructor();
            Object obj = constructor.newInstance();
            return (MoodAnalyzer) obj;
        } catch (NoSuchMethodException | ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String invokeMethod(String methodName, Object moodAnalyzer ) {
        try {
            Method declaredMethod = moodAnalyzer.getClass().getDeclaredMethod(methodName);
            return (String) declaredMethod.invoke(moodAnalyzer);
        }catch (NoSuchMethodException e){
            throw new MoodAnalyzerException("Method not found",MoodAnalyzerException.ExceptionType.EXCEPTION_METHOD_NOT_FOUND);
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            throw new MoodAnalyzerException(e.getMessage(), MoodAnalyzerException.ExceptionType.EXCEPTION_INVOKE_ISSUE);
        }
        return null;
    }


    public static String setField(Object moodAnalyser, String fieldName, String fieldValue) {
        try {
            Field messegeField = moodAnalyser.getClass().getDeclaredField(fieldName);
            messegeField.setAccessible(true);
            messegeField.set(moodAnalyser, fieldValue);
            return MoodAnalyserFactory.invokeMethod("analyzeMood",moodAnalyser);
        }catch (NoSuchFieldException e){
            throw new MoodAnalyzerException(e.getMessage(), MoodAnalyzerException.ExceptionType.EXCEPTION_FIELD_NOT_FOUND);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
