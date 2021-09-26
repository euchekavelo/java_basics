import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        //Пусть в банке хранится 3 аккаунта.
        Bank bank = new Bank();
        bank.setAccounts(getGeneratedAccountMap(3));
        System.out.println("Общий баланс в банке до начала транзакций: " + bank.getSumAllAccounts());

        //В качестве примера воспроизведем ситуацию перевода "туда-обратно" между двумя определенными счетами в 1000 потоках.
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> {
                long amountTransfer = (long) (Math.random() * 100000);
                System.out.println("Сумма перевода: " + amountTransfer);

                try {
                    System.out.println("Балансы на обоих счетах до транзакции:");
                    System.out.println(bank.getBalance(Integer.toString(1))
                                        + " : " + bank.getBalance(Integer.toString(2)));

                    bank.transfer(Integer.toString(1), Integer.toString(2), amountTransfer);
                    bank.transfer(Integer.toString(2), Integer.toString(1), amountTransfer);

                    System.out.println("Балансы на обоих счетах после попытки транзакции:");
                    System.out.println(bank.getBalance(Integer.toString(1))
                                        + " : " + bank.getBalance(Integer.toString(2)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Общий баланс в банке: " + bank.getSumAllAccounts());
            });
            thread.start();
        }
    }

    /**
     * Метод служит для генерации тестовых данных (карты аккаунтов), которые будут задействованы в работе программы.
     *
     * @param countAccounts - количество аккаунтов в банке.
     * @return - заполненная карта аккаунтов.
     */
    private static Map<String, Account> getGeneratedAccountMap(int countAccounts){
        Map<String, Account> accountMap = new HashMap<>();
        for (int i = 0; i < countAccounts; i++){
            long randomValueMoney = (long) (Math.random() * 100000 + 20000);
            Account account = new Account();
            account.setMoney(randomValueMoney);
            account.setAccNumber(Integer.toString(i));

            accountMap.put(Integer.toString(i), account);
        }

        return accountMap;
    }
}
