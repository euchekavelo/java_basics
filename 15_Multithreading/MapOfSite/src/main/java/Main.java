import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final String URL = "https://skillbox.ru/";
    private static final int COUNT_DEFAULT_SLASH = URL.length() - URL.replace("/", "").length();;

    public static void main(String[] args) {

        GettingLinks gettingLinks = new GettingLinks(URL);

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(gettingLinks);
        gettingLinks.getSortedSetLinks().stream()
                .map(Main::getStringWithTabs)
                .forEach(FileWrite::writeFile);

        System.out.println("Запись файла завершена.");
    }

    private static String getStringWithTabs(String line) {
        int countSlash = line.length() - line.replace("/", "").length();
        if (countSlash <= COUNT_DEFAULT_SLASH)
            return "".concat(line);

        return "\t".repeat(Math.max(0, countSlash - COUNT_DEFAULT_SLASH)).concat(line);
    }

}
