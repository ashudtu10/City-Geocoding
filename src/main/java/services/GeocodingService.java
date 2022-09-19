package services;

import cache.Caching;
import cache.InMemoryCache;
import exceptions.BadRequestException;
import exceptions.LocationDoesNotExistsException;
import models.CoOrdinates;
import org.json.JSONObject;
import providers.GeoCodingProvider;
import providers.GoogleMapsGeoCodingProvider;

import java.io.IOException;

public class GeocodingService {

    private Caching inMemoryCache;
    private GeoCodingProvider geoCodingProvider;

    public GeocodingService() {
        inMemoryCache = InMemoryCache.getInMemoryCache();
        geoCodingProvider = new GoogleMapsGeoCodingProvider();
    }

    public CoOrdinates getLatLongForAddress(String address) throws IOException {

        if(inMemoryCache.checkIfExists(address)) {
            return inMemoryCache.getFromCache(address);
        }

        else {

            JSONObject jsonObject = geoCodingProvider.geocodeJSON(address);
            CoOrdinates coOrdinates = getCoOrdinatesFromResponse(jsonObject, address);
            inMemoryCache.addToCache(address,coOrdinates);

            return coOrdinates;
        }

    }

    public CoOrdinates getCoOrdinatesFromResponse(JSONObject jsonObject, String address) throws IOException {


        checkForExceptions(jsonObject,address);
        jsonObject =  jsonObject.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location");



        CoOrdinates coOrdinate = new CoOrdinates(jsonObject.get("lat").toString() , jsonObject.get("lng").toString());
        return coOrdinate;
    }

    private void checkForExceptions(JSONObject jsonObject,String address) {
        if(!jsonObject.get("status").toString().equals("OK"))
            throw new BadRequestException();

        if(jsonObject.getJSONArray("results").isEmpty()) {
            throw new LocationDoesNotExistsException(address);
        }

    }




}
