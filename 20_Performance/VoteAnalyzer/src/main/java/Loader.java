import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Loader {

    private static final String FILE_NAME = "res/data-1572M.xml";

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(new File(FILE_NAME), handler);

        System.out.println("Данные в базу данных загружены." +
                "\nДлительность загрузки составила: " + (System.currentTimeMillis() - start) + " ms.");
    }
}