package com.generic.uip.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Utils {
    private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);

    public static Timestamp getCurrentTimestampInUTC() {
        return Timestamp.valueOf(LocalDateTime.now());
    }

    public static Long getEpochByTimeZone(String timeZone, LocalDateTime localDate){
        return (localDate.toEpochSecond(ZoneId.of(timeZone).getRules().getOffset(localDate))) * 1000;
    }

    public static LocalDateTime getDataDate(String dataDate){
        return LocalDateTime.parse(String.format("%s",dataDate), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}