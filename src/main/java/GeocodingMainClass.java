import controllers.GeoCodingController;
import exceptions.InputStreamException;

import java.io.IOException;

public class GeocodingMainClass {

    public static void main(String [] args) throws IOException, InputStreamException {

        GeoCodingController geoCodingController = new GeoCodingController();

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        geoCodingController.geocode();

    }
}
