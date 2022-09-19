package exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class BadRequestExceptionTest {

    @Test
    public void testConstructor() {
        BadRequestException actualBadRequestException = new BadRequestException();
        assertNull(actualBadRequestException.getCause());
        assertEquals(0, actualBadRequestException.getSuppressed().length);
        assertNull(actualBadRequestException.getMessage());
        assertNull(actualBadRequestException.getLocalizedMessage());
    }
}

