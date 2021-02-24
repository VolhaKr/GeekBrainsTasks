package lesson7hw_annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunAnnotations {


    public static void run(String classToRunTestsName) throws ClassNotFoundException {
        Class ClassToRunTests = Class.forName(classToRunTestsName);
        int countBeforeSuit = 0;
        int countAfterSuit = 0;
        Method methodBeforeSuit = null;
        Method methodAfterSuit = null;
        Method[] methods = ClassToRunTests.getDeclaredMethods();
        // ClassToRunTests.class.getDeclaredMethods();

        for ( Method o : methods ) {
            if (o.getAnnotation(BeforeSuit.class) != null) {
                countBeforeSuit++;
                methodBeforeSuit = o;
            }

            if (o.getAnnotation(AfterSuit.class) != null) {
                countAfterSuit++;
                methodAfterSuit = o;
            }
        }
        if (countBeforeSuit == 1) {
            try {
                methodBeforeSuit.invoke(TestExecutes.class);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        if (countBeforeSuit > 1 || countAfterSuit > 1) {
            throw new RuntimeException();
        }

        for ( Method m : methods ) {
            if (m.getAnnotation(Test.class) != null) {
                try {
                    m.invoke(ClassToRunTests);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        if (countAfterSuit == 1) {
            try {
                methodAfterSuit.invoke(ClassToRunTests);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}


