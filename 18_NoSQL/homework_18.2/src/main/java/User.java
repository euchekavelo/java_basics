import java.util.Calendar;

public class User {

    static private int id = 1;
    private final double timeRegistration;
    private String userName;

    //Сгенерируем имя пользователя и время регистрации в конструкторе класса при объявлении экземпляра.
    public User() {
        userName = "Пользователь " + id;
        timeRegistration = generateRegistrationTime();
        id++;
    }

    private double generateRegistrationTime(){
        return (double) Calendar.getInstance().getTimeInMillis();
    }

    public String getUserName(){
        return userName;
    }

    public double getTimeRegistration(){
        return timeRegistration;
    }

}
