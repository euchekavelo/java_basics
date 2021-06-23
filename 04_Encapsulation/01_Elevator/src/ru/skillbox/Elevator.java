package ru.skillbox;

public class Elevator {

    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;
    private double limitWeight = 400.0; //Лимит веса кг
    private int emergencyFloor = 15; //Аварийный этаж

    public Elevator(int minFloor, int maxFloor)
    {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor()
    {
       return currentFloor;
    }

    public boolean moveDown(double weight)
    {
        if (currentFloor != emergencyFloor)
        {
            if (weight <= limitWeight)
            {
                int nextFloor = currentFloor - 1;
                if (nextFloor >= minFloor && nextFloor != emergencyFloor) {
                    currentFloor = nextFloor;
                    System.out.println("Текущий этаж: " + currentFloor);
                    return true;
                }
                else {
                    System.out.println("Этаж " + nextFloor + " является аварийным. Движение дальше запрещено.");
                    return false;
                }
            }
            else
            {
                System.out.println("Лифт перегружен! Движение невозможно.");
                return false;
            }
        }
        else {
            System.out.println("Лифт не работает!");
            return false;
        }
    }

    public boolean moveUp(double weight)
    {
        if (currentFloor != emergencyFloor)
        {
           if (weight <= limitWeight)
           {
               int nextFloor = currentFloor + 1;
               if (nextFloor <= maxFloor && nextFloor != emergencyFloor) {
                   currentFloor = nextFloor;
                   System.out.println("Текущий этаж: " + currentFloor);
                   return true;
               }
               else {
                   System.out.println("Этаж " + nextFloor + " является аварийным. Движение дальше запрещено.");
                   return false;
               }
           }
           else
           {
               System.out.println("Лифт перегружен! Движение невозможно.");
               return false;
           }
        }
        else {
            System.out.println("Лифт не работает!");
            return false;
        }
    }

    public void move(int floor, double currentWeight)
    {
        //Проверяем - находится ли требуемый этаж строго в диапазоне между минимальным и максимальным этажами.
        if (floor >= minFloor && floor <= maxFloor)
        {
            //Определим текущий этаж, на котором находится лифт
            int currentFloor = getCurrentFloor();
            boolean movementComplete;
            //постепенно поднимаем лифт, вызывая метод "moveUp", а также выводим текущий этаж.
            while(currentFloor < floor)
            {
                movementComplete = moveUp(currentWeight);
                if (movementComplete)
                    currentFloor++;
                else
                    break;
            }

            //Постепенно опускаем лифт, вызывая метод "moveDown" и выводя текущий этаж.
            while(currentFloor > floor)
            {
                movementComplete = moveDown(currentWeight);
                if (movementComplete)
                    currentFloor--;
                else
                    break;
            }
        }
        else
        {
            //Выводим в консоль сообщение об ошибке, если требуемый этаж не входит в заданный диапазон
            System.out.println("Требуемый этаж указан неверно.");
        }
    }
}
