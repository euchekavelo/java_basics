import java.util.Set;

public class Main {

    private final static String DIGITAL_INPUT = "\\p{Digit}+";
    private final static String ALPHABET_INPUT = "[а-яА-Я]+";

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        while (true)
        {
            System.out.println("Введите номер, имя или команду:");
            String inputUser = InputUser.getLine();
            if (inputUser.equals("LIST"))
            {
                phoneBook.list();
            }
            else if (inputUser.matches(DIGITAL_INPUT))
            {
                String foundPhone = phoneBook.getNameByPhone(inputUser);
                if (foundPhone.isEmpty())
                {
                    System.out.println("Такого номера нет в телефонной книге.\n" +
                            "Введите имя абонента для номера \"" + inputUser + "\":");
                    String inputName = InputUser.getLine();
                    phoneBook.addContact(inputUser, inputName);
                }
                else
                    System.out.println(foundPhone);
            }
            else if (inputUser.matches(ALPHABET_INPUT))
            {
                Set<String> subscribers = phoneBook.getPhonesByName(inputUser);
                if (subscribers.isEmpty())
                {
                    System.out.println("Такого имени в телефонной книге нет.\n" +
                            "Введите номер телефона для абонента \"" + inputUser + "\":");
                    String inputTelephone = InputUser.getLine();
                    phoneBook.addContact(inputTelephone, inputUser);
                }
                else
                {
                    for (String element : subscribers)
                    {
                        System.out.println(element);
                    }
                }
            }
            else
                System.out.println("Неверный формат ввода");
        }

    }
}
