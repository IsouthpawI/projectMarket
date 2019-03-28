package sk.itsovy.projectMarket.interfaces;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public interface Internet {

    String getRequest();
    {
        String rslt="";

        // Setting URL
        String url_str = "http://data.fixer.io/api/latest?access_key=4cf9ee2eceb1b4300feac36f86691dcb";
        try {

            URL url = new URL(url_str);

            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            rslt = jsonobj.get("success").getAsString();
            System.out.println(rslt);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rslt;
    }

}
