import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int COUNT_OPERATOR = 180;
    private static final int COUNT_MANAGER = 80;
    private static final int COUNT_TOP_MANAGER = 10;

    public static void main(String[] args)
    {
        Company company = new Company();

        //Добавляем сотрудников в компанию.
        for (int i = 0; i < COUNT_OPERATOR; i ++)
        {
            Operator operator = new Operator(30000);
            company.hire(operator);
        }

        List<Employee> listEmployees = new ArrayList();
        for (int i = 0; i < COUNT_MANAGER; i++)
        {
            Manager manager = new Manager(40000);
            listEmployees.add(manager);
        }
        for (int i = 0; i < COUNT_TOP_MANAGER; i++)
        {
            TopManager topManager = new TopManager(100000, company);
            listEmployees.add(topManager);
        }
        company.hireAll(listEmployees);
        System.out.println("---------------------------------------");

        //Печатаем списки некоторых зарплат.
        PrintingSomeSalaries(company);

        //Увольняем 50% сотрудников.
        System.out.println("Текущее количество сотрудников компании до увольнения: " + company.getEmployees().size() + " чел.");
        List<Employee> employees = company.getEmployees();
        for (int i = 0; i < employees.size() / 2; i++)
        {
            company.fire(employees.get(i));
        }
        System.out.println("Текущее количество сотрудников компании: " + company.getEmployees().size() + " чел.");
        System.out.println("---------------------------------------");

        //Печатаем списки некоторых зарплат.
        PrintingSomeSalaries(company);
    }

    private static void PrintingSomeSalaries(Company company)
    {
        //Печатаем 15 самых высоких зарплат в компании.
        System.out.println("Печать самых высоких зарплат в компании:");
        for (Employee employee : company.getTopSalaryStaff(15))
        {
            System.out.println(employee.getMonthSalary());
        }
        System.out.println("---------------------------------------");

        //Печатаем 30 самых низких зарплат в компании.
        System.out.println("Печать самых низких зарплат в компании:");
        for (Employee employee : company.getLowestSalaryStaff(30))
        {
            System.out.println(employee.getMonthSalary());
        }
        System.out.println("---------------------------------------");
    }

}
