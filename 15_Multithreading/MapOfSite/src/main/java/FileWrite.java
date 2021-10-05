import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

    public static void writeFile(String line){
        try (FileWriter fileWriter = new FileWriter("mapOfSite.txt", true)){
            fileWriter.write(line.concat("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
