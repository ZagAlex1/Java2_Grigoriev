package ru.lessons.Lesson2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExaptionExample {
    public static void main(String[] args) /*throws FileNotFoundException*/ { //В мэйн можно пробросить только если полностью уверен,
                                                                                //что исключения не будет. Иначе приложение упадет
//        simpleExceptions();
//        scan();
//        tryWithResourcesScan();
//        try {
//            scanThrows();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        generateDangerousException();
    }

    private static void generateDangerousException() {
        throw new MyMegaDangerousException("DANGER");
    }

    private static void generateException() {
//        RuntimeException e = new RuntimeException("Exception");
//        throw e;
        throw new RuntimeException("Exception");
    }

    private static void generateError() {
        throw new StackOverflowError("StackOver");
    }

    private static void scan() {
        try {
            Scanner scanner = new Scanner(new File("files/some.txt"));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
    }

    private static void tryWithResourcesScan() {
        try (Scanner scanner = new Scanner(new File("files/some.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void scanThrows() throws FileNotFoundException, ArithmeticException {
        try (Scanner scanner = new Scanner(new File("files/some.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }

    private static void simpleExceptions() {
        System.out.println("Start dividing");
        try {
            dividedByZero();
//        } catch (Exception e) {  Вначале так писать нельзя
        } catch (ArithmeticException | ClassCastException | NumberFormatException e) {
            System.out.println("Exception caught");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("AIOOBE");
        } catch (NullPointerException e) {
            System.out.println("NPE");
//            System.exit(-1); Finally не сработает
        } catch (Exception e) {
            //....
        } finally {
            System.out.println("FINALLY");
        }
        System.out.println("Finish dividing");
    }

    private static void dividedByZero() {
        div2(10, 0);
    }

    private static int div2(int a, int b) {
        return div1(a, b);
    }

    private static int div1(int a, int b) {
        return div0(a, b);
    }

    private static int div0(int a, int b) {
//        if (b == 0) {
//            return 0;
//        }
        return a / b;
    }
}
