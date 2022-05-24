package ru.lessons.Lesson1;

import java.util.Arrays;

public class Classwork {
    public static void main(String[] args) {
//        flyingExample();

        calc(10, 6, new Plus());
        calc(10, 6, new Subtractor());
        calc(10, 6, (a, b) -> a / b);

        Integer[] arr = {23, 435, 76, 876, 989};
        Arrays.sort(arr, (i1, i2) -> i1 - i2);
    }

    private static void calc(double a, double b, Calculator calculator) {
        System.out.printf("Calculated: a = %f, b = %f result = %f\n",
                a, b, calculator.calculate(a, b));
    }

    private static void flyingExample() {
        //        Eagle eagle = new Eagle();
//        Flying eagle = new Eagle();
//        eagle.fly();

        Flying[] flyings = {
                new Eagle(),
                new PaperPlane(),
                new SpaceShip(),
                new Flying() {
                    @Override              //анонимный интерфейс
                    public void fly() {
                        System.out.println("Anon fly");
                    }
                },
                () -> System.out.println("Lambda fly")
        };

        for (Flying flying : flyings) {
            flying.fly();
        }
    }
}
