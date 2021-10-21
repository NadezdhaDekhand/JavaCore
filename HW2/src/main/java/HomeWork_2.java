public class HomeWork_2 {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "5", "3" ,"4"},
                {"1", "p", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };


            try {
                 method(arr);


            } catch (MyArraySizeException |MyArrayDataException e ) {
                e.printStackTrace();


        }

    }


    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException("Неверное количество строк");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException(String.format("Неверное количество столбцов в %d-й" +
                        " строке", i));
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return count;
    }

}
class MyArrayDataException extends Exception {

    MyArrayDataException( int i, int j) {

        super(String.format("Неправильное значение массива!Ошибка в %d-й" + " строке", i + 1));

    }

}
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}