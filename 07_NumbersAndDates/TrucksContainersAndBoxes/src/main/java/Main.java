import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */


        double amountBoxes = Double.parseDouble(boxes); //Количество ящиков, полученное от пользователя (строка преобразована в примитив "Double").
        double amountContainers = Math.ceil(amountBoxes / 27); //Количество контейнеров
        double amountTrucks = Math.ceil(amountContainers / 12); //Количество грузовиков

        int numberContainer = 1; //Начальный номер первого контейнера
        int numberBox = 1; //Начальный номер первого ящика

        for (int i = 1; i <= amountTrucks; i++)
        {
            System.out.println("Грузовик: " + i);

            for (numberContainer = numberContainer; numberContainer <= amountContainers; numberContainer++)
            {
                System.out.println("\tКонтейнер: " + numberContainer);
                int currentBox = 1; //Первый ящик в контейнере

                while (currentBox <= 27)
                {
                    if (numberBox <= amountBoxes)
                    {
                        System.out.println("\t\tЯщик: " + numberBox);
                        numberBox++;
                        currentBox++;
                    }
                    else
                        break;
                }

                if (numberContainer == 12) {
                    numberContainer = ++numberContainer;
                    break;
                }
            }
        }

        System.out.println("Необходимо:\nгрузовиков - " + (int) amountTrucks
                                + " шт.\nконтейнеров - " + (int) amountContainers + " шт.");

    }

}
