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
            winnner = true;
            System.out.println(c.getName() + " WON ");
                    }
    }
}




