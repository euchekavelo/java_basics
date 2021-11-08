import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileParse {

    private static final String PATH_FILE = "src/main/resources/mongo.csv";
    private List<String> allLines = new ArrayList<>();
    private final List<String[]> listOfArraysOfStrings = new ArrayList<>();

    public FileParse(){
        try {
            allLines = Files.readAllLines(Paths.get(PATH_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> getListOfArraysOfStrings() {
        if (!allLines.isEmpty()){
            allLines.stream()
                    .map(line -> line.split(","))
                    .forEach(arrayLine -> {

                        //Почистим некоторые элементы каждого массива строк от символа двойных кавычек.
                        for (int i = 2; i < arrayLine.length; i++) {
                            String currentElement = arrayLine[i];
                            if (currentElement.contains("\""))
                                arrayLine[i] = currentElement.replaceAll("\"", "");
                        }

                        listOfArraysOfStrings.add(arrayLine);
                    });
        }

        return listOfArraysOfStrings;
    }

}
