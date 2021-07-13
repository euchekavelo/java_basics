import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String text = scanner.nextLine();
      if (text.equals("0")){
        break;
      }

      String outLine = splitTextIntoWords(text);
      System.out.println(outLine);
    }
  }

  public static String splitTextIntoWords(String text) {
    //TODO реализуйте метод

    return text.replaceAll("\\d*(\\s|\\p{Punct}|\\d)\\s*\\d*\\s*", "\n").trim();
  }

}