package lesson6hw;

public class Cat extends Animal {
    public static int catsNumber = 0;

    public Cat(String name) {
        super(name);
        maxRunDistance = 200;
        maxSwimDistance = 0;
        catsNumber++;
    }

    void swim(int distance) {
        System.out.println(getClass().getSimpleName() + " " + getName() + " cannot swim. Cats cannot swim");
    }
}
