package lesson1;

public class Human extends Entity {
    public Human(String name, int maxRun, int maxJump) {
        super(name, maxRun, maxJump);
    }
}
//extends Entity implements Runable, Jumpable{
//    String name;
//    int maxRun;
//    int maxJump;
//
//    public Human(String name, int maxRun, int maxJump) {
//        this.name = name;
//        this.maxRun = maxRun;
//        this.maxJump = maxJump;
//    }
//
//    void info(){
//        System.out.println("Human " + name + " can run " +maxRun + " can jump " + maxJump);
//    }
//
//    @Override
//    public void run( int runDistance){
//        if (runDistance <= this.maxRun) {
//            System.out.println("Human " + name + " successfully ran " + runDistance);
//        } else {
//            System.out.println("Human " + name + " can't run " + runDistance + " it can only " + maxRun);
//        }
//    }
//
//    @Override
//    public void jump( int jumpHeight){
//        if (jumpHeight <= this.maxJump) {
//            System.out.println("Human " + name + " successfully jumped over " + jumpHeight);
//        } else {
//            System.out.println("Human " + name + " can't jump over " + jumpHeight + " it can only " + maxJump);
//        }
//    }
//
//
////    @Override
////    public void run() {
////        System.out.println("Human ran successfully");
////    }
////
////    @Override
////    public void jump() {
////        System.out.println("HUman jumped successfully");
////    }
//
//
//}
