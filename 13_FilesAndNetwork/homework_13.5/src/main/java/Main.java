public class Main {

    private static final String URL = "https://www.moscowmap.ru/metro.html#lines";

    public static void main(String[] args) {
        GettingJsonFile gettingJsonFile = new GettingJsonFile(URL);
        gettingJsonFile.createJsonFile();
        gettingJsonFile.GetTheNumberOfStationsOnEachLine();
    }

}
