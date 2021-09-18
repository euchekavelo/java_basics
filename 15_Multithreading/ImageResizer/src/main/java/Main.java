import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    //Получим количество логических ядер процессора, доступных JVM.
    private static final int COUNT_LOGICAL_CORES = Runtime.getRuntime().availableProcessors();

    private static final int NEW_WIDTH = 300;
    private static final String SRC_FOLDER = "src/src";
    private static final String DST_FOLDER = "src/dst";

    public static void main(String[] args) {
        Set<List<File>> setFiles = new HashSet<>();
        File srcDir = new File(SRC_FOLDER);

        File[] files = srcDir.listFiles();

        if (files != null) {
            int countFiles = files.length;
            if (countFiles == 0) {
                System.out.println("В директории источника нет файлов.");
                return;
            }
            else if (countFiles < COUNT_LOGICAL_CORES){
                for (File file : files) {
                    List<File> listFiles = new ArrayList<>();
                    listFiles.add(file);

                    setFiles.add(listFiles);
                }
            } else {
                for (int i = 0; i < COUNT_LOGICAL_CORES; i++) {
                    List<File> listFiles = new ArrayList<>();
                    int numberElement = i;
                    while (numberElement < files.length){
                        listFiles.add(files[numberElement]);
                        numberElement = numberElement + COUNT_LOGICAL_CORES;
                    }

                    setFiles.add(listFiles);
                }
            }
        } else {
            System.out.println("Указан неверный путь директории источника.");
            return;
        }

        long start = System.currentTimeMillis();
        setFiles.forEach(filesArray -> {
            int sizeArray = filesArray.size();
            File[] arrayFiles = filesArray.toArray(new File[sizeArray]);
            ImageResizer imageResizer = new ImageResizer(arrayFiles, NEW_WIDTH, DST_FOLDER, start);
            imageResizer.start();
        });
    }

}
