package providers;

import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;

public class GoogleMapsGeoCodingProvider implements  GeoCodingProvider{

    private final String GOOGLE_BASE_URL = "https://google-maps-geocoding.p.rapidapi.com/geocode";
    private final String HEADER_NAME = "x-rapidapi-host";
    private final String HEADER_VALUE = "google-maps-geocoding.p.rapidapi.com";
    private final String KEY_HEADER = "x-rapidapi-key";
    private final String KEY_VALUE = "Insert your API key";
    private final OkHttpClient client;

    public GoogleMapsGeoCodingProvider() {
         client = new OkHttpClient();
    }


    @Override
    public JSONObject geocodeJSON(@NonNull String location) throws IOException {

        String encodedAddress = URLEncoder.encode(location, "UTF-8");

        Request request = new Request.Builder()
                .url(GOOGLE_BASE_URL+"/json?language=en&address=" + encodedAddress)
                .get()
                .addHeader(HEADER_NAME, HEADER_VALUE)
                .addHeader(KEY_HEADER, KEY_VALUE)
                .build();
        ResponseBody responseBody = client.newCall(request).execute().body();

        JSONObject jsonObject = new JSONObject(responseBody.string());


        return jsonObject;
    }
}
