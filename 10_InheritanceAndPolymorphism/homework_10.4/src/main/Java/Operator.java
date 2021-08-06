public class Operator extends CompanyMember {

    public Operator(int fixedPartSalary)
    {
        super(fixedPartSalary);
    }

    @Override
    public int getMonthSalary()
    {
        return getFixedPartSalary();
    }

}
