package ru.skillbox;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Elevator elevator = new Elevator(-3, 26);
        while(true) {
            System.out.print("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            System.out.print("Введите общий вес: ");
            double currentWeight = new Scanner(System.in).nextDouble();
            elevator.move(floor, currentWeight);
        }
    }
}
