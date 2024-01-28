package com.postech30.movies.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StatisticDTOTest {
    @Test
    void testGettersAndSetters() {
        StatisticDTO actualStatisticDTO = new StatisticDTO();
        actualStatisticDTO.setAverage(10.0d);
        actualStatisticDTO.setFavorited(1L);
        actualStatisticDTO.setTotal(1L);
        Double actualAverage = actualStatisticDTO.getAverage();
        Long actualFavorited = actualStatisticDTO.getFavorited();
        Long actualTotal = actualStatisticDTO.getTotal();
        assertEquals(10.0d, actualAverage.doubleValue());
        assertEquals(1L, actualFavorited.longValue());
        assertEquals(1L, actualTotal.longValue());
    }
}
