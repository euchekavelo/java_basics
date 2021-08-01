public class IndividualBusinessman extends Client {

    public void put(double amountToPut)
    {
        double amountWithCommission;
        if (amountToPut < 1000.0)
            amountWithCommission = amountToPut * 0.99;
        else
            amountWithCommission = amountToPut * 0.995;

        super.put(amountWithCommission);
    }

    @Override
    public void getInformation()
    {
        System.out.println("Счет \"IndividualBusinessman\"." +
                "\nУсловия пополнения: банковская комиссия 1% при пополнении на сумму менее 1000 рублей, " +
                "при пополнении на сумму от 1000 рублей (включительно) и более - 0.5%." +
                "\nУсловия снятия: без комиссии." +
                "\nТекущий баланс на счете: " + super.getAmount() + " рублей.");
    }

}
