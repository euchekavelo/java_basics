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

      String regex = "[а-яА-Я-]+\\s[а-яА-Я-]+\\s[а-яА-Я-]+";

      if (!input.matches(regex))
        System.out.println("Введенная строка не является ФИО");
      else
      {
        String[] words = input.split(" ");
        String surname = words[0]; //Получим фамилию
        String name = words[1]; //Получим имя
        String middleName = words[2]; //Получим отчество

        String outputLine = "Фамилия: " + surname;
        System.out.println(outputLine.concat("\nИмя: " + name).concat("\nОтчество: " + middleName));
      }
    }
  }

}