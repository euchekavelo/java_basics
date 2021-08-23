import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUtils {

    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        Path whereToGet = Paths.get(sourceDirectory);
        Path whereToInsert = Paths.get(destinationDirectory);
        try {
            Files.walk(whereToGet)
                    .forEach(p-> copyContent(p, whereToInsert.resolve(whereToGet.relativize(p))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void copyContent(Path sourcesDirectoryPaths, Path destinationDirectoryPaths) {
        try {
            Files.copy(sourcesDirectoryPaths, destinationDirectoryPaths, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
