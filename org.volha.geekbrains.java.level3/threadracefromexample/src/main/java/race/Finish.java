package race;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.atomic.AtomicBoolean;

public class Finish extends Stage {
    AtomicBoolean winner = new AtomicBoolean(false);

    public Finish() {
        this.description = "Finish";
    }

    @Override
    public void go(Car c) {
        System.out.println(c.getName() + " начал этап: " + description);
        System.out.println(c.getName() + " закончил этап: " + description);
        if (!winner.get()) {
            winner.set(true);
            System.out.println(c.getName() + " WON ");
                    }
    }
}




