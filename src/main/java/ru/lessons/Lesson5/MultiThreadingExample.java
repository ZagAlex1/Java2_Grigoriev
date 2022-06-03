package ru.lessons.Lesson5;

public class MultiThreadingExample {

    private static final Object mon1 = new Object();
    private static final Object mon2 = new Object();

    private static int a = 0;
    private static int b = 0;
    private static int c = 0;

    public static void main(String[] args) {
//        threadCreation();
//        threadStopExample();
//        raceConditionExample();
    }

    private static void raceConditionExample() {
        Thread t1 = new Thread(MultiThreadingExample::increment);
        Thread t2 = new Thread(MultiThreadingExample::increment);
        Thread t3 = new Thread(MultiThreadingExample::increment);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("A = %d, B = %d, C = %d\n", a, b, c);
    }

    private static  void monitorSync() {
        System.out.println("do smth sync...");
        //.......

        synchronized (mon1) {
            // здесь синхронизированный код
        }
    }

    private static  void monitorSync2() {
        System.out.println("do smth sync...");
        //.......

        synchronized (mon2) {
            // здесь синхронизированный код
        }
    }

    private static synchronized void increment() { // монитором служит класс
        for (int i = 0; i < 1000; i++) {
            a++;
            b++;
            c++;
        }
    }

    private synchronized void doSync() { // монитор будет объект(this)
        //....
    }

    private static void threadStopExample() {
        Thread main = Thread.currentThread();

        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                    System.out.println("ffffff - " + main.getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });
//        t.setDaemon(true);
        t.start();

        try {
            Thread.sleep(3000);
            System.out.println("Main finish");
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void threadCreation() {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();
        Thread anonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.printf("Hello from anonymous. Thread is %s\n", Thread.currentThread().getName());
            }
        });
        anonThread.start();
        Thread lambdaThread = new Thread(() -> System.out.printf("Hello from lambda. Thread is %s\n", Thread.currentThread().getName()));
        lambdaThread.start();
        new Thread(() -> System.out.printf("Hello from lambda one line. Thread is %s\n", Thread.currentThread().getName())).start(); // запуск потока без сохранения ссылки на него
        System.out.printf("Hello from main. Thread is %s\n", Thread.currentThread().getName());

        new Thread(() -> printSome()).start();
        new Thread(MultiThreadingExample::printSome).start();
    }

    public static void printSome() {
        System.out.println("Print some");
    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.printf("Hello from my runnable. Thread is %s\n", Thread.currentThread().getName());
        }
    }

    public static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.printf("Hello from my thread. Thread is %s\n", Thread.currentThread().getName());
        }
    }
}
