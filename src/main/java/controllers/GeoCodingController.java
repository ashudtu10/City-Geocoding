package controllers;

import exceptions.InputStreamException;
import models.CoOrdinates;
import services.GeocodingService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GeoCodingController {
    private final GeocodingService geocodingService;

    private List<String> cityList = new ArrayList<>();

    private static final String INPUT_FILE = "input.txt";

    private static final String OUTPUT_FILE = "./src/main/resources/output.txt";


    public GeoCodingController()  {
        geocodingService = new GeocodingService();
        try {
            cityList = getCityList();
        }
        catch(Exception e) {
            System.out.println("Exception occured in GeoCodingController");
        }
    }

    public void geocode() throws IOException {

        List<CoOrdinates> finalOutputList = new ArrayList<>();

       for(String city: cityList) {
           CoOrdinates coOrdinates = geocodingService.getLatLongForAddress(city);
           finalOutputList.add(coOrdinates);
       }

       writeOutputToFile(finalOutputList);


    }


    private List<String> getCityList() throws IOException, InputStreamException {
        List<String> cities = new ArrayList<>();
        InputStream inputStream = getFileStreamFromResourceFolder();
        if (Objects.isNull(inputStream)) {
            throw new InputStreamException("Error while generating input stream");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = br.readLine()) != null) {
            cities.add(line);
        }
        return cities;
    }

    private InputStream getFileStreamFromResourceFolder() {
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream(INPUT_FILE);
            return is;
        } catch (Exception ex) {
            System.out.println("Error while reading file");
        }
        return null;
    }

    private void writeOutputToFile(List<CoOrdinates> latLongPairs) throws IOException {
        FileWriter writer = new FileWriter(OUTPUT_FILE);
        for (CoOrdinates coOrdinates : latLongPairs) {
            writer.write(coOrdinates.getLatitude() + "," + coOrdinates.getLongitude()+"\n");
        }
        writer.flush();
        writer.close();
    }

}
