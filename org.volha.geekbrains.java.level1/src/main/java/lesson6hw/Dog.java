package lesson6hw;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
        maxRunDistance = 500;
        maxSwimDistance = 10;
    }

    void swim(int distance) {
        if (distance < 0) {
            System.out.println("Distance cannot be negative");
        } else {
            if (distance <= maxSwimDistance) {
                System.out.println(getClass().getSimpleName() + " " + name + " swam " + distance + "m");
            } else {
                System.out.println("Too much. " + getClass().getSimpleName() + " " + name + " cannot swim " + distance + "m");
            }
        }
    }
}
