package com.postech30.movies.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BadRequestExceptionTest {
    /**
     * Method under test: {@link BadRequestException#BadRequestException(String)}
     */
    @Test
    void testConstructor() {
        BadRequestException actualBadRequestException = new BadRequestException("An error occurred");
        assertEquals("An error occurred", actualBadRequestException.getLocalizedMessage());
        assertEquals("An error occurred", actualBadRequestException.getMessage());
        assertNull(actualBadRequestException.getCause());
        assertEquals(0, actualBadRequestException.getSuppressed().length);
    }
}
