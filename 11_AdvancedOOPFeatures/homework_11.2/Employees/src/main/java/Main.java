import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year)
    {
        Stream<Employee> stream = staff.stream();
        Optional<Employee> optional = stream.filter(employee -> getLocalDateYear(employee.getWorkStart()) == year)
                                            .max(Comparator.comparing(Employee::getSalary));

        return optional.orElse(null);
    }

    //Метод для получения значения года из типа LocalDate.
    public static int getLocalDateYear(Date date)
    {
        LocalDate localDate = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDate.getYear();
    }
}