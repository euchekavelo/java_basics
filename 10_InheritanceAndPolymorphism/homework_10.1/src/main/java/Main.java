public class Main {

    public static void main(String[] args)
    {
        BankAccount bankAccount = new BankAccount();
        bankAccount.put(1000);

        CardAccount cardAccount = new CardAccount();
        cardAccount.put(1000);

        DepositAccount depositAccount = new DepositAccount();

        //Проверка выполнения переводов средств между счетами.
        bankAccount.send(cardAccount, 100.0);
        System.out.println("Текущий баланс на основном bankAccount счете: " + bankAccount.getAmount()
        + "\nТекущий баланс на cardAccount счете: " + cardAccount.getAmount());

        cardAccount.send(depositAccount, 100.0);
        System.out.println("Текущий баланс на cardAccount счете: " + cardAccount.getAmount()
                + "\nТекущий баланс на depositAccount счете: " + depositAccount.getAmount());

        //Попробуем теперь выполнить перевод средств со счета depositAccount после недавнего на него зачисления переводом.
        depositAccount.send(bankAccount, 50.0);
        System.out.println("Текущий баланс на depositAccount счете: " + depositAccount.getAmount()
                + "\nТекущий баланс на основном bankAccount счете: " + bankAccount.getAmount());

    }

}
