package race;

//import static race.MainClass.cbStartRace;

import java.util.concurrent.BrokenBarrierException;

import static race.RaceGoing.newBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 4;
    }

    private Race race;
    private int speed;
    private String name;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(int speed, int carNumber, Race race) {
        this.race = race;
        this.speed = speed;
        this.name = "Участник #" + carNumber;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            newBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for ( Stage stage : race.getStages() ) {
            stage.go(this);
        }
        try {
            newBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}


