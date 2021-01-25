package Lesson5;
//Необходимо написать два метода, которые делают следующее:
//        1) Создают одномерный длинный массив, например:
//static final int SIZE = 10 000 000;
//static final int HALF = size / 2;
//        float[] arr = new float[size];
//        2) Заполняют этот массив единицами.
//        3) Засекают время выполнения: long a = System.currentTimeMillis().
//        4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
//
//        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//
//        5) Проверяется время окончания метода System.currentTimeMillis().
//        6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a).
//
//        Отличие первого метода от второго:
//        Первый просто бежит по массиву и вычисляет значения.
//        Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
//
//        Пример деления одного массива на два:
//        System.arraycopy(arr, 0, a1, 0, h);
//        System.arraycopy(arr, h, a2, 0, h).
//
//        Пример обратной склейки:
//        System.arraycopy(a1, 0, arr, 0, h);
//        System.arraycopy(a2, 0, arr, h, h).
//
//        Примечание:
//        System.arraycopy() — копирует данные из одного массива в другой:
//        System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
//        По замерам времени:
//        Для первого метода надо считать время только на цикл расчета:
//        for (int i = 0; i < size; i++) {
//        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//
//        Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.


public class MainApp {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] arrOneInit = new float[SIZE];
    static float[] arrTwoInit = new float[SIZE];
    static float[] arrTwoResult = new float[SIZE];

    public static void main(String[] args) throws InterruptedException {
        for ( int i = 0; i < SIZE; i++ ) {
            arrOneInit[i] = 1;
            arrTwoInit[i] = 1;
        }
        twoThreadsCalculate(arrOneInit);
        oneThreadCalculate(arrTwoInit);
        for ( int i = 0; i < SIZE; i++ ) {
            if (arrOneInit[i] != arrTwoResult[i]) {
                System.out.println("Sos!!!!!" + "i " + i + " " + arrOneInit[i] + " " + arrTwoResult[i]);
            }
        }
    }

    public static void oneThreadCalculate(float[] arrTwoInit) {
        long startOneThreadCalc = System.currentTimeMillis();
        for ( int i = 0; i < SIZE; i++ ) {
            arrOneInit[i] = (float) (arrOneInit[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread calculation took " + (System.currentTimeMillis() - startOneThreadCalc));
    }

    public static void twoThreadsCalculate(float[] arrOneInit) {
        long startTwoThreadsCalculate = System.currentTimeMillis();
        float[] arrTwoInitBegin = new float[HALF];
        float[] arrTwoInitEnd = new float[HALF];
        long startTwoThreadsCalc = System.currentTimeMillis();

        System.arraycopy(arrTwoInit, 0, arrTwoInitBegin, 0, HALF);
        System.arraycopy(arrTwoInit, HALF, arrTwoInitEnd, 0, HALF);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for ( int i = 0; i < HALF; i++ ) {
                    arrTwoInitBegin[i] = (float) (arrTwoInitBegin[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int j;
                for ( int i = 0; i < HALF; i++ ) {
                    j = i + HALF;
                    arrTwoInitEnd[i] = (float) (arrTwoInitEnd[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arrTwoInitBegin, 0, arrTwoResult, 0, HALF);
        System.arraycopy(arrTwoInitEnd, 0, arrTwoResult, HALF, HALF);
        System.out.println("Two threads calculation took " + (System.currentTimeMillis() - startTwoThreadsCalc));

    }


}
