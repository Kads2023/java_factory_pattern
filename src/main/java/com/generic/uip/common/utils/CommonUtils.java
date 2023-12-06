package com.generic.uip.common.utils;

import com.generic.uip.common.utils.Constants;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CommonUtils {
    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static ZonedDateTime getDefaultCurrentDateTime() {
        return ZonedDateTime.now(getDefaultAppZoneId());
    }

    public static ZoneId getDefaultAppZoneId() {
        return ZoneId.of(Constants.DEFAULT_TIME_ZONE);
    }
}
