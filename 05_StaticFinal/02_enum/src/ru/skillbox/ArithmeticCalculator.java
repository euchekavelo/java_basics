package ru.skillbox;

public class ArithmeticCalculator {

    private final int firstNumber;
    private final int secondNumber;

    public ArithmeticCalculator(int firstNumber, int secondNumber)
    {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public void calculate(Operation operation)
    {
        switch (operation)
        {
            case ADD -> System.out.println("Сума первого и второго числа: " + (firstNumber + secondNumber));
            case SUBTRACT -> System.out.println("Разность первого и второго числа: " + (firstNumber - secondNumber));
            case MULTIPLY -> System.out.println("Произведение первого и второго чисел: " + (firstNumber * secondNumber));
        };

    }
}
