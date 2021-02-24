package lesson7hw_annotations;
//1. Создать класс, который может выполнять «тесты»,
//        в качестве тестов выступают классы с наборами методов с аннотациями @TestInterface.
//        Для этого у него должен быть статический метод start(),
//        которому в качестве параметра передается или объект типа Class, или имя класса.
//        Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite,
//        если такой имеется, далее запущены методы с аннотациями @TestInterface,
//        а по завершению всех тестов – метод с аннотацией @AfterSuite.
//        К каждому тесту необходимо также добавить приоритеты (int числа от 1 до 10),
//        в соответствии с которыми будет выбираться порядок их выполнения,
//        если приоритет одинаковый, то порядок не имеет значения.
//        Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре,
//        иначе необходимо бросить RuntimeException при запуске «тестирования».

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationsMainApp {
    private static Object TestExecutes;

//    public class ReflectionApp {
//        @MarkingAnnotation
//        public void markedMethod() {
//            System.out.println("Java");
//        }

    public static void main(String[] args) {
        try {
            RunAnnotations.run("lesson7hw_annotations.TestExecutes");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


    
