import java.time.LocalDate;
import java.time.Period;

public class Main {

  public static void main(String[] args)
  {

    int day = 21;
    int month = 1;
    int year = 1995;

    LocalDate birthday = LocalDate.of(year, month, day);
    System.out.println(getPeriodFromBirthday(birthday));

  }

  private static String getPeriodFromBirthday(LocalDate birthday)
  {

    LocalDate today = LocalDate.now(); //Получим текущую дату
    Period period = Period.between(birthday, today); //Получим число лет, месяцев и дней между двумя датами (разница)
    int years = period.getYears(); //Получим число лет
    int months = period.getMonths(); //Получим число месяцев
    int days = period.getDays(); //Получим число дней

    return years + " years, " + months + " months, " + days + " days ";

  }

}
