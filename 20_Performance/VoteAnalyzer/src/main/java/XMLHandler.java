import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;

public class XMLHandler extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("voter")){
            String birthDate = attributes.getValue("birthDay");
            DBConnection.countVoter(attributes.getValue("name"), birthDate);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        try {
            DBConnection.executeMultiInsert();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
