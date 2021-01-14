package lesson1;

public interface Runable extends Moving {
    boolean run(int runDistance);


//    int runningDistance = 0;
//    default void run(){
//        System.out.println("Running from Runnable");
//    }
}
