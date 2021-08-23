import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        long totalSize = 0;
        Path absolutePath = Paths.get(path);
        try {
            totalSize = Files.walk(absolutePath)
                             .map(Path::toFile)
                             .filter(File::isFile)
                             .mapToLong(File::length)
                             .sum();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return totalSize;
    }

}
