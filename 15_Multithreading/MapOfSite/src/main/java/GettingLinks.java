import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.RecursiveAction;

public class GettingLinks extends RecursiveAction {

    private static final Logger LOGGER  = LogManager.getLogger(GettingLinks.class);
    private static final Marker LINK_PARSING = MarkerManager.getMarker("LINK_PARSING");
    private final String url;
    private static Set<String> setLinks = new HashSet<>();

    public GettingLinks(String url){
        this.url = url;
        LOGGER.info(LINK_PARSING, "Парсится ссылка: {}", this.url);
    }

    public Set<String> getSortedSetLinks() {
        return new TreeSet<>(setLinks);
    }

    @Override
    protected void compute() {
        Set<GettingLinks> setChildLinks = new HashSet<>();
        try {
            Thread.sleep(150);
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("a");
            for (Element element : elements) {
                String link = element.absUrl("href");
                if (!link.isEmpty() && link.startsWith(url) && !setLinks.contains(link) && !link.contains("#")) {
                    setLinks.add(link);
                    GettingLinks gettingLinks = new GettingLinks(link);
                    gettingLinks.fork();
                    setChildLinks.add(gettingLinks);
                }
            }
        } catch (Exception e) {
            LOGGER.error(e);
        }

        for (GettingLinks element : setChildLinks) {
            element.join();
        }
    }

}

