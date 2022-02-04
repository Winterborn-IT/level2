package lesson2;

public class MyArrayDataException extends NumberFormatException {
    private String element;

    public MyArrayDataException(String s, String element) {
        super(s);
        this.element = element;
    }
}
