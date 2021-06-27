package ru.skillbox;

public class Dimensions {

    private final double length;
    private final double width;
    private final double height;

    public Dimensions(double length, double width, double height)
    {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength()
    {
        return length;
    }

    public double getWidth()
    {
        return width;
    }

    public double getHeight()
    {
        return height;
    }

    public double calculateVolumeCargo()
    {
        return length * width * height;
    }

    //Для вывод информации
    public String toString()
    {
        return length + " - длина (мм.), " + width + " - ширина (мм.), "
                + height + " высота (мм.), " + calculateVolumeCargo() + " - объем (мм. куб)";
    }
}
