package ru.skillbox;

public class Monitor {

    private final double diagonal;
    private final TypeMonitor typeMonitor;
    private final double weight;

    public Monitor(double diagonal, TypeMonitor typeMonitor, double weight)
    {
        this.diagonal = diagonal;
        this.typeMonitor = typeMonitor;
        this.weight = weight;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public TypeMonitor getTypeMonitor() {
        return typeMonitor;
    }

    public double getWeight() {
        return weight;
    }

}
