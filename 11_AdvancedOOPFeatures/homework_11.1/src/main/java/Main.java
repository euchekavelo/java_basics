import java.util.Collections;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);
        sortBySalaryAndAlphabet(staff);
        System.out.println(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        Collections.sort(staff, (o1, o2) -> {
            int resultComparison = o1.getSalary().compareTo(o2.getSalary());
            if (resultComparison == 0)
                resultComparison = o1.getName().compareTo(o2.getName());
            return resultComparison;
        });
    }
}