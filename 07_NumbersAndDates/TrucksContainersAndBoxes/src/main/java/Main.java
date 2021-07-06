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

        final int CONTAINERS_IN_TRUCK = 12;
        final int BOXES_IN_CONTAINER = 27;

        double amountBoxes = Double.parseDouble(boxes); //Количество ящиков, полученное от пользователя (строка преобразована в примитив "Double").

        int amountContainers = amountBoxes > 0 ? 1 : 0; //Начальное количество контейнеров
        int amountTrucks = amountBoxes > 0 ? 1 : 0; //Начальное количесвто грузовиков
        String result = "Грузовик: " + amountTrucks + "\n\tКонтейнер: " + amountContainers + "\n";
        for (int i = 1; i <= amountBoxes; i++)
        {
            result = result + "\t\tЯщик: " + i + "\n";
            if (i % BOXES_IN_CONTAINER == 0 )
              {
                  if (i != amountBoxes) {
                      if (amountContainers % CONTAINERS_IN_TRUCK != 0) {
                          result = result + "\tКонтейнер: " + ++amountContainers + "\n";
                      } else {
                          result = result + "Грузовик: " + ++amountTrucks + "\n\tКонтейнер: " + ++amountContainers + "\n";
                      }
                  }
              }
        }

        if (amountBoxes > 0)
            System.out.print(result);

        System.out.println("Необходимо:\nгрузовиков - " + amountTrucks
                + " шт.\nконтейнеров - " + amountContainers + " шт.");
        }
}
