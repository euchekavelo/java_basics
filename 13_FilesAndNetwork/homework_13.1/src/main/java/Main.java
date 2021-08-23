import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            System.out.println("Укажите путь до папки:");
            String line = scanner.nextLine().trim();
            System.out.println("Размер запрашиваемой папки равен: " + FileUtils.calculateFolderSize(line) + " byte.");
        }

    }
}
