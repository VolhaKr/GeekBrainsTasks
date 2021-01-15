package lesson2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    public String getMessage() {
        final String myArraySizeException = "MyArraySizeException";
        return myArraySizeException;
    }
}
