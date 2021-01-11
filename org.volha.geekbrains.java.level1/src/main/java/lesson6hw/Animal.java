package lesson6hw;

public abstract class Animal {
    private String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;
    public static int animalsNumber = 0;

    public String getName() {
        return name;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public int getMaxSwimDistance() {
        return maxSwimDistance;
    }

    public Animal(String name) {
        this.name = name;
        animalsNumber++;
    }

    void run(int distance) {
        if (distance < 0) {
            System.out.println("Distance cannot be negative");
        } else {
            if (distance <= maxRunDistance) {
                System.out.println(getClass().getSimpleName() + " " + name + " ran " + distance + "m");
            } else {
                System.out.println("Too much. " + getClass().getSimpleName() + " " + name + " cannot run " + distance + "m");
            }
        }
    }

    abstract void swim(int distance);
}
