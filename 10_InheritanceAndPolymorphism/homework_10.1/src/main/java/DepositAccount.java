import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends BankAccount {

    private LocalDate lastIncome;

    public void put(double amountToPut)
    {
        if (amountToPut > 0.0)
        {
            amount += amountToPut;
            lastIncome = LocalDate.now();
        }
        else
            System.out.println("Операция пополнения невозможна. Пополняемая сумма должна быть больше 0.");
    }

    public boolean take(double amountToTake)
    {
        LocalDate currentDate = LocalDate.now();
        if (amountToTake <= amount && amountToTake > 0.0 && lastIncome.until(currentDate, ChronoUnit.MONTHS) >= 1)
        {
            amount -= amountToTake;
            return true;
        }
        else
        {
            System.out.println("Операция списания невозможна. Сумма списания меньше 0 или превышает остаток на счете, " +
                    "либо прошло менее месяца с момента последнего пополнения счета.");
            return false;
        }
    }

}
