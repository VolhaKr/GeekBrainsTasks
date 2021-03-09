package race;
//Организуем гонки:
//        Все участники должны стартовать одновременно, несмотря на то, что на подготовку у каждого из них уходит разное время.
//        В туннель не может заехать одновременно больше половины участников (условность).
//        Попробуйте всё это синхронизировать.
//        Только после того как все завершат гонку, нужно выдать объявление об окончании.
//        Можете корректировать классы (в т.ч. конструктор машин) и добавлять объекты классов из пакета util.concurrent.

import java.util.concurrent.BrokenBarrierException;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        // parent thread
        RaceGoing raceGoing = new RaceGoing();

        Thread t1 = new Thread(raceGoing);
        t1.start();
//        try {
//            RaceGoing.newFinishBarrier.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (BrokenBarrierException e) {
//            e.printStackTrace();
//        }
//        System.out.println("FIN");
//        t1.join();
//        System.out.println("FINISH");
        //  System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
