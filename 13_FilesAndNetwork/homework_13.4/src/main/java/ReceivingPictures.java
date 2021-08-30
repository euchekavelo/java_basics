import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;

public class ReceivingPictures {

    private Document document = null;

    public ReceivingPictures(String url){
        try {
            document = Jsoup.connect(url).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getImagesFromTheSite() {
        Elements elements = document.select("img");
        String pathParentDirectory = "images/";
        for (Element element : elements){
            String absLink = element.attr("abs:src");
            String pathNewFile = pathParentDirectory.concat(absLink.substring(absLink.lastIndexOf("/") + 1));
            File file = new File(pathNewFile);
            try (InputStream source = new URL(absLink).openStream()) {
                Files.copy(source, Paths.get(pathNewFile), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Сохранение изображений со страницы сайта завершено.");
    }
}
