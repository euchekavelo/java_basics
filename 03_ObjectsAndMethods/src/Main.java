public class Main {

    public static void main(String[] args) {

        //Задание №1
        System.out.println("Задание №1");
        Basket basket = new Basket();
        basket.add("Milk", 40, 2, 0.250);
        basket.add("Chocolate", 55, 0.05);
        basket.add("Package", 5, 15);
        basket.add("Little package", 2);
        basket.add("Ice cream", 360, 0.6);
        basket.print("Корзина");
        System.out.println("Общий вес корзины: " + basket.getTotalWeight() + " кг.\n");

        //Задание №2
        System.out.println("Задание №2");
        Arithmetic numbers = new Arithmetic(1, 6);
        System.out.println("Сумма двух чисел: " + numbers.getSumNumbers());
        System.out.println("Разность первого и второго числа: " + numbers.getDifferenceBetweenFirstSecondNumbers());
        System.out.println("Разность второго и первого числа: " + numbers.getDifferenceBetweenSecondFirstNumbers());
        System.out.println("Произведение двух чисел: " + numbers.getCompositionNumbers());
        System.out.println("Среднее значение двух чисел: " + numbers.getAverageValueNumbers());
        System.out.println("Максимальное значение из двух чисел: " + numbers.getMaxNumbers());
        System.out.println("Минимальное значение из двух чисел: " + numbers.getMinNumbers() + "\n");

        //Задание №3
        //Первая очередь для печати
        System.out.println("Задание №3");
        Printer printQueueFirst = new Printer();
        printQueueFirst.append("Необходимо помыть руки.", "Инструкция");
        printQueueFirst.append("Один, два, три", "Счет", 4);
        printQueueFirst.print();
        System.out.println("Общее количество страниц в очереди: " + printQueueFirst.getPagesCount());
        System.out.println("Общее количество документов в очереди: " + printQueueFirst.getDocumentsCount());

        //Вторая очередь для печати
        Printer printQueueSecond = new Printer();
        printQueueSecond.append("Несколько иначе себя вела погода.");
        printQueueSecond.append("Хорошая погода", "поэма Виктора");
        printQueueSecond.append("Первоначально необходимо выкрутить перемычку", "Инструкция лектчика", 2);
        printQueueSecond.print();
        System.out.println("Общее количество страниц в очереди: " + printQueueSecond.getPagesCount());
        System.out.println("Общее количество документов в очереди: " + printQueueSecond.getDocumentsCount());

        //Третья очередь для печати
        Printer printQueueThird = new Printer();
        printQueueThird.append("Человек в пустом поле");
        printQueueThird.print();
        System.out.println("Общее количество страниц в очереди: " + printQueueThird.getPagesCount());
        System.out.println("Общее количество документов в очереди: " + printQueueThird.getDocumentsCount() + "\n");

        //Вызываем статический метод класса "Printer" для печати информации в консоль об общем
        //количестве распечатанных документов и страниц за все время.
        System.out.println(Printer.getGlobalDocumentsCountAndGlobalPagesCount());
    }
}
