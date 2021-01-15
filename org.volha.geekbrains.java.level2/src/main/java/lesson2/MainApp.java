package lesson2;
//Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
// При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//        Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
//        Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
//        должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
//          В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета.

public class MainApp {
    public static void main(String[] args) {
        String array[][] = new String[][]{
                {"1", "23", "2", "3"},
                {"1", "23", "2", "3"},
                {"1", "2o3", "2", "3"},
                {"1", "23", "29", "3"}
        };
        try {
            System.out.println(sumArray(array));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage() + " Array size must be 4*4");
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int sumArray(String[][] array) throws MyArrayDataException, MyArraySizeException {
        checkArguments(array);
        int sum = 0;
        for ( int i = 0; i < 4; i++ ) {
            for ( int j = 0; j < 4; j++ ) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }

    private static void checkArguments(String[][] array) throws MyArraySizeException {
        if (array.length != 4) {
            throw new MyArraySizeException();
        } else {
            for ( int i = 0; i < 4; i++ ) {
                if (array[i].length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }
    }
}
