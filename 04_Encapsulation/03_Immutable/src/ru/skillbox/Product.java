package ru.skillbox;

public class Product {

    private final String name;
    private int price;
    private final long barCode;

    public Product(String name, long barCode)
    {
        this.name = name;
        this.barCode = barCode;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public long getBarCode()
    {
        return barCode;
    }
}
