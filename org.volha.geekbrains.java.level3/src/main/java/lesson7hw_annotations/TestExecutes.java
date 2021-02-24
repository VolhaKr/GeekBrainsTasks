package lesson7hw_annotations;

public class TestExecutes {

    @BeforeSuit
    public static void testBeforeSuit() {
        System.out.println("@BeforeSuit executed");
    }

    @Test
    public void testMethodWith1Priority() {
        System.out.println("Test  1 run");
    }

    @Test
    public static void testMethodWith5Priority() {
        System.out.println("Test  5 run");
    }

    @AfterSuit
    public static void testAfterSuit(){
        System.out.println("@AfterSuit executed");
    }






}
