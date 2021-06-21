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
        if (floor >= minFloor && floor <= maxFloor)
        {
            int currentFloor = getCurrentFloor();
            if (currentFloor < floor)
            {
                for (int i = currentFloor; i < floor; i++)
                {
                    moveUp();
                    System.out.println(getCurrentFloor());
                }
            }
            else
            {
                for (int i = currentFloor; i > floor; i--)
                {
                    moveDown();
                }
            }
        }
        else
        {
            System.out.println("Требуемый этаж указан неверно");
        }
    }
}
