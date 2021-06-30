package ru.skillbox;

public class Processor {

    private final double frequency; //Частота
    private final CountCores countCores; //Количество ядер
    private final String vendor; //Производитель
    private final double weight; //Вес

    public Processor(double frequency, CountCores countCores, String vendor, double weight)
    {
        this.frequency = frequency;
        this.countCores = countCores;
        this.vendor = vendor;
        this.weight = weight;
    }

    public double getFrequency() {
        return frequency;
    }

    public CountCores getCountCores() {
        return countCores;
    }

    public String getVendor() {
        return vendor;
    }

    public double getWeight() {
        return weight;
    }

}
