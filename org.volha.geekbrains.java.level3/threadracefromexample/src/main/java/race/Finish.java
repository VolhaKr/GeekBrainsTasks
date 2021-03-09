package race;

import java.util.concurrent.BrokenBarrierException;

public class Finish extends Stage {
    volatile boolean winnner = false;

    public Finish() {
        this.description = "Finish";
    }

    @Override
    public void go(Car c) {
        System.out.println(c.getName() + " начал этап: " + description);
        System.out.println(c.getName() + " закончил этап: " + description);
        if (!winnner) {
            System.out.println(c.getName() + " WON");
            winnner = true;
        }
        try {
            RaceGoing.newFinishBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
      finally {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> The race is finished!!!");

        }
    }
}




