public class Main {

    public final static String WRONG_EMAIL_ANSWER = "Неверный формат email";
    private final static String COMMAND_ADD = "ADD ";
    private final static String COMMAND_LIST = "LIST";

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

        EmailList emailList = new EmailList();

        while (true) {
            String userInput = UserInput.getLine();
            if (userInput.startsWith(COMMAND_ADD))
            {
                emailList.add(userInput.replaceFirst(COMMAND_ADD, "").trim());
            }
            else if (userInput.equals(COMMAND_LIST))
            {
                emailList.printList();
            }
            else
                System.out.println("Введена неверная команда");
        }
    }
}
