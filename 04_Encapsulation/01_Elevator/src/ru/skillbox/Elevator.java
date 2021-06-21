package ru.skillbox;

public class Elevator {

    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor)
    {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor()
    {
       return currentFloor;
    }

    public void moveDown()
    {
        currentFloor = currentFloor - 1;
    }

    public void moveUp()
    {
        currentFloor = currentFloor + 1;
    }

    public void move(int floor)
    {
        //Проверяем - находится ли требуемый этаж строго в диапазоне между минимальным и максимальным этажами.
        if (floor >= minFloor && floor <= maxFloor)
        {
            //Определим текущий этаж, на котором находится лифт
            int currentFloor = getCurrentFloor();

            //Если текущий этаж лифта меньше требуемого этажа, тогда постепенно поднимаем лифт,
            //вызывая метод "moveUp", а также выводим текущий этаж.
            if (currentFloor < floor)
            {
                for (int i = currentFloor; i < floor; i++)
                {
                    moveUp();
                    System.out.println("Текущий этаж: " + getCurrentFloor());
                }
            }
            //Иначе постепенно опускаем лифт, вызывая метод "moveDown" и выводя текущий этаж.
            else
            {
                for (int i = currentFloor; i > floor; i--)
                {
                    moveDown();
                    System.out.println("Текущий этаж: " + getCurrentFloor());
                }
            }
        }
        else
        {
            //Выводим в консоль сообщение об ошибке, если требуемый этаж не входит в заданный диапазон
            System.out.println("Требуемый этаж указан неверно.");
        }
    }
}
