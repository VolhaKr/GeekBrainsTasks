package lesson7hw_annotations;

public class TestExecutes {
    static int priority;

    @BeforeSuit
    public static void testBeforeSuit() {
        System.out.println("@BeforeSuit executed");
    }

    @Test (  priority = 56)
    public static void testMethodWith1Priority() {
        System.out.println("Test  with priority 56 run");
          }


    @Test (  priority = 3)
    public static void testMethodWith3Priority() {
        System.out.println("Test  with priority 3 run");
    }

    @Test(  priority = 56)
    public static void testMethodWith56Priority() {
        System.out.println("Test  with priority 56 run");
    }

    @Test
    public static void testMethodWithDefaultPriority() {
        System.out.println("Test  with default priority run");
    }

    @AfterSuit
    public static void testAfterSuit(){
        System.out.println("@AfterSuit executed");
    }






}
