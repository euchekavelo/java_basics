public class CardAccount extends BankAccount {

    public boolean take(double amountToTake)
    {
        if (amountToTake * 1.01 <= amount && amountToTake > 0.0)
        {
            amount -= amountToTake * 1.01;
            return true;
        }
        else
        {
            System.out.println("Операция списания невозможна. " +
                    "Сумма списания, с учетом комиссии, меньше 0 либо превышает остаток на счете.");
            return false;
        }
    }

}
