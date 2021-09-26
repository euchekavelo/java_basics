import junit.framework.TestCase;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

public class BankTest extends TestCase {

    Bank bank = new Bank();
    private Map<String, Account> accounts = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        Account account1 = new Account();
        account1.setMoney(250000);
        account1.setAccNumber(Integer.toString(0));
        accounts.put(Integer.toString(0), account1);

        Account account2 = new Account();
        account2.setMoney(350000);
        account2.setAccNumber(Integer.toString(1));
        accounts.put(Integer.toString(1), account2);

        Account account3 = new Account();
        account3.setMoney(350000);
        account3.setAccNumber(Integer.toString(2));
        accounts.put(Integer.toString(2), account3);

        Account account4 = new Account();
        account4.setMoney(450000);
        account4.setAccNumber(Integer.toString(3));
        accounts.put(Integer.toString(3), account4);

        bank.setAccounts(accounts);
    }

    public void testIsFraud() {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    bank.transfer(Integer.toString(0), Integer.toString(1), 50001);
                    bank.transfer(Integer.toString(1), Integer.toString(0), 50001);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        boolean actualFrom = accounts.get(Integer.toString(0)).isBlocked();
        boolean actualTo = accounts.get(Integer.toString(1)).isBlocked();

        assertTrue(actualFrom);
        assertTrue(actualTo);
    }

    public void testTransfer() {
        for (int i = 0; i < 10; i++){
            Thread thread = new Thread(() -> {
                try {
                    bank.transfer(Integer.toString(0), Integer.toString(1), 1000);
                    bank.transfer(Integer.toString(1), Integer.toString(0), 2000);
                    bank.transfer(Integer.toString(1), Integer.toString(3), 1000);
                    bank.transfer(Integer.toString(2), Integer.toString(1), 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long actualBalance1 = bank.getBalance(Integer.toString(0));
        long expectedBalance1 = 260000;
        assertEquals(expectedBalance1, actualBalance1);

        long actualBalance2 = bank.getBalance(Integer.toString(1));
        long expectedBalance2 = 340000;
        assertEquals(expectedBalance2, actualBalance2);

        long actualBalance3 = bank.getBalance(Integer.toString(2));
        long expectedBalance3 = 340000;
        assertEquals(expectedBalance3, actualBalance3);

        long actualBalance4 = bank.getBalance(Integer.toString(3));
        long expectedBalance4 = 460000;
        assertEquals(expectedBalance4, actualBalance4);
    }

    public void testGetBalance() {
        long actualBalance1 = bank.getBalance(Integer.toString(0));
        long executeBalance1 = 250000;

        long actualBalance2 = bank.getBalance(Integer.toString(1));
        long executeBalance2 = 350000;

        long actualBalance3 = bank.getBalance(Integer.toString(2));
        long executeBalance3 = 350000;

        long actualBalance4 = bank.getBalance(Integer.toString(3));
        long executeBalance4 = 450000;

        assertEquals(executeBalance1, actualBalance1);
        assertEquals(executeBalance2, actualBalance2);
        assertEquals(executeBalance3, actualBalance3);
        assertEquals(executeBalance4, actualBalance4);
    }

    public void testGetSumAllAccounts() {
        long actualTotalAmountInTheBank = bank.getSumAllAccounts();
        long expectedTotalAmount = 1400000;

        assertEquals(expectedTotalAmount, actualTotalAmountInTheBank);
    }

    public void testTransferBlock(){
        Account account = accounts.get("0");
        account.block();
        Thread thread = new Thread(() -> {
            try {
                bank.transfer(Integer.toString(0), Integer.toString(1), 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        long actualBalance = bank.getBalance(Integer.toString(0));
        long expectedBalance = 250000;

        assertEquals(expectedBalance, actualBalance);
    }
}