package com.event.util;

import org.junit.Test;

import static com.event.CommonTestData.*;
import static org.junit.Assert.assertEquals;

public class EventConverterTest {

    @Test
    public void shouldConvertToEntity() {
        assertEquals(VALID_ENTITY, EventConverter.convertToEntity(VALID_DTO));
    }

    @Test
    public void shouldConvertToDto() {
        assertEquals(VALID_DTO, EventConverter.convertToDto(VALID_ENTITY));
    }
}