package lesson1;

public class RunningTrack implements Obstacle {
    int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    @Override
    public boolean makeToOvercome(Moving moving) {
        if (moving instanceof Runable) {
            return ((Runable) moving).run(length);
        } else {
            System.out.println(moving.getClass().getSimpleName() + " cannot run");
            return false;
        }
    }
}
