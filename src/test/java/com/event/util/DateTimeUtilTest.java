package com.event.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateTimeUtilTest {

    @Test
    public void shouldParseDateTimeCorrectly() {
        assertEquals(new Long(1563625800), DateTimeUtil.getTimestamp("2019-07-20", "12:30"));
    }
}