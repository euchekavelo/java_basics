public class Main {
    public static void main(String[] args) {
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив

        char[][] dimensionalArray = TwoDimensionalArray.getTwoDimensionalArray(7);

        for (char[] elemFirstArray : dimensionalArray)
        {
            for (char elemSecondArray : elemFirstArray)
            {
                System.out.print(elemSecondArray);
            }
            System.out.println();
        }
    }
}
