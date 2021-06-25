package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        //Объект класса "Book"
        Book book = new Book("Приключения Тома Сойера",
                "Марк Твен",
                421, 9780520235755L);

        System.out.println("Наименование книги: " + book.getName());
        System.out.println("Автор: " + book.getAuthor());
        System.out.println("Количество страниц: " + book.getAmountPages() + " стр.");
        System.out.println("Номер ISBN: " + book.getIsbnNumber());
        System.out.println();

        //Объекта класса "Product"
        Product product = new Product("Шоколад молочный \"Аленка\"", 4603955102162L);
        product.setPrice(99);
        System.out.println("Наименование продукта: " + product.getName());
        System.out.println("Цена: " + product.getPrice() + " руб.");
        System.out.println("Штрих-код: " + product.getBarCode());
    }
}
