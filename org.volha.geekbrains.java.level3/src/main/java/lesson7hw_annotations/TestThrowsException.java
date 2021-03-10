package lesson7hw_annotations;

public class TestThrowsException {
    @BeforeSuit
    public static void testBeforeSuit() {
        System.out.println("@BeforeSuit executed");
    }
    @BeforeSuit
    public static void testBeforeSuit2() {
        System.out.println("@BeforeSuit executed");
    }
}
