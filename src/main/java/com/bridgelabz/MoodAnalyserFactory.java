package com.bridgelabz;

import com.bridgelabz.exceptions.MoodAnalyzerException;

import java.lang.reflect.Constructor;
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
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyzer createMoodAnalyser() {
        try {
            Constructor<?> constructor = Class.forName("com.bridgelabz.MoodAnalyzer").getConstructor();
            Object obj = constructor.newInstance();
            return (MoodAnalyzer) obj;
            } catch (NoSuchMethodException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
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
            e.printStackTrace();
        }
        return null;
    }
}
