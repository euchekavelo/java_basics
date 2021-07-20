import java.util.Scanner;

public class Main {

    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    public static EmailList emailList = new EmailList();

    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            //TODO: write code here
            String prefixAdd = "ADD ";
            String regexList = "LIST";

            if (input.startsWith(prefixAdd))
            {
                int lengthInput = input.length();
                String textLine = input.substring(input.indexOf(" ") + 1, lengthInput);
                emailList.add(textLine);
            }
            else if (input.matches(regexList))
            {
                emailList.list(emailList.getSortedEmails());
            }

        }
    }
}
