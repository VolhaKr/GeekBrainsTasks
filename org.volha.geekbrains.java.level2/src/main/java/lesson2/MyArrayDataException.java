package lesson2;

public class MyArrayDataException extends NumberFormatException {
    int i;
    int j;

    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public String getMessage() {
        final String MyArrayDataException = "MyArrayDataException:" + " Wrong data for element " + "[" + i + "]" + "[" + j + "]";
        return MyArrayDataException;
    }
}
