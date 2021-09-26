import java.util.*;

public class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Account accountFrom = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);

        synchronized (accountFrom.compareTo(toAccount) > 0 ? toAccount : accountFrom) {
            synchronized (toAccount.compareTo(accountFrom) > 0 ? accountFrom : toAccount) {
                if (accountFrom.isBlocked() || toAccount.isBlocked()) {
                    System.out.println("На текущий момент переводы между заблокированным/заблокированными счетами запрещены."
                            + "\nДля возможности разрешения возникшей ситуации необходимо обратиться в подразделение банка.");
                    return;
                }

                if (amount <= 0) {
                    System.out.println("Указана некорректная сумма для перевода.");
                    return;
                }

                long currentBalanceAccountFrom = accountFrom.getMoney();

                if (currentBalanceAccountFrom >= amount) {
                    makeATransaction(accountFrom, toAccount, amount);
                    if (amount > 50000) {
                        if (isFraud(fromAccountNum, toAccountNum, amount)) {
                            makeATransaction(toAccount, accountFrom, amount);
                            accountFrom.block();
                            toAccount.block();
                            System.out.println("Оба счета (" + fromAccountNum + " и " + toAccountNum + ") были заблокированы.");
                        }
                    }
                } else
                    System.out.println("Сумма перевода превышает баланс счета отправителя. Перевод не выполнен.");
            }
        }
    }


    /**
     * Метод изменения балансов на двух счетах.
     *
     * @param accountFrom - Счет отправителя.
     * @param toAccount - Счета получателя.
     * @param amount - Сумма перевода.
     */
    private void makeATransaction(Account accountFrom, Account toAccount, long amount){
        long currentBalanceAccountFrom = accountFrom.getMoney();
        currentBalanceAccountFrom -= amount;
        accountFrom.setMoney(currentBalanceAccountFrom);

        long currentBalanceToAccount = toAccount.getMoney();
        currentBalanceToAccount += amount;
        toAccount.setMoney(currentBalanceToAccount);
    }

    public long getBalance(String accountNum) {

        return accounts.get(accountNum)
                        .getMoney();
    }

    public long getSumAllAccounts() {

        return accounts.values()
                        .stream()
                        .mapToLong(Account::getMoney)
                        .sum();
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }
}
