import java.util.stream.IntStream;

//1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив. Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
//        Написать набор тестов для этого метода (по 3-4 варианта входных данных).
//        Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
public class ArrayOperations {
    static final int criticNumber = 4;
    static final int arrayMember1 = 1;
    static final int arrayMember2 = 4;


    int[] arrayCut(int[] arr) throws RuntimeException {
        int[] subArr = new int[]{};
        for ( int i = arr.length - 1; i >= 0; i-- ) {
            if (arr[i] == criticNumber) {
                subArr = IntStream.range(i + 1, arr.length)
                        .map(j -> arr[j])
                        .toArray();
                return subArr;
            }
            if (i == 0) {
                throw new RuntimeException();
            }
        }
        System.out.println("Result array ");
        for ( int a : subArr ) {
            System.out.println(a);
        }
        return subArr;
    }

//
//    2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то метод вернет false; Если содержится что то кроме 1 и 4, то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
//            [ 1 1 1 4 4 1 4 4 ] -> true
//            [ 1 1 1 1 1 1 ] -> false
//            [ 4 4 4 4 ] -> false
//            [ 1 4 4 1 1 4 3 ] -> false
    
    boolean checkMembers(int[] array) {
        boolean foundArrayMember1 = false;
        boolean foundArrayMember2 = false;
        for ( int a : array ) {
            if (a == arrayMember1) {
                foundArrayMember1 = true;
            } else {
                if (a == arrayMember2) {
                    foundArrayMember2 = true;
                } else {
                    return false;
                }
            }
        }
        return (foundArrayMember1 && foundArrayMember2);
    }
}
