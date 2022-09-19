package providers;


import lombok.NonNull;
import org.json.JSONObject;

import java.io.IOException;


/*
This is an interface for a Gecoding Provider. This can be implemented by specific geocoding providers like Google Maps or Position Stack
 */
public interface GeoCodingProvider {

    public JSONObject geocodeJSON(@NonNull String location) throws IOException;

}
