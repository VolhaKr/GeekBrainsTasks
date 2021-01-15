package lesson2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    public String getMessage() {
        final String myArraySizeException = "Exception MyArraySizeException";
        return myArraySizeException;
    }
}
