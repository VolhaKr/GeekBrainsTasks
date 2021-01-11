package lesson7hw;

public class Plate {
    private int food;

    public int getFood() {
        return food;
    }

    public Plate(int food) {
        this.food = food;
    }

    int decreaseFood(int foodToEat) {
        if (foodToEat >= 0) {
            if (food >= foodToEat) {
                food -= foodToEat;
                return foodToEat;
            } else {
                System.out.println(" At the plate - " + food + " The cat wants " + foodToEat);
            }
        } else {
            System.out.println(" The food amount cannot be negative. The cat cannot eat " + foodToEat);
        }
        return 0;
    }

    void increaseFood(int foodToadd) {
        food += foodToadd;
    }

    void info() {
        System.out.println("There are " + food + " at the plate.");
    }
}
