public class CardAccount extends BankAccount {

    protected boolean take(double amountToTake)
    {
        double amountWithCommission = amountToTake * 1.01;
        return super.take(amountWithCommission);
    }

}
