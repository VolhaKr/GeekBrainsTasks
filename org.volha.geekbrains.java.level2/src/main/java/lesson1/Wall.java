package lesson1;

public class Wall implements Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean makeToOvercome(Moving moving) {
        //  System.out.println("Moving");
        if (moving instanceof Jumpable) {
            return ((Jumpable) moving).jump(height);
        } else {
            System.out.println(moving.getClass().getSimpleName() + " cannot jump");
            return false;
        }
    }
}
