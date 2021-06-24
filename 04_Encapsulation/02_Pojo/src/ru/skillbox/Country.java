package ru.skillbox;

public class Country {

    private String nameCountry;
    private int populationSize;
    private int area;
    private String capitalName;
    private boolean accessSea;

    public Country(String nameCountry)
    {
        this.nameCountry = nameCountry;
    }

    public void setNameCountry(String nameCountry)
    {
        this.nameCountry = nameCountry;
    }

    public void setPopulationSize(int populationSize)
    {
        this.populationSize = populationSize;
    }

    public void setArea(int area)
    {
        this.area = area;
    }

    public void setCapitalName(String capitalName)
    {
        this.capitalName = capitalName;
    }

    public void setAccessSea(boolean accessSea)
    {
        this.accessSea = accessSea;
    }

    public String getNameCountry()
    {
        return nameCountry;
    }

    public int getPopulationSize()
    {
        return populationSize;
    }

    public int getArea()
    {
        return area;
    }

    public String getCapitalName()
    {
        return capitalName;
    }

    public boolean getAccessSea()
    {
        return accessSea;
    }
}
