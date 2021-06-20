public class Arithmetic {

    private int firstNumber;
    private int secondNumber;

    public Arithmetic(int firstNumber, int secondNumber)
    {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    //Сумма двух чисел
    public int getSumNumbers()
    {
        return firstNumber + secondNumber;
    }

    //Разность первого и второго числа
    public int getDifferenceBetweenFirstSecondNumbers()
    {
        return firstNumber - secondNumber;
    }

    //Разность второго и первого числа
    public int getDifferenceBetweenSecondFirstNumbers()
    {
        return secondNumber - firstNumber;
    }

    //Произведение двух чисел
    public int getCompositionNumbers()
    {
        return firstNumber * secondNumber;
    }

    //Среднее значение двух чисел
    public double getAverageValueNumbers()
    {
        return (firstNumber + secondNumber) / 2.0;
    }

    //Максимальное значение из двух чисел
    public int getMaxNumbers()
    {
        if (firstNumber >= secondNumber)
        {
            return firstNumber;
        }
        return secondNumber;
    }

    //Минимальное значение из двух чисел
    public int getMinNumbers()
    {
        if (firstNumber <= secondNumber)
        {
            return firstNumber;
        }
        return secondNumber;
    }
}
