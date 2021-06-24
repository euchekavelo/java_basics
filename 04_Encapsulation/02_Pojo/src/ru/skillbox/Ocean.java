package ru.skillbox;

public class Ocean {

    //Площадь
    private int area; //Единицы измерения "км. кв."
    //Наименование океана
    private String nameOcean;
    //Наибольшая глубина
    private int greatestDepth; //Единицы измерения "м."
    //Средняя глубина
    private int averageDepth; //Единицы измерения "м."

    public Ocean(String nameOcean)
    {
        this.nameOcean = nameOcean;
    }

    public int getGreatestDepth()
    {
        return greatestDepth;
    }

    public int getAverageDepth()
    {
        return averageDepth;
    }

    public int getArea()
    {
        return area;
    }

    public String getNameOcean()
    {
        return nameOcean;
    }

    public void setGreatestDepth(int greatestDepth)
    {
        this.greatestDepth = greatestDepth;
    }

    public void setAverageDepth(int averageDepth)
    {
        this.averageDepth = averageDepth;
    }

    public void setArea(int area)
    {
        this.area = area;
    }

    public void setNameOcean(String nameOcean)
    {
        this.nameOcean = nameOcean;
    }
}
