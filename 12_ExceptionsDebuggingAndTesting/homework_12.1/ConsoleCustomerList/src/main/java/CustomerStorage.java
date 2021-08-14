import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;
    private final static String REGEX_PHONE = "(\\+?7|8)9\\p{Digit}{9}";
    private final static String REGEX_EMAIL = "\\p{Alpha}\\p{Alnum}*@\\p{Alpha}+\\.(\\p{Alpha}){2,}";

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if (components.length == 4) {
            if (!components[INDEX_PHONE].matches(REGEX_PHONE))
                throw new IllegalArgumentException("Задано некорректное значение номера телефона.");
            if (!components[INDEX_EMAIL].matches(REGEX_EMAIL))
                throw new IllegalArgumentException("Задано некорректное значение электронной почты.");

            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
        }
        else
            throw new IllegalArgumentException("Получено неверное количество компонентов в переданной строке.");
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}