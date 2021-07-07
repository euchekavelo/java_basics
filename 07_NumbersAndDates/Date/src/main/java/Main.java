import javax.swing.text.DateFormatter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue

        LocalDate birthday = LocalDate.of(year, month, day); //Дата рождения
        LocalDate today = LocalDate.now(); //Текущая дата

        if (birthday.compareTo(today) > 0)
            return "";
        else
        {
            int currentAge = 0; //Начальное значение текущего возраста
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); //Зададим формат для вывода даты
            DayOfWeek dayOfWeek = birthday.getDayOfWeek(); //Получим день недели первого дня рождения (пример. "FRIDAY").
            String shortDayOfWeek = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH); //Преобразуем полученный день недели в краткий формат "Fri"

            //Сформируем первую запись в требуемом формате вывода
            String outputLine = currentAge + " - " + formatter.format(birthday) + " - " + shortDayOfWeek + System.lineSeparator();
            birthday = birthday.plusYears(1); //Прибавим год

            while (today.isAfter(birthday) || birthday.compareTo(today) == 0)
            {
                dayOfWeek = birthday.getDayOfWeek();
                shortDayOfWeek = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
                outputLine = outputLine + ++currentAge + " - " + formatter.format(birthday) + " - " + shortDayOfWeek + System.lineSeparator();
                birthday = birthday.plusYears(1);
            }
            return outputLine;
        }
    }
}
