package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        //Создадим объект
        Dimensions dimensions = new Dimensions(100.0, 100.0, 100.0);
        CargoDetails cargoDetails = new CargoDetails(dimensions, 200.0 , "г. Москва",
                                                    false, "B42138523", true);

        //Создадим копию объекта №1 (с измененными габаритами)
        Dimensions otherDimensions = new Dimensions(120.0, 110.0, 115.0);
        CargoDetails firstCopy = cargoDetails.setDimensions(otherDimensions);

        //Создадим копию объекта №2 (с измененным адресом доставки)
        CargoDetails secondCopy = cargoDetails.setDeliveryAddress("г. Владивосток");

        //Создадим копию объекта №3 (с измененной массой груза)
        CargoDetails thirdCopy = cargoDetails.setWeight(1000.0);

        System.out.println("Информация о грузе\n" + cargoDetails);
        System.out.println();
        System.out.println("Информация о копии груза №1 (изменены габариты)\n" + firstCopy);
        System.out.println();
        System.out.println("Информация о копии груза №2 (с измененным адресом доставки)\n" + secondCopy);
        System.out.println();
        System.out.println("Информация о копии груза №3 (с измененной массой груза)\n" + thirdCopy);
    }
}
