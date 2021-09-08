import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox";
        String query = "SELECT course_name, " +
                "\n\tROUND(COUNT(*) / (TIMESTAMPDIFF(MONTH, min(subscription_date), max(subscription_date)) + 1), 2) as avg_months_sales\n" +
                "FROM purchaselist\n" +
                "WHERE year(subscription_date) = 2018\n" +
                "group by course_name\n" +
                "ORDER BY course_name;";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите пользователя:");
            String user = scanner.nextLine();
            System.out.println("Введите пароль:");
            String password = scanner.nextLine();
            System.out.println("Получение выборки:\n--------------------------------");
            WorkingWithSqlDatabase workingWithSqlDatabase = new WorkingWithSqlDatabase(url, user, password);
            workingWithSqlDatabase.getInformationFromConnection(query);
            System.out.println("------------------------------------");
        }
    }

}
