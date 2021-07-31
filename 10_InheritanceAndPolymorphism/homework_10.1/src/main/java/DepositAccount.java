import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends BankAccount {

    private LocalDate lastIncome;

    protected void put(double amountToPut)
    {
        lastIncome = LocalDate.now();
        super.put(amountToPut);
    }

    protected boolean take(double amountToTake)
    {
        LocalDate currentDate = LocalDate.now();
        if (lastIncome.until(currentDate, ChronoUnit.MONTHS) >= 1)
        {
            return super.take(amountToTake);
        }
        else
        {
            System.out.println("Операция списания невозможна. Прошло менее месяца с момента последнего пополнения счета.");
            return false;
        }
    }

}
