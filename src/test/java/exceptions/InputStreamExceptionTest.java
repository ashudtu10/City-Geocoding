package exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class InputStreamExceptionTest {

    @Test
    public void testConstructor() {
        InputStreamException actualInputStreamException = new InputStreamException();
        assertNull(actualInputStreamException.getCause());
        assertEquals(0, actualInputStreamException.getSuppressed().length);
        assertNull(actualInputStreamException.getMessage());
        assertNull(actualInputStreamException.getLocalizedMessage());
    }

    @Test
    public void testConstructor2() {
        InputStreamException actualInputStreamException = new InputStreamException("An error occurred");
        assertNull(actualInputStreamException.getCause());
        assertEquals(0, actualInputStreamException.getSuppressed().length);
        assertEquals("An error occurred", actualInputStreamException.getMessage());
        assertEquals("An error occurred", actualInputStreamException.getLocalizedMessage());
    }
}

