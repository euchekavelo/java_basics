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

      String regex = "[^0-9]";
      String phoneNumber = input.replaceAll(regex, "");
      if (phoneNumber.length() == 11 && phoneNumber.charAt(0) == '8')
      {
        phoneNumber = phoneNumber.replaceFirst("8", "7");
        System.out.println(phoneNumber);
      }
      else if (phoneNumber.length() == 10)
      {
        String numberSeven = "7";
        phoneNumber = numberSeven.concat(phoneNumber);
        System.out.println(phoneNumber);
      }
      else if (phoneNumber.length() > 11) {
        System.out.println("Неверный формат номера");
      } else if (phoneNumber.length() < 10) {
        System.out.println("Неверный формат номера");
      } else if (phoneNumber.charAt(0) != '7') {
        System.out.println("Неверный формат номера");
      } else {
        System.out.println(phoneNumber);
      }
    }
  }

}
