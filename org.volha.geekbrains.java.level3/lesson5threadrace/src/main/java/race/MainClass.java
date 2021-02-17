package race;
//Организуем гонки:
//        Все участники должны стартовать одновременно, несмотря на то, что на подготовку у каждого из них уходит разное время.
//        В туннель не может заехать одновременно больше половины участников (условность).
//        Попробуйте всё это синхронизировать.
//        Только после того как все завершат гонку, нужно выдать объявление об окончании.
//        Можете корректировать классы (в т.ч. конструктор машин) и добавлять объекты классов из пакета util.concurrent.

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
        public static final int CARS_COUNT = 4;
        public static void main(String[] args) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
            Race race = new Race(new Road(60), new Tunnel(80), new Road(40));
            Car[] cars = new Car[CARS_COUNT];
            for (int i = 0; i < cars.length; i++) {
                cars[i] = new Car(20 + (int) (Math.random() * 10), i+1);
            }
            CyclicBarrier cbStartRace = new CyclicBarrier(2);
            for (int i = 0; i < cars.length; i++) {
                new Thread(cars[i]).start();
            }
            try {
                cbStartRace.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");


            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
    }
