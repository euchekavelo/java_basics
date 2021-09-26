public class Account implements Comparable<Account>{

    private long money;
    private String accNumber;
    private boolean blocked = false;

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public void block(){
        blocked = true;
    }

    public boolean isBlocked(){
        return blocked;
    }

    @Override
    public int compareTo(Account o) {
        return this.getAccNumber().compareTo(o.accNumber);
    }
}
