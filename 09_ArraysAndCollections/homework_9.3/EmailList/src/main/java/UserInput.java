import java.util.Scanner;

public class UserInput {

    public static String getLine() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        return input;
    }

}
