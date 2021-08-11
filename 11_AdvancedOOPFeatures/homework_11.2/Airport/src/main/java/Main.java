import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        findPlanesLeavingInTheNextTwoHours(airport).forEach(System.out::println);

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        //Получим текущее время.
        LocalDateTime currentLocalDateTime = LocalDateTime.now();

        //Переменная для хранения текущего времени, увеличенного на два часа.
        LocalDateTime currentTimeTwoHours = currentLocalDateTime.plusHours(2L);

        List<Flight> flights= new ArrayList<>();
        for (Terminal terminal : airport.getTerminals()) {
            terminal.getFlights().stream()
                    .filter(flight -> currentLocalDateTime.compareTo(getLocalDateTimeFromDate(flight.getDate())) <= 0
                            && currentTimeTwoHours.compareTo(getLocalDateTimeFromDate(flight.getDate())) >= 0
                            && flight.getType() == Flight.Type.DEPARTURE)
                    .forEach(flights::add);
        }

        return flights;
    }

    //Метод для преобразования даты в тип LocalDateTime.
    public static LocalDateTime getLocalDateTimeFromDate(Date date)
    {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

}