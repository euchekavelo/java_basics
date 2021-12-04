import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Loader {

    private static final String FILE_NAME = "res/data-18M.xml";

    public static void main(String[] args) throws Exception {

        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(new File(FILE_NAME), handler);
        handler.printDuplicatedVoters();

        long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - before;
        System.out.println(after);
    }
}