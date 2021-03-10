package lesson7hw_annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class RunAnnotations {

    public static void run(String classToRunTestsName) throws ClassNotFoundException {
        Class ClassToRunTests = Class.forName(classToRunTestsName);
        int countBeforeSuit = 0;
        int countAfterSuit = 0;
        Method methodBeforeSuit = null;
        Method methodAfterSuit = null;
        Method[] methods = ClassToRunTests.getDeclaredMethods();
        ArrayList<MethodWithPriority> arrayOfMethods = new ArrayList<>();
        // ClassToRunTests.class.getDeclaredMethods();

        for ( Method o : methods ) {
            if (o.getAnnotation(BeforeSuit.class) != null) {
                countBeforeSuit++;
                if (countBeforeSuit > 1) {
                    System.out.println("Too much the same");
                    throw new RuntimeException();
                }
                methodBeforeSuit = o;
            }
            if (o.getAnnotation(AfterSuit.class) != null) {
                countAfterSuit++;
                if (countAfterSuit > 1) {
                    System.out.println("Too much the same");
                    throw new RuntimeException();
                }
                methodAfterSuit = o;
            }
            if (o.getAnnotation(Test.class) != null) {
                arrayOfMethods.add(new MethodWithPriority(o.getAnnotation(Test.class).priority(), o));
            }
        }

///good solution when priority is unique
//            if (o.getAnnotation(Test.class) != null) {
//                priorityMethod.put(o.getAnnotation(Test.class).priority(), o);
//            }
//        }
//
//
//        for ( Map.Entry<Integer, Method> entry : priorityMethod.entrySet()) {
//          // Integer key = entry.getKey();
//            Method value = entry.getValue();
//            try {
//                value.invoke(ClassToRunTests);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
///good solution when priority is unique

//            }
//        }
//
        if (countBeforeSuit == 1) {
            try {
                methodBeforeSuit.invoke(ClassToRunTests);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        arrayOfMethods.stream().sorted(Comparator.comparing(MethodWithPriority::getPriority)).forEach((t) -> {
            try {
                t.getMethod().invoke(ClassToRunTests);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
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

//
//        for ( Method m : methods ) {
//            if (m.getAnnotation(Test.class) != null) {
//                System.out.println("Test must be executed");
//                System.out.println ("priority is "+ m.getAnnotation(Test.class).priority());
//              //  Field[] fields = ClassToRunTests.getDeclaredFields();
//                try {
//                    Field field = ClassToRunTests.getDeclaredField("priority");
//                                        try {
//                        System.out.println("priority = getint " + field.getInt(ClassToRunTests) +" get "+field.get(ClassToRunTests));
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//                } catch (NoSuchFieldException e) {
//                    e.printStackTrace();
//                }
//System.out.println(m.getAnnotation(ClassToRunTests).priority());
//                for (Field field : fields){
//                    try {
//
//                        Field field = c1.getDeclaredField("color");
////        field.setAccessible(true);
//        System.out.println(field.get(cat));
//        field.set(cat, "purple");
//                        System.out.println("field name " + field.getName() + "field value: "+ ClassToRunTests.getField(field.getName()));
//                    } catch (NoSuchFieldException e) {
//                        e.printStackTrace();
//                    }
//                }
//                try {
//                    m.invoke(ClassToRunTests);
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                } catch (InvocationTargetException e) {
//                    e.printStackTrace();
//                }
//            }
//        }


