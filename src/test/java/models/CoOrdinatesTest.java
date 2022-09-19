package models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CoOrdinatesTest {
    @Test
    public void testConstructor() {
        CoOrdinates actualCoOrdinates = new CoOrdinates("Latitude", "Longitude");

        assertEquals("Latitude", actualCoOrdinates.getLatitude());
        assertEquals("Longitude", actualCoOrdinates.getLongitude());
    }
}

