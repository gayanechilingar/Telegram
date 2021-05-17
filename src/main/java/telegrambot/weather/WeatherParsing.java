package telegrambot.weather;

//import static com.sun.org.glassfish.external.amx.AMXUtil.prop;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import telegrambot.ReadProperties;


import java.io.*;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Locale;

public class WeatherParsing {
//    ReadProperties prop = new ReadProperties();

    @SneakyThrows
    String getTemperature(String city) throws MalformedURLException, IOException {
        double current_temperature = 0;
        JSONObject json = new JSONObject(IOUtils.toString(new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city.toLowerCase(Locale.ROOT) + "&appid="), Charset.forName("UTF-8")));
        current_temperature = (Float.parseFloat(json.getJSONObject("main").get("temp").toString()));
        current_temperature = Math.round(current_temperature*100.0)/100.0;
        System.out.println(json);
        return current_temperature + "";
    }


    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
}
