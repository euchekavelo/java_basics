public abstract class Client {

    protected double amount = 0.0;

    public double getAmount()
    {
        return amount;
    }

    public void put(double amountToPut)
    {
        if (amountToPut > 0.0)
            amount += amountToPut;
        else
            System.out.println("Операция невозможна. Сумма пополнения должна быть больше 0.");
    }

    public void take(double amountToTake)
    {
        if (amountToTake <= amount && amountToTake > 0.0)
            amount -= amountToTake;
        else
            System.out.println("Операция невозможна. Сумма списания должна быть больше 0, " +
                    "а также не превышать остаток средств на счете.");
    }

    public abstract void getInformation();

}
