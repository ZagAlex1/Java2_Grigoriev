package ru.lessons.Lesson1;

public class Subtractor implements Calculator {
    @Override
    public double calculate(double a, double b) {
        return a - b;
    }
}
