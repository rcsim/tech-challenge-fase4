package com.postech30.movies.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ResourceNotFoundExceptionTest {
    /**
     * Method under test:
     * {@link ResourceNotFoundException#ResourceNotFoundException(String)}
     */
    @Test
    void testConstructor() {
        ResourceNotFoundException actualResourceNotFoundException = new ResourceNotFoundException("An error occurred");
        assertEquals("An error occurred", actualResourceNotFoundException.getLocalizedMessage());
        assertEquals("An error occurred", actualResourceNotFoundException.getMessage());
        assertNull(actualResourceNotFoundException.getCause());
        assertEquals(0, actualResourceNotFoundException.getSuppressed().length);
    }
}
