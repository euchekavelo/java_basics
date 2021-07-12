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

    String outLine= "";
    String regex = "[0-9]*(\\s|,|!|\\?|\\.|[0-9]+|;|:|-)\\s*[0-9]*\\s*";
    Pattern pattern = Pattern.compile(regex);
    String[] words = pattern.split(text);
    for (int i = 0; i < words.length; i++)
    {
      if (i == words.length - 1 || words[i].equals(""))
        outLine = outLine.concat(words[i]);
      else
        outLine = outLine.concat(words[i] + "\n");
    }

    return outLine;
  }

}