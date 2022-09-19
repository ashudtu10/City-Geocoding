package exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class LocationDoesNotExistsExceptionTest {

    @Test
    public void testConstructor() {
        LocationDoesNotExistsException actualLocationDoesNotExistsException = new LocationDoesNotExistsException(
                "42 Main St");
        assertNull(actualLocationDoesNotExistsException.getCause());
        assertEquals(0, actualLocationDoesNotExistsException.getSuppressed().length);
        assertNull(actualLocationDoesNotExistsException.getMessage());
        assertNull(actualLocationDoesNotExistsException.getLocalizedMessage());
    }
}

