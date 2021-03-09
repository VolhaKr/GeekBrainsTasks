package race;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class RaceGoing implements Runnable {
    public static final int CARS_COUNT = 4;
    public static CyclicBarrier newBarrier = new CyclicBarrier(CARS_COUNT + 1);
    public static CyclicBarrier newFinishBarrier = new CyclicBarrier(CARS_COUNT);
    public static Lock lock;
    public static Car[] cars;
    public static Semaphore tunnelSemaphore = new Semaphore(CARS_COUNT / 2);

    @Override
    public void run() {
        System.out.println("Number of parties required to trip the barrier = " +
                newBarrier.getParties());

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(80), new Road(40), new Finish());
        cars = new Car[CARS_COUNT];
        for ( int i = 0; i < cars.length; i++ ) {
            cars[i] = new Car(20 + (int) (Math.random() * 10), i + 1, race);
        }
        for ( int i = 0; i < cars.length; i++ ) {
            new Thread(cars[i]).start();
        }

        try {
            newBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Race begun");
        try {
            newBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("The race is finished");
    }
}

