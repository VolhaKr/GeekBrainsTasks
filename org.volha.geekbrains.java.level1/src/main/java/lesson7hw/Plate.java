package lesson7hw;

public class Plate {
    private int foodAmount;

    public int getFood() {
        return foodAmount;
    }

    public Plate(int food) {
        this.foodAmount = food;
    }

    int decreaseFood(int foodToEat) {
        if (foodToEat >= 0) {
            if (foodAmount >= foodToEat) {
                foodAmount -= foodToEat;
                return foodToEat;
            } else {
                System.out.println(" At the plate - " + foodAmount + " The cat wants " + foodToEat);
            }
        } else {
            System.out.println(" The food amount cannot be negative. The cat cannot eat " + foodToEat);
        }
        return 0;
    }

    void increaseFood(int foodToadd) {
        foodAmount += foodToadd;
    }

    void info() {
        System.out.println("There are " + foodAmount + " at the plate.");
    }
}
