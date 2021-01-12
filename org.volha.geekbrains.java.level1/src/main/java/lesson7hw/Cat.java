package lesson7hw;

public class Cat {
    private String name;
    private final int FOOD_CAN_EAT;
    private boolean satiety;

    public Cat(String name, int FOOD_CAN_EAT) {
        this.name = name;
        this.FOOD_CAN_EAT = FOOD_CAN_EAT;
    }
//What is common practice to check creation of correct objects?
 //   if ( ваозраст < 0) {throw new IllegalArgumentException(); }
//    public Cat(String name, int FOOD_CAN_EAT) {
//        this.name = name;
//        if (FOOD_CAN_EAT >= 0) {
//            this.FOOD_CAN_EAT = FOOD_CAN_EAT;
//        }
//        else{
//            this.FOOD_CAN_EAT =0;
//        }
///    }

    void eat(Plate plate) {
        if (satiety == false) {
            System.out.println("Cat " + name + " wants to eat " + FOOD_CAN_EAT);
            if (plate.decreaseFood(FOOD_CAN_EAT) > 0) {
                System.out.println("Cat " + name + " ate " + FOOD_CAN_EAT);
                satiety = true;
            }
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", FOOD_CAN_EAT=" + FOOD_CAN_EAT +
                ", satiation=" + satiety +
                '}';
    }

    void info() {
        System.out.println(this.toString());
    }
}

