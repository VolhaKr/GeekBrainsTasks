package lesson6hw;

public abstract class Animal {
    String name;
    int maxRunDistance;
    int maxSwimDistance;
    public static int animalsNumber = 0;

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
