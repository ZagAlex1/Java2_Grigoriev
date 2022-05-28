package ru.lessons.Lesson2;

public class MyMegaDangerousException extends RuntimeException{
    public MyMegaDangerousException() {
        super();
    }

    public MyMegaDangerousException(String message) {
        super(message);
    }

}
