public class LegalPerson extends Client {

    public void take(double amountToTake)
    {
        double amountWithCommission = amountToTake * 1.01;
        super.take(amountWithCommission);
    }

    @Override
    public void getInformation()
    {
        System.out.println("Счет \"LegalPerson\"." +
                "\nУсловия пополнения: без комиссии." +
                "\nУсловия снятия: комиссия 1% от суммы." +
                "\nТекущий баланс на счете: " + super.getAmount() + " рублей.");
    }

}
