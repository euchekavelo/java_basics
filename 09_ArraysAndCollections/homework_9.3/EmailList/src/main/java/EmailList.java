import java.util.*;

public class EmailList {

    private final static String REGEX_EMAIL = "\\p{Alpha}\\p{Alnum}*@\\p{Alpha}+\\.(\\p{Alpha}){2,}";
    private final Set<String> emailList = new TreeSet<>();

    public void add(String email) {
        if (email.matches(REGEX_EMAIL))
        {
            emailList.add(email.toLowerCase());
        }
        else
            System.out.println(Main.WRONG_EMAIL_ANSWER);
    }

    public List<String> getSortedEmails() {
        return new ArrayList<>(emailList);
    }

    public void printList()
    {
        String outLine = "";
        for (String line : emailList)
            outLine = outLine.concat(line + System.lineSeparator());

        System.out.println(outLine.trim());
    }
}
