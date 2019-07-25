package com.event.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public final class DateTimeUtil {

    private DateTimeUtil() {
    }

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm");

    public static Long getTimestamp(String date, String time) {
        if (isNotBlank(date) && isNotBlank(time)) {
            return LocalDateTime.parse(date + time, DATE_TIME_FORMATTER)
                                .atZone(ZoneOffset.UTC)
                                .toInstant()
                                .toEpochMilli() / 1000;
        } else {
            return null;
        }
    }
}
