public abstract class CompanyMember implements Employee{

    private final int fixedPartSalary;

    public CompanyMember(int fixedPartSalary)
    {
        this.fixedPartSalary = fixedPartSalary;
    }

    public int getFixedPartSalary()
    {
        return fixedPartSalary;
    }
}
