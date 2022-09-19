package cache;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import models.CoOrdinates;
import org.junit.Ignore;
import org.junit.Test;

public class InMemoryCacheTest {

    @Test
    public void testCheckIfExists() {
        assertFalse(InMemoryCache.getInMemoryCache().checkIfExists("LocationLocation"));
    }

    @Test
    public void testGetFromCache3() {
        assertNull(InMemoryCache.getInMemoryCache().getFromCache("LocationLocation"));
    }
}

