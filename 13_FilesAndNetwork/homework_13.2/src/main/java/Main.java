import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(; ;){
            System.out.println("Введите адрес папки, которую необходимо скопировать: ");
            String sourceDirectory = scanner.nextLine().trim();
            System.out.println("Введите адрес директории, в которую необходимо скопировать папку: ");
            String destinationDirectory = scanner.nextLine().trim();
            FileUtils.copyFolder(sourceDirectory, destinationDirectory);
        }
    }

}
