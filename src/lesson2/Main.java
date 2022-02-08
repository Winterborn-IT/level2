package lesson2;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"13", "2", "56", "7"},
                {"8", "3", "13", "67"},
                {"26", "2", "45", "5"},
                {"35", "0", "7", "40"},
        };

        try {
            arraySum(arr);
        } catch (MyArraySizeException | MyArrayDataException exception) {
            exception.printStackTrace();
        }

    }

    public static void arraySum(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (!(arr.length == 4 && arr[i].length == 4)) {
                    throw new MyArraySizeException("Размерность массива не соответствует 4х4");
                }

                for (char c : arr[i][j].toCharArray()) {
                    if (!(Character.isDigit(c))) {
                        throw new MyArrayDataException("Ячейка [" + i + "][" + j + "] не является числом, " +
                                "содержит \"" + arr[i][j] + "\"", arr[i][j]);
                    }
                }

                sum += Integer.parseInt(arr[i][j]);
            }
        }
        System.out.println(sum);
    }
}
