import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees()
    {
        return new ArrayList<>(employees);
    }

    public void hire(Employee employee)
    {
        employees.add(employee);
        System.out.println("Сотрудник успешно принят в компанию.");
    }

    public void hireAll(List<Employee> employees)
    {
        this.employees.addAll(employees);
        System.out.println("Сотрудники в количестве: " + employees.size() + " чел. были успешно приняты в компанию.");
    }

    public void fire(Employee employee)
    {
        String outLine = employees.remove(employee) ? "Сотрудник был уволен." : "Сотрудник не может быть уволен, " +
                "т.к. не числится в компании.";
        System.out.println(outLine);
    }

    public int getIncome()
    {
        int income = 0;
        for (Employee employee : employees)
        {
            if (employee instanceof Manager)
                income = income + ((Manager) employee).getSales();
        }

        return income;
    }

    public List<Employee> getTopSalaryStaff(int count)
    {
        if (count > 0 && count <= employees.size())
        {
            Collections.sort(employees);
            Collections.reverse(employees);
            return employees.subList(0, count);
        }
        else
        {
            System.out.println("Некорректно указано запрашиваемое количество сотрудников. Возвращен пустой список.");
            return new ArrayList<>();
        }
    }

    public List<Employee> getLowestSalaryStaff(int count)
    {
        if (count > 0 && count <= employees.size())
        {
            Collections.sort(employees);
            return employees.subList(0, count);
        }
        else
        {
            System.out.println("Некорректно указано запрашиваемое количество сотрудников. Возвращен пустой список.");
            return new ArrayList<>();
        }
    }

}
