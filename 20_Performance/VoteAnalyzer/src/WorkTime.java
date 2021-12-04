import java.util.TreeSet;

public class WorkTime {

    private TreeSet<TimePeriod> periods;

    /**
     * Set of TimePeriod objects
     */
    public WorkTime() {
        periods = new TreeSet<>();
    }

    public void addVisitTime(long visitTime) {
        TimePeriod newPeriod = new TimePeriod(visitTime, visitTime);
        for (TimePeriod period : periods) {
            if (period.compareTo(newPeriod) == 0) {
                period.appendTime(visitTime);
                return;
            }
        }
        periods.add(newPeriod);
    }

    public String toString() {
        StringBuilder line = new StringBuilder();
        for (TimePeriod period : periods) {
            if (line.length() > 0) {
                line.append(", ");
            }
            line.append(period);
        }
        return line.toString();
    }
}
