package lesson1improved.lesson1;

public class Cat extends Entity {
    public Cat(String name, int maxRun, int maxJump) {
        super(name, maxRun, maxJump);
    }
}
//implements Runable, Jumpable {
//    int maxRun;
//    int maxJump;
//
//    public Cat(String name, int maxRun, int maxJump) {
//        super(name);
//        this.maxRun = maxRun;
//        this.maxJump = maxJump;
//    }
//
//    void info(){
//        System.out.println("Cat " + name + " can run " +maxRun + " can jump " + maxJump);
//    }
//
//    @Override
//    public void run( int runDistance){
//            if (runDistance <= this.maxRun) {
//                System.out.println("Cat " + name + " successfully ran " + runDistance);
//            } else {
//                System.out.println("Cat " + name + " can't run " + runDistance + " it can only " + maxRun);
//            }
//        }
//
//    @Override
//    public void jump( int jumpHeight){
//        if (jumpHeight <= this.maxJump) {
//            System.out.println("Cat " + name + " successfully jumped over " + jumpHeight);
//        } else {
//            System.out.println("Cat " + name + " can't jump over " + jumpHeight + " it can only " + maxJump);
//        }
//    }
//    }
//
////    @Override
////    public void run() {
////        System.out.println("Cat ran successfully");
////    }
////
////    @Override
////    public void jump(int jumpHeght) {
////        System.out.println("Catjumped successfully");
////    }
