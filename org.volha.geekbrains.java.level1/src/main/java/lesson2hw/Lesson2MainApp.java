package lesson2hw;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.abs;

public class Lesson2MainApp {

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

    public static int[] negateNewArray(int arrayLength) {
        int[] arrayToNegate = new int[arrayLength];
        Random random = new Random();
        for ( int i = 0; i < arrayLength; i++ ) {
            arrayToNegate[i] = random.nextInt(2);
        }
        System.out.println(Arrays.toString(arrayToNegate));
        int[] arrayNegated = new int[arrayLength];
        for ( int i = 0; i < arrayLength; i++ ) {
            arrayNegated[i] = 1 - arrayToNegate[i];
        }
        System.out.println(Arrays.toString(arrayNegated));
        return arrayToNegate;
    }

    //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

    public static int[] createPlus3Array() {
        int[] plus3Array = new int[8];
        for ( int i = 1; i < 8; i++ ) {
            plus3Array[i] = plus3Array[i - 1] + 3;
        }
        System.out.println(Arrays.toString(plus3Array));
        return plus3Array;
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

    public static int[] processArray() {
        int[] processedArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(processedArray));
        for ( int i = 0; i < 12; i++ ) {
            if (processedArray[i] < 6) {
                processedArray[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(processedArray));
        return processedArray;
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

    public static int[][] createArrayWithDiagonals(int length) {
        int[][] array = new int[length][length];
        for ( int i = 0; i < length; i++ ) {
            for ( int j = 0; j < length; j++ ) {
                if ((i == j) || (i == length - 1 - j)) {
                    array[i][j] = 1;
                }
                System.out.printf("%3d", array[i][j]);
            }
            System.out.printf("%n");
        }
        return array;
    }

    //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void findArrayMinMax(int arrayLength) {
        int[] array = new int[arrayLength];
        int min;
        int max;
        Random random = new Random();
        for ( int i = 0; i < arrayLength; i++ ) {
            array[i] = random.nextInt(10);
        }
        System.out.println("array: " + Arrays.toString(array));
        if (arrayLength == 1) {
            min = array[0];
            max = array[0];
        } else {
            if (array[0] <= array[1]) {
                min = array[0];
                max = array[1];
            } else {
                min = array[1];
                max = array[0];
            }
            for ( int i = 2; i < arrayLength; i++ ) {
                if (array[i] < min) {
                    min = array[i];
                } else {
                    if (array[i] > max) {
                        max = array[i];
                    }
                }
            }
            System.out.println("min: " + min + " max: " + max);
        }
    }

//6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
// если в массиве есть место, в котором сумма левой и правой части массива равны.
// Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
// граница показана символами ||, эти символы в массив не входят.

    public static boolean checkBallance(int[] array) {
        int sumLeft;
        int sumRight = 0;
        if (array.length >= 2) {
            sumLeft = array[0];
            for ( int i = 1; i < array.length; i++ ) {
                sumRight += array[i];
            }
            if (sumLeft == sumRight) {
                return true;
            }
            for ( int j = 1; j < array.length - 1; ) {
                sumLeft += array[j];
                sumRight -= array[j];
                if (sumLeft == sumRight) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    // 7. ****Написать метод, которому на вход подается одномерный массив и число n
    // (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
    // Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.

    public static int[] shiftArray(int[] array, int shiftnumber) {
        System.out.println("array:         " + Arrays.toString(array));
        int arrayLength = array.length;
        int numberToShift = shiftnumber % arrayLength;
        System.out.println(numberToShift);
        if (numberToShift >= 0) {
            for ( int j = 1; j <= numberToShift; j++ ) {
                int array0 = array[0];
                for ( int i = 1; i < arrayLength; i++ ) {
                    array[i - 1] = array[i];
                }
                array[arrayLength - 1] = array0;
            }
        } else {
            numberToShift = abs(numberToShift);
            for ( int j = 1; j <= numberToShift; j++ ) {
                int arrayLast = array[arrayLength - 1];
                for ( int i = arrayLength - 1; i > 0; i-- ) {
                    array[i] = array[i - 1];
                }
                array[0] = arrayLast;
            }
        }
        System.out.println("shifted array: " + Arrays.toString(array));
        return array;
    }

    public static void main(String[] args) {
        negateNewArray(10);
        createPlus3Array();
        processArray();
        createArrayWithDiagonals(8);
        findArrayMinMax(7);
        System.out.println("balance " + checkBallance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        shiftArray(new int[]{1, 2, 3, 1, 2, 2, 10, 1}, -44);
    }
}
