import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

      String inputWithoutSpaces = input.trim(); //Очистим строку, полученную от пользователя, от пробелов в начале и конце.
      int lengthString = inputWithoutSpaces.length(); //Переменная для хранения длины очищенной строки.
      int countSpaces = 0; //Переменная для подсчета количества пробелов в строке
      boolean isValidateLine = true; //Переменная для хранения признака "Строка является допустимой"

      for (int i = 0; i < lengthString; i++)
      {
        char symbol = inputWithoutSpaces.charAt(i);
        if (symbol == ' '|| (symbol >= 'а' && symbol <= 'я') || (symbol >= 'А' && symbol <='Я')
                || symbol == 'ё' || symbol == 'Ё' || symbol == '-')
        {
          if (symbol == ' ')
            countSpaces++;
        }
        else
        {
          isValidateLine = false;
          break;
        }
      }

      if (countSpaces != 2 || !isValidateLine)
        System.out.println("Введенная строка не является ФИО");
      else
      {
        //Получим фамилию
        int firstSpace = inputWithoutSpaces.indexOf(" ");
        String surname = inputWithoutSpaces.substring(0, firstSpace);

        //Получим отчество
        int secondSpace = inputWithoutSpaces.lastIndexOf(" ");
        String middleName = inputWithoutSpaces.substring(secondSpace, lengthString).trim();

        //Получим имя
        String name = inputWithoutSpaces.substring(firstSpace, secondSpace).trim();

        if (!name.equals("")) {
          String outputLine = "Фамилия: " + surname;
          System.out.println(outputLine.concat("\nИмя: " + name).concat("\nОтчество: " + middleName));
        }
        else
          System.out.println("Введенная строка не является ФИО");
      }

    }

  }

}