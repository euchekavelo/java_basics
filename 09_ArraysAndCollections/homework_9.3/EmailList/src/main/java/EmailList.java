import java.util.*;
import java.util.function.Consumer;

public class EmailList {

    private Set<String> emailList = new TreeSet<>();

    public void add(String email) {

        // TODO: валидный формат email добавляется
        String regex = "\\p{Alpha}\\p{Alnum}*@\\p{Alpha}+\\.(\\p{Alpha}){2,}";
        if (email.matches(regex))
        {
            emailList.add(email.toLowerCase());
        }
        else
            System.out.println(Main.WRONG_EMAIL_ANSWER);
    }

    public List<String> getSortedEmails() {

        // TODO: возвращается список электронных адресов в алфавитном порядке
        return new ArrayList<>(emailList);
    }

    public void list(List<String> arrayList)
    {
        arrayList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
