package services;

import exceptions.BadRequestException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GeocodingServiceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testGetCoOrdinatesFromResponse2() throws IOException, JSONException {
        GeocodingService geocodingService = new GeocodingService();

        JSONObject jsonObject = new JSONObject();
        jsonObject.append("status", "Value");
        thrown.expect(BadRequestException.class);
        geocodingService.getCoOrdinatesFromResponse(jsonObject, "42 Main St");
    }

    @Test
    public void testGetCoOrdinatesFromResponse3() throws IOException, JSONException {
        GeocodingService geocodingService = new GeocodingService();

        JSONObject jsonObject = new JSONObject();
        jsonObject.increment("status");
        thrown.expect(BadRequestException.class);
        geocodingService.getCoOrdinatesFromResponse(jsonObject, "42 Main St");
    }

    @Test
    public void testGetCoOrdinatesFromResponse4() throws IOException, JSONException {
        GeocodingService geocodingService = new GeocodingService();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", (Collection<?>) new ArrayList<>());
        thrown.expect(BadRequestException.class);
        geocodingService.getCoOrdinatesFromResponse(jsonObject, "42 Main St");
    }

    @Test
    public void testGetCoOrdinatesFromResponse5() throws IOException, JSONException {
        GeocodingService geocodingService = new GeocodingService();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", (Map<?, ?>) new HashMap<>());
        thrown.expect(BadRequestException.class);
        geocodingService.getCoOrdinatesFromResponse(jsonObject, "42 Main St");
    }

    @Test
    public void testGetCoOrdinatesFromResponse6() throws IOException, JSONException {
        GeocodingService geocodingService = new GeocodingService();

        JSONObject jsonObject = new JSONObject();
        jsonObject.append("status", "Value");
        jsonObject.append("status", "Value");
        thrown.expect(BadRequestException.class);
        geocodingService.getCoOrdinatesFromResponse(jsonObject, "42 Main St");
    }

    @Test
    public void testGetCoOrdinatesFromResponse7() throws IOException, JSONException {
        GeocodingService geocodingService = new GeocodingService();

        JSONObject jsonObject = new JSONObject();
        jsonObject.append("status", 42);
        thrown.expect(BadRequestException.class);
        geocodingService.getCoOrdinatesFromResponse(jsonObject, "42 Main St");
    }

    @Test
    public void testGetCoOrdinatesFromResponse8() throws IOException, JSONException {
        GeocodingService geocodingService = new GeocodingService();

        JSONObject jsonObject = new JSONObject();
        jsonObject.append("status", "[\"Value\"]");
        thrown.expect(BadRequestException.class);
        geocodingService.getCoOrdinatesFromResponse(jsonObject, "42 Main St");
    }

    @Test
    public void testGetCoOrdinatesFromResponse9() throws IOException, JSONException {
        GeocodingService geocodingService = new GeocodingService();

        JSONObject jsonObject = new JSONObject();
        jsonObject.append("status", "");
        thrown.expect(BadRequestException.class);
        geocodingService.getCoOrdinatesFromResponse(jsonObject, "42 Main St");
    }
}

