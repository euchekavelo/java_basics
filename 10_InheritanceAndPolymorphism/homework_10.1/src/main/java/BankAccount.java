public class BankAccount {

  protected double amount = 0.0;

  protected double getAmount()
  {
    return amount;
  }

  protected void put(double amountToPut)
  {
    if (amountToPut > 0.0)
    {
      amount += amountToPut;
    }
    else
        System.out.println("Операция пополнения невозможна. Пополняемая сумма должна быть больше 0.");
  }

  protected boolean take(double amountToTake)
  {
    if (amountToTake <= amount && amountToTake > 0.0)
    {
      amount -= amountToTake;
      return true;
    }
    else
    {
      System.out.println("Операция списания невозможна. Сумма списания меньше 0 или превышает остаток на счете.");
      return false;
    }
  }

  protected boolean send(BankAccount receiver, double amount)
  {
    boolean operationPossible = take(amount);
    if (operationPossible)
    {
      receiver.put(amount);
      System.out.println("Перевод средств успешно выполнен.");
      return true;
    }
    else
    {
      System.out.println("Перевод средств не удалось выполнить.");
      return false;
    }
  }

}
