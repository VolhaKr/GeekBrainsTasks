package race;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(int speed, int carNumber) {
       // this.race = race;
        this.speed = speed;
        this.name = "Участник #" + carNumber;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500);
                   //+ (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }
//        for (int i = 0; i < race.getStages().size(); i++) {
//            race.getStages().get(i).go(this);
//        }
    }
}