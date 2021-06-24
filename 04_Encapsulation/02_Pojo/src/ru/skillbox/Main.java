package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        //Объект класса "Country"
        Country country = new Country("Англия");
        country.setNameCountry("Россия");
        System.out.println("Наименование страны: " + country.getNameCountry());
        country.setPopulationSize(146171015);
        System.out.println("Численность населения: " + country.getPopulationSize() + " чел.");
        country.setArea(17125191);
        System.out.println("Площадь в квадратных километрах: " + country.getArea() + " км. кв.");
        country.setCapitalName("Москва");
        System.out.println("Название столицы: г. " + country.getCapitalName());
        country.setAccessSea(true);
        System.out.println("Наличие выхода к морю: " + country.getAccessSea());
        System.out.println();

        //Объект класса "Ocean"
        Ocean ocean = new Ocean("Индийский океан");
        ocean.setNameOcean("Тихий океан");
        System.out.println("Наименование океана: " + ocean.getNameOcean());
        ocean.setGreatestDepth(10994);
        System.out.println("Наибольшая глубина: " + ocean.getGreatestDepth() + " м.");
        ocean.setAverageDepth(3984);
        System.out.println("Средняя глубина: " + ocean.getAverageDepth() + " м.");
        ocean.setArea(178684000);
        System.out.println("Площадь: " + ocean.getArea() + " км. кв");

    }
}
