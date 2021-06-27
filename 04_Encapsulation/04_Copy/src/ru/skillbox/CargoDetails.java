package ru.skillbox;

public class CargoDetails {

    private final Dimensions dimensions; //Габариты
    private final double weight; //Масса
    private final String deliveryAddress; //Адрес доставки
    private final boolean abilityFlip; //Возможность переворачивать
    private final String registrationNumber; //Регистрационный номер
    private final boolean fragile; //свойство "Хрупкий"

    public CargoDetails(Dimensions dimensions, double weight, String deliveryAddress,
                        boolean abilityFlip, String registrationNumber, boolean fragile)
    {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.abilityFlip = abilityFlip;
        this.registrationNumber = registrationNumber;
        this.fragile = fragile;
    }

    public Dimensions getDimensions()
    {
        return dimensions;
    }

    public double getWeight()
    {
        return weight;
    }

    public String getDeliveryAddress()
    {
        return deliveryAddress;
    }

    public boolean isAbilityFlip()
    {
        return abilityFlip;
    }

    public String getRegistrationNumber()
    {
        return registrationNumber;
    }

    public boolean isFragile()
    {
        return fragile;
    }

    public CargoDetails setDeliveryAddress(String deliveryAddress)
    {
        return new CargoDetails(dimensions, weight, deliveryAddress, abilityFlip, registrationNumber, fragile);
    }

    public CargoDetails setDimensions (Dimensions dimensions)
    {
        return new CargoDetails(dimensions, weight, deliveryAddress, abilityFlip, registrationNumber, fragile);
    }

    public CargoDetails setWeight(double weight)
    {
        return new CargoDetails(dimensions, weight, deliveryAddress, abilityFlip, registrationNumber, fragile);
    }

    //Вывод информации
    public String toString()
    {
        return "Габариты и объем: " + dimensions + "\n"
                + "Масса: " + weight + " кг.\n"
                + "Адрес доставки: " + deliveryAddress + "\n"
                + "Можно переворачивать: " + abilityFlip + "\n"
                + "Регистрационный номер: " + registrationNumber + "\n"
                + "Является хрупким: " + fragile;
    }
}
