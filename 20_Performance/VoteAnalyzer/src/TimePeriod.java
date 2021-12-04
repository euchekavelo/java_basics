import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimePeriod implements Comparable<TimePeriod> {

    private static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("yyyy.MM.dd");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd HH:mm");
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm");
    private long from;
    private long to;

    /**
     * Time period within one day
     *
     * @param from
     * @param to
     */
    public TimePeriod(long from, long to) {
        this.from = from;
        this.to = to;
        if (!DAY_FORMAT.format(new Date(from)).equals(DAY_FORMAT.format(new Date(to)))) {
            throw new IllegalArgumentException("Dates 'from' and 'to' must be within ONE day!");
        }
    }

    public void appendTime(long visitTime) {
        if (!DAY_FORMAT.format(new Date(from))
            .equals(DAY_FORMAT.format(new Date(visitTime)))) {
            throw new IllegalArgumentException(
                "Visit time must be within the same day as the current TimePeriod!");
        }
        if (visitTime < from) {
            from = visitTime;
        }
        if (visitTime > to) {
            to = visitTime;
        }
    }

    public String toString() {
        return DATE_FORMAT.format(from) + "-" + TIME_FORMAT.format(to);
    }

    @Override
    public int compareTo(TimePeriod period) {
        Date current = new Date();
        Date compared = new Date();
        try {
            current = DAY_FORMAT.parse(DAY_FORMAT.format(new Date(from)));
            compared = DAY_FORMAT.parse(DAY_FORMAT.format(new Date(period.from)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return current.compareTo(compared);
    }
}
