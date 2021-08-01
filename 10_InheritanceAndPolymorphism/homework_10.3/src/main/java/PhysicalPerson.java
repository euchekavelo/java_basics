public class PhysicalPerson extends Client {

    @Override
    public void getInformation()
    {
        System.out.println("Счет \"PhysicalPerson\"." +
                "\nУсловия пополнения: без комиссии." +
                "\nУсловия снятия: без комиссии." +
                "\nТекущий баланс на счете: " + super.getAmount() + " рублей.");
    }

}
