import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MongoStorage mongoStorage = new MongoStorage();
        mongoStorage.init();

        displayHelp();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Введите команду:");
            String input = scanner.nextLine().trim();
            String[] arrayWords = input.split("\\s");

            if (input.matches("ДОБАВИТЬ_МАГАЗИН\\s[а-яА-Я0-9]+"))
                mongoStorage.addStore(arrayWords[1]);
            else if (input.matches("ДОБАВИТЬ_ТОВАР\\s[а-яА-Я]+\\s\\d+(\\.\\d{1,2})?"))
                mongoStorage.addProduct(arrayWords[1], Double.parseDouble(arrayWords[2]));
            else if (input.matches("ВЫСТАВИТЬ_ТОВАР\\s[а-яА-Я]+\\s[а-яА-Я0-9]+"))
                mongoStorage.displayTheProductInTheStore(arrayWords[1], arrayWords[2]);
            else if (input.equals("СТАТИСТИКА_ТОВАРОВ"))
                mongoStorage.getProductStatistics();
            else if(input.equals("ВЫХОД")) {
                System.out.println("Работа программы завершена");
                return;
            }
            else {
                System.out.print("Неверно введена команда.\n");
                displayHelp();
            }
        }

    }

    private static void displayHelp(){
        System.out.println("Для работы с программой рекомендуется использовать одну из следующих команд:"
                + "\nДОБАВИТЬ_МАГАЗИН <Наименование магазина> - команда добавления магазина "
                    + "(для параметра <Наименование магазина> необходимо использовать буквы русского алфавита без пробелов или цифры);"
                + "\nДОБАВИТЬ_ТОВАР <Наименование товара> <Стоимость товара> - команда добавления товара "
                    + "(для параметра <Наименование товара> необходимо использовать буквы русского алфавита, "
                    + "для параметра <Стоимость товара> необходимо использовать цифры до двух знаков после точки);"
                + "\nВЫСТАВИТЬ_ТОВАР <Наименование товара> <Наименование магазина> - команда добавления товара в магазин "
                    + "(для параметра <Наименование товара> необходимо использовать буквы русского алфавита, "
                    + "для параметра <Наименование магазина> - буквы русского языка без пробелов или цифры);"
                +"\nСТАТИСТИКА_ТОВАРОВ - команда получения информации о товарах во всех магазинах;"
                +"\nВЫХОД - команда для завершения работы программы\n");
    }

}
