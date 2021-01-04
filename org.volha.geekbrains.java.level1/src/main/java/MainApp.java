import java.util.Arrays;

public class MainApp {
    //1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
    public static void main(String[] args) {

        //2. Создать переменные всех пройденных типов данных и инициализировать их значения.
        //  byte    8-битное знаковое целое число     от -128 до 127
        byte byteExample = -46;

        //  short   16-битное знаковое целое число    от -32768 до 32767
        short shortExample = 14111;

        //  int     32-битное знаковое целое число   от -2147483648 до 2147483647
        int intExample = 135798642;

        //  long    64-битное знаковое целое число  от -9223372036854775808  до 9223372036854775807
        long longExample = 2L;

        //  float     32-битное знаковое число с плавающей запятой одинарной точности
        float floatExample = 1.23456789f;
        float floatPi = 22f / 7;
        System.out.println("float Pi = " + floatPi);

        //  double    64-битное знаковое число с плавающей запятой двойной точности
        double doubleExample = -123.456;
        double doublePi = (double) 22 / 7;
        System.out.println("double Pi = " + doublePi);

        // char 16-битный тип данных, предназначенный для хранения символов в кодировке Unicode
        // от '\u0000' или 0   до '\uffff' или 65,535
        char charExample = '#';
        char charByte = 65;
        char charUnicode = '\u1111';
        System.out.println("char " + charExample + " " + charByte + " " + charUnicode);

        //boolean  логический тип данных        false, true
        boolean booleanExample = false;

        /// then follow test method calls
        System.out.println(calculateExpression(3, 7, 6, 2) + " must be 30");

        System.out.println(checkSumBetween10_20(6, 11) + " must be true");
        System.out.println(checkSumBetween10_20(6, -11) + " must be false");

        System.out.println ("Is 56 positive?");
        printIfPositive(56);

        printHello("Fanzil");

        System.out.println(checkIfNegative(-121) + " must be true");
        System.out.println(checkIfNegative(0) + " must be false");

        printYearLeap(1974);
        printYearLeap(2000);
        printYearLeap(1800);
    }

    //3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    // где a, b, c, d – аргументы этого метода, имеющие тип float.
    public static float calculateExpression(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    //4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно)
    // , если да – вернуть true, в противном случае – false.
    public static boolean checkSumBetween10_20(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    //5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    // положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    public static void printIfPositive(int a) {
        System.out.println("a " + a + " is >= 0  - " + (a >= 0));
    }

    //6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    // если число отрицательное, и вернуть false если положительное.
    public static boolean checkIfNegative(int a) {
        return a < 0;
    }

    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
    // Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    public static void printHello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    //8. *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    //Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static void printYearLeap (int year){
        boolean yearLeapness = (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
        System.out.println( "year " + year + " is leap " + yearLeapness);
    }


}
