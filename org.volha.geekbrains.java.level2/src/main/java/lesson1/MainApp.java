package lesson1;
//Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
//        Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
//        Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
//        * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.

public class MainApp {
    public static void main(String[] args) {
//        Moving[] movingAnimals = {
//                new Cat("Mars", 3, 4),
//                new Robot(),
//                new Human()
//        };
//        for (Moving moving:movingAnimals){
//
//            if (moving instanceof Jumpable){
//                ((Jumpable) moving).jump(10);
//            }
//            if (moving instanceof Runable){
//                ((Runable) moving).run();
//            }
//        }
//
//        Obstacle[] obstacle  = {
//                new Wall(5),
//                new RunningTrack(5),
//                new Wall(4)
//        };
//        Cat cat = new Cat("Bars", 5, 6);
//        Wall wall = new Wall(3);
//        wall.makeToOvercome(cat);
//        Chicken chicken = new Chicken();
//      //  wall.makeToOvercome(chicken);
//        cat.run(10);
        Moving[] movingEntities = {
                new Cat("Mars", 3, 4),
                new Robot("Robot1", 10, 20),
                new Human("Ivan", 4, 2)
        };
        Obstacle [] obstacles = {
                new Wall(1),
                new RunningTrack(4),
                new Wall(3)
        };
        System.out.println("Training");
   train (movingEntities, obstacles);
        System.out.println("Competitions");
   compete (movingEntities, obstacles);
    }

    private static void compete(Moving[] movingEntities, Obstacle[] obstacles) {
        boolean competeRezult;
        for ( Moving movingEntity : movingEntities ) {
            competeRezult = true;
               for ( Obstacle obstacle : obstacles ) {
               if (!obstacle.makeToOvercome(movingEntity)){
                   competeRezult = false;
                   break;
               }
            }
            if (competeRezult == true) {
                System.out.println(movingEntity.getClass().getSimpleName() + " "  + " overcame successfully! ");
            }
            else {
                System.out.println(movingEntity.getClass().getSimpleName() + "  " + "failed to overcome...");
            }
        }

    }

    private static void train(Moving[] movingEntities, Obstacle[] obstacles) {
        boolean trainRezult;
                for ( Moving movingEntity : movingEntities ) {
                for ( Obstacle obstacle : obstacles ) {
                   trainRezult = obstacle.makeToOvercome(movingEntity);
                }
            }
        }
    }

