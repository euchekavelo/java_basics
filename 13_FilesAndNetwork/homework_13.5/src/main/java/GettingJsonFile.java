import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GettingJsonFile {

    private Document document = null;
    private static final String FILE_PATH = "metro.json";

    public GettingJsonFile(String url){
        try {
            document = Jsoup.connect(url).maxBodySize(0).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> getLinesMetroFromDocument(){
        Map<String, String> lines = new HashMap<>();
        Elements elements = document.getElementsByClass("js-metro-line");
        elements.forEach(element -> {
                                        String number = element.attr("data-line");
                                        String nameLine = element.text();

                                        lines.put(number, nameLine);
                                    });

        return lines;
    }

    private Map<String, List<String>> getStationsMetroFromDocument(){
        Map<String, List<String>> stations = new HashMap<>();
        Elements elements = document.getElementsByClass("js-metro-stations t-metrostation-list-table");
        for (Element element : elements){
            List<String> nameStations = new ArrayList<>();
            String numberLine = element.attr("data-line");
            Elements stationsList = element.getElementsByClass("name");
            for (Element station : stationsList)
                nameStations.add(station.text());

            stations.put(numberLine, nameStations);
        }

        return stations;
    }

    public void createJsonFile(){
        Map<String, List<String>> stations = new HashMap<>(getStationsMetroFromDocument());
        Map<String, String> lines = new HashMap<>(getLinesMetroFromDocument());

        JSONArray jsonArrayLines = new JSONArray();
        for (Map.Entry<String, String> entry: lines.entrySet()){
            JSONObject jsonObjectStation = new JSONObject();
            jsonObjectStation.put("number", entry.getKey());
            jsonObjectStation.put("name", entry.getValue());

            jsonArrayLines.add(jsonObjectStation);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stations", stations);
        jsonObject.put("lines", jsonArrayLines);

        try (FileWriter fileJson = new FileWriter(FILE_PATH, false)) {
            fileJson.write(jsonObject.toJSONString());
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Файл JSON успешно сформирован.");
    }

    public void GetTheNumberOfStationsOnEachLine (){
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(getJsonFile());
            JSONArray lines = (JSONArray) jsonObject.get("lines");
            JSONObject stations = (JSONObject) jsonObject.get("stations");

            lines.forEach(line -> {
                JSONObject jsonLine = (JSONObject) line;
                String numberLine = (String) jsonLine.get("number");
                String nameLine = (String) jsonLine.get("name");
                JSONArray stationsArray = (JSONArray) stations.get(numberLine);
                int countStationsOnLine = stationsArray.size();

                System.out.println("Количество станций, расположенных на линии \"" + nameLine
                        + "\" под номером " + numberLine + ", равно " + countStationsOnLine + " шт.");
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getJsonFile() throws IOException {
        StringBuilder builder = new StringBuilder();
        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
        lines.forEach(builder::append);

        return builder.toString();
    }

}
