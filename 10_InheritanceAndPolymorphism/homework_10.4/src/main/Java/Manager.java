public class Manager extends CompanyMember {

    private static final double PREMIUM_MULTIPLIER = 0.05;
    private static final int MINIMUM_INCOME = 115000;
    private static final int MAXIMUM_INCOME = 140000;
    private final int sales;

    public Manager(int fixedPartSalary)
    {
        super(fixedPartSalary);
        this.sales = (int) (Math.random() * (MAXIMUM_INCOME - MINIMUM_INCOME) + MINIMUM_INCOME);
    }

    public int getSales()
    {
        return sales;
    }

    @Override
    public int getMonthSalary()
    {
        return (int) (getFixedPartSalary() + sales * PREMIUM_MULTIPLIER);
    }

}
