package com.generic.uip.common.dto_utils;

import com.google.cloud.spark.bigquery.repackaged.com.google.cloud.bigquery.TimePartitioning;
import com.generic.uip.common.dto.JobConfiguration;
import com.generic.uip.common.utils.Constants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonUtils {

    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static ZoneId getDefaultAppZoneId() {
        return ZoneId.of(Constants.DEFAULT_TIME_ZONE);
    }

    public static ZonedDateTime getDefaultCurrentDateTime() {
        return ZonedDateTime.now(getDefaultAppZoneId());
    }

    public static Long getDefaultCurrentEpochMs() {
        return getDefaultCurrentDateTime().toInstant().toEpochMilli();
    }

    public static LocalDateTime toDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, dateTimeFormatter);
    }

    public static String getOracleDateTimeFormat(ZonedDateTime zonedDateTime) {
        return dateTimeFormatter.format(zonedDateTime);
    }

    public static String getBatchTimeForWrite(ZonedDateTime batchTime, TimePartitioning.Type type) {
        DateTimeFormatter formatter = null;

        switch (type) {
            case HOUR:
                formatter = DateTimeFormatter.ofPattern("yyyyMMddHH");
                break;
            case DAY:
                formatter = DateTimeFormatter.ofPattern("yyyyMMdd");;
                break;
            case MONTH:
                formatter = DateTimeFormatter.ofPattern("yyyyMM");
                break;
            case YEAR:
                formatter = DateTimeFormatter.ofPattern("yyyy");
                break;
        }
        return formatter.format(batchTime);
    }

    public static String getBatchTimeForRead(ZonedDateTime batchTime, TimePartitioning.Type type) {
        DateTimeFormatter formatter = null;

        switch (type) {
            case HOUR:
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                break;
            case DAY:
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");;
                break;
            case MONTH:
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                break;
            case YEAR:
                formatter = DateTimeFormatter.ofPattern("yyyy");
                break;
        }
        return formatter.format(batchTime);
    }

    public static String getBatchTimeForRead(Long batchTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        DateTimeFormatter oldFormat = DateTimeFormatter.ofPattern(Constants.INPUT_DATE_TIME_FORMAT);
        return formatter.format(LocalDateTime.parse(String.valueOf(batchTime), oldFormat));
    }

    public static <T> T castObject(Class<T> clazz, Object object) {
        Object result = null;

        if (object instanceof BigDecimal) {
            if (clazz.equals(Double.class))
                result = ((BigDecimal) object).doubleValue();
            else if (clazz.equals(Long.class))
                result = ((BigDecimal) object).longValue();
            else if (clazz.equals(Integer.class))
                result = ((BigDecimal) object).intValue();
            else
                throw new ClassCastException("Can't cast " + object.getClass() + " to " + clazz);
        } else if (object instanceof Double
                || object instanceof Long
                || object instanceof Integer) {
            if (clazz.equals(Double.class))
                result = ((Number) object).doubleValue();
            else if (clazz.equals(Long.class))
                result = ((Number) object).longValue();
            else if (clazz.equals(Integer.class))
                result = ((Number) object).intValue();
            else
                throw new ClassCastException("Can't cast " + object.getClass() + " to " + clazz);
        } else {
            throw new ClassCastException("Can't cast " + object.getClass() + " to " + clazz);
        }
        return clazz.cast(result);
    }

    public static List<String[]> splitPredicate(String[] array) {
        final int splitSize = Integer.parseInt(Constants.EXECUTOR_MAX_SIZE) *
                Integer.parseInt(Constants.EXECUTOR_MAX_CORES);
        final int numberOfArrays = (array.length / splitSize) - 1;
        final int remainder = array.length % splitSize;

        int start = 0;
        int end = 0;
        List<String[]> list = new ArrayList<>();

        if (array.length <= splitSize) {
            list.add(Arrays.copyOfRange(array, start, (end + remainder)));
            return list;
        }

        for (int i = 0; i < numberOfArrays; i++) {
            end += splitSize;
            list.add(Arrays.copyOfRange(array, start, end));
            start = end;
        }

        end += splitSize;
        if (remainder <= (splitSize / 4)) {
            list.add(Arrays.copyOfRange(array, start, (end + remainder)));
        } else {
            list.add(Arrays.copyOfRange(array, start, end));
            start = end;
            list.add(Arrays.copyOfRange(array, start, (end + remainder)));
        }
        return list;
    }

    public static void validateTableRangeBound(JobConfiguration jobConfiguration) {
        if (null == jobConfiguration.getLowerBound() ||
                null == jobConfiguration.getUpperBound() ||
                jobConfiguration.getLowerBound().equals(0L) ||
                jobConfiguration.getUpperBound().equals(0L)) {
            throw new RuntimeException("Invalid table range bound.");
        }

        if (jobConfiguration.getLowerBound() > jobConfiguration.getUpperBound()) {
            throw new RuntimeException(String.format(
                    "Table lower bound (%s) is greater than higher bound (%s).",
                    jobConfiguration.getLowerBound(), jobConfiguration.getUpperBound()));
        }
    }

    public static String getStackTraceAsString(Throwable throwable, Integer maxLength) {
        try (StringWriter stringWriter = new StringWriter();
             PrintWriter printWriter = new PrintWriter(stringWriter)) {
            throwable.printStackTrace(printWriter);

            String stackTrace = stringWriter.toString();
            return stackTrace.substring(0, stackTrace.length() >= maxLength ? maxLength : stackTrace.length());
        } catch (Exception ex) {
            return "Convert exception object to string failed. " + ex;
        }
    }

    public static Object[] previousJob(Long jobRuntimeMs, Integer jobRunSequence, Integer jobFrequencyCode) {
        Integer prevJobRunSequence = (jobRunSequence > 1) ?
                (jobRunSequence - 1) : ((60 * 24) / jobFrequencyCode);
        return new Object[] { (jobRuntimeMs - (jobFrequencyCode * 60)), prevJobRunSequence};
    }
}
