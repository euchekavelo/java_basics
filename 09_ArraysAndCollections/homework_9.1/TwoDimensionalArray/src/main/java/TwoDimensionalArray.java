public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        char[][] dimensionalArray = new char[size][size];

        for (int i = 0; i < dimensionalArray.length; i++)
        {
            int currentIteration = i;
            for (int j = 0; j < dimensionalArray[i].length; j++)
            {
                if (j == currentIteration)
                {
                    dimensionalArray[i][j] = symbol;
                    dimensionalArray[i][dimensionalArray[i].length - 1 - currentIteration] = symbol;
                }
                else if (dimensionalArray[i][j] == 0)
                    dimensionalArray[i][j] = ' ';
            }
        }

        return dimensionalArray;
    }
}
