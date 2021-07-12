import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    String line = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей ";
    System.out.println(calculateSalarySum(line));

  }

  public static int calculateSalarySum(String text){

    int amount = 0; //Сумма
    String regex = "[0-9]+[\\s]";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    while (matcher.find())
    {
      int start = matcher.start();
      int end = matcher.end();
      String textNumber = text.substring(start, end).trim();
      int number = Integer.parseInt(textNumber);
      amount = amount + number;
    }

    return amount;
  }

}