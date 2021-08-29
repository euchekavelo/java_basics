import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movements {

    private final List<String> lines = new ArrayList<>();
    private final Set<String> setLinesOrganizations = new HashSet<>();

    public Movements(String pathMovementsCsv) {
        try {
            List<String> initialList = Files.readAllLines(Paths.get(pathMovementsCsv));
            initialList.remove(0);
            for (String line : initialList){
                lines.add(getConvertedString(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getConvertedString(String line){
        String regex = "\"\\p{Digit}+,\\p{Digit}+\"";
        String newString = line;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            String newElement = line.substring(start, end);
            newString = newString.replace(newElement, newElement.replace(",", ".")
                                                                .replace("\"", ""));
        }

        return newString;
    }

    public double getExpenseSum() {
        double expenseSum = 0.0;
        for(String line : lines){
            String[] fragments = line.split(",");
            expenseSum += Double.parseDouble(fragments[fragments.length - 1]);
        }

        return expenseSum;
    }

    public double getIncomeSum() {
        double incomeSum = 0.0;
        for(String line : lines){
            String[] fragments = line.split(",");
            incomeSum += Double.parseDouble(fragments[fragments.length - 2]);
        }

        return incomeSum;
    }

    private List<String> getParseListOrganizations(){
        List<String> stringList = new ArrayList<>();
        String regex = "\\p{Digit}{2}\\.\\p{Digit}{2}.\\p{Digit}{2}.*";
        for(String line : lines){
            String[] fragments = line.split(",");
            String expenseAmount = fragments[fragments.length - 1];
            if (!expenseAmount.equals("0")) {
                String elementContent = fragments[fragments.length - 3];
                int indexFirstSlash = elementContent.indexOf("\\");
                if (indexFirstSlash != -1) {
                    String beforeTheFirstSlash = elementContent.substring(0, indexFirstSlash);
                    String element = elementContent.replace(beforeTheFirstSlash, "")
                                                    .replaceAll(regex, "")
                                                    .trim()
                                                    .replace("\\", "");

                    //Дополнительно добавляем полученный элемент в HashSet
                    addItemToSet(element);
                    stringList.add(element + "|" + expenseAmount);
                }
           }
        }

        return stringList;
    }

    private void addItemToSet(String element){
        setLinesOrganizations.add(element);
    }

    public String getAmountOfExpensesByOrganization(){
        String output = "";
        List<String> parseList = new ArrayList<>(getParseListOrganizations());
        for (String setLine : setLinesOrganizations){
            double sum = 0;
            for (String listLine : parseList) {
                String[] fragments = listLine.split("\\|");
                if (fragments[0].equals(setLine))
                        sum += Double.parseDouble(fragments[1]);
            }
            output = output.concat(setLine + "  " + sum + " руб.\n");
        }

        return output.trim();
    }
}
