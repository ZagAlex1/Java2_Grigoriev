package ru.lessons.Lesson1;

import java.io.Closeable;
import java.io.Serializable;

public interface ExampleInterface extends Flying, Cloneable, Closeable, Serializable {
    String SOME_INTERFACE_FIELD = "SOME"; // public static final константа ExampleInterface.SOME_INTERFACE_FIELD

    default void doDefault() {
        System.out.println("Default");  // метод с дефолтной реализацией
    }

    static void doStatic() {
        System.out.println("STATIC");      // ExampleInterface.doStatic()
    }

    private void doPrivate() {
        System.out.println("PRIVATE");   // нужен для того чтобы вызвать его из default-го метода
    }
}
