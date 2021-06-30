package ru.skillbox;

public class HardDisk {

    private final TypeHardDisk typeHardDisk; //Тип жесткого диска
    private final int memorySize; //Объем/размер памяти
    private final double weight; //Вес

    public HardDisk(TypeHardDisk typeHardDisk, int memorySize, double weight) {
        this.typeHardDisk = typeHardDisk;
        this.memorySize = memorySize;
        this.weight = weight;
    }

    public TypeHardDisk getTypeHardDisk() {
        return typeHardDisk;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public double getWeight() {
        return weight;
    }

}
