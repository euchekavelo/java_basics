import java.util.Scanner;

public class InputUser {

    public static String getLine()
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        return input;
    }
}
