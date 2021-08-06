public class TopManager extends CompanyMember {

    private static final double PREMIUM_MULTIPLIER = 1.5;
    private static final int EXPECTED_INCOME_COMPANY = 10000000;
    private final Company company;

    public TopManager(int fixedPartSalary, Company company)
    {
        super(fixedPartSalary);
        this.company = company;
    }

    @Override
    public int getMonthSalary()
    {
        int salary = getFixedPartSalary();
        if (company.getIncome() > EXPECTED_INCOME_COMPANY)
            salary = (int) (salary + salary * PREMIUM_MULTIPLIER);
        return salary;
    }

}
