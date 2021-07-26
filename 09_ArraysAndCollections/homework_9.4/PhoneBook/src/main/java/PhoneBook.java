import java.util.*;

public class PhoneBook {

    private Map<String, String> phoneBook = new TreeMap<>();
    private final static String REGEX_NAME = "[А-Я][а-я]+";
    private final static String REGEX_PHONE_NUMBER = "79\\p{Digit}{9}";

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента

        if (name.matches(REGEX_NAME) && phone.matches(REGEX_PHONE_NUMBER))
        {
            phoneBook.put(phone, name);
            System.out.println("Контакт сохранен!");
        }
        else
            System.out.println("Неверный формат ввода имени или телефона.\n" +
                    "Имя абонента должно состоять минимум из 2-ух букв русского алфавита, где 1-ая буква - заглавная, 2-ая - строчная.\n" +
                    "Номер телефона должен состоять из 11 цифр, где первые два числа 7 и 9.");
    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку

        if (phoneBook.get(phone) == null)
            return "";
        else
            return phoneBook.get(phone) + " - " + phone;
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet

        Set<String> foundContacts = new TreeSet<>();
        for (Map.Entry<String, String> element : phoneBook.entrySet())
        {
            String currentKey = element.getKey();
            String currentValue = element.getValue();
            if (currentValue.equals(name))
            {
                foundContacts.add(currentValue + " - " + currentKey);
            }
        }

        return foundContacts;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet

        Set<String> printAllContacts = new TreeSet<>();
        for (String key : phoneBook.keySet())
        {
            printAllContacts.add(phoneBook.get(key) + " - " + key);
        }

        return printAllContacts;
    }

    public void list()
    {
        Map <String, String> newMap = new TreeMap<>();
        HashSet <String> uniqueValue = new HashSet(phoneBook.values());
        for (String element : uniqueValue)
        {
            //Зададим индикатор, который будет учитываться в проверки найденного дубля значения.
            boolean initialFinding = false;
            for (Map.Entry<String, String> entry : phoneBook.entrySet())
            {
                String currentKey = entry.getKey();
                String currentValue = entry.getValue();
                if (element.equals(currentValue) && !initialFinding)
                {
                    newMap.put(element, currentKey);
                    initialFinding = true;
                }
                else if (element.equals(currentValue) && initialFinding)
                {
                    String currentValueNewMap = newMap.get(element);
                    newMap.put(element, currentValueNewMap + ", " + currentKey);
                }
            }
        }

        String outLine = "";
        for (String key : newMap.keySet())
        {
            outLine = outLine.concat(key + " - " + newMap.get(key) + "\n");
        }

        System.out.println(outLine.trim());
    }
}