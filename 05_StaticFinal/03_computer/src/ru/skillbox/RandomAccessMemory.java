package ru.skillbox;

public class RandomAccessMemory {

    private final TypeRandomAccessMemory typeRandomAccessMemory; //Тип оперативной памяти
    private final int volume; //Объем
    private final double weight; //Вес

    public RandomAccessMemory(TypeRandomAccessMemory typeRandomAccessMemory, int volume, double weight)
    {
        this.typeRandomAccessMemory = typeRandomAccessMemory;
        this.volume = volume;
        this.weight = weight;
    }

    public TypeRandomAccessMemory getTypeRandomAccessMemory() {
        return typeRandomAccessMemory;
    }

    public int getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }

}
