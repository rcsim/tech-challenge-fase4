package com.postech30.movies.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = {CustomExceptionHandler.class})
@ExtendWith(SpringExtension.class)
class CustomExceptionHandlerTest {
    @Autowired
    private CustomExceptionHandler customExceptionHandler;

    /**
     * Method under test:
     * {@link CustomExceptionHandler#resourceNotFound(ResourceNotFoundException, HttpServletRequest)}
     */
    @Test
    void testResourceNotFound() {
        ResourceNotFoundException e = new ResourceNotFoundException("An error occurred");
        ResponseEntity<Object> actualResourceNotFoundResult = customExceptionHandler.resourceNotFound(e,
                new MockHttpServletRequest());
        assertEquals(4, ((Map<String, Object>) actualResourceNotFoundResult.getBody()).size());
        assertEquals(404, actualResourceNotFoundResult.getStatusCodeValue());
        assertTrue(actualResourceNotFoundResult.hasBody());
        assertTrue(actualResourceNotFoundResult.getHeaders().isEmpty());
    }

    /**
     * Method under test:
     * {@link CustomExceptionHandler#badRequest(BadRequestException, HttpServletRequest)}
     */
    @Test
    void testBadRequest() {
        BadRequestException e = new BadRequestException("An error occurred");
        ResponseEntity<Object> actualBadRequestResult = customExceptionHandler.badRequest(e, new MockHttpServletRequest());
        assertEquals(4, ((Map<String, Object>) actualBadRequestResult.getBody()).size());
        assertEquals(400, actualBadRequestResult.getStatusCodeValue());
        assertTrue(actualBadRequestResult.hasBody());
        assertTrue(actualBadRequestResult.getHeaders().isEmpty());
    }
}
