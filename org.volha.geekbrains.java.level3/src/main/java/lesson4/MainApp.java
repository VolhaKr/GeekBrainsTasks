package lesson4;
//1. Создать три потока, каждый из которых выводит определенную букву (A, B и C)
//        5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
//        2. На серверной стороне сетевого чата реализовать управление потоками через ExecutorService.
public class MainApp {

        static Object mon = new Object();
        static volatile char currentLet = 'A';
        static final int num = 5;

        public static void main(String[] args) {
            new Thread(() -> {
                try {
                    for (int i = 0; i < num; i++) {
                        synchronized (mon) {
                            while (currentLet != 'A') {
                                mon.wait();
                            }
                            System.out.print("A");
                            currentLet='B';
                            mon.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    for (int i = 0; i < num; i++) {
                        synchronized (mon) {
                            while (currentLet != 'B') {
                                mon.wait();
                            }
                            System.out.print("B");
                           currentLet='C';
                            mon.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    for (int i = 0; i < num; i++) {
                        synchronized (mon) {
                            while (currentLet != 'C') {
                                mon.wait();
                            }
                            System.out.print("C");
                            currentLet='A';
                            mon.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


