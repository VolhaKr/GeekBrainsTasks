package lesson1improved.lesson1;

public class Entity implements Jumpable, Runable {
    String name;
    int maxRun;
    int maxJump;

    public Entity(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    public String getName() {
        return name;
    }

    void info() {
        System.out.println(this.getClass() + name + " can run " + maxRun + " can jump " + maxJump);
    }

    @Override
    public boolean run(int runDistance) {
        if (runDistance <= this.maxRun) {
            System.out.println(this.getClass().getSimpleName() + " " + name + " successfully ran " + runDistance);
            return true;
        } else {
            System.out.println(this.getClass().getSimpleName() + " " + name + " can't run " + runDistance + " it can only " + maxRun);
            return false;
        }
    }

    @Override
    public boolean jump(int jumpHeight) {
        if (jumpHeight <= this.maxJump) {
            System.out.println(this.getClass().getSimpleName() + " " + name + " successfully jumped over " + jumpHeight);
            return true;
        } else {
            System.out.println(this.getClass().getSimpleName() + " " + name + " can't jump over " + jumpHeight + " it can only " + maxJump);
            return false;
        }
    }

}
