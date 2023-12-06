package com.generic.uip.ois.driver;

import com.generic.uip.common.exception.IncorrectArgumentsException;
import com.generic.uip.common.factory.iface.IJob;
import com.generic.uip.common.enums.JobType;
import com.generic.uip.ois.utils.OISConstants;
import com.generic.uip.ois.job.OracleIncrementalToBigQueryRaw;

import java.util.Properties;
import java.util.Arrays;

public class OISJobFactory {
    public static IJob getJob(String jobType, String jobArgs) throws Exception {
        try {
            JobType.valueOf(jobType.toUpperCase());
        } catch (IllegalArgumentException e1) {
            throw new Exception("Invalid jobType --> " + jobType +
                    ", ALLOWED jobTypes are --> " + Arrays.toString(JobType.values()));
        }

        switch (JobType.valueOf(jobType.toUpperCase())) {
            case INCREMENTAL_RAW:
                return new OracleIncrementalToBigQueryRaw(jobArgs, "oracle", "BQ", OISConstants.META_TYPE);
            default:
                throw new Exception("Invalid jobType --> " + jobType +
                        ", ALLOWED jobTypes are --> " + Arrays.toString(JobType.values()));
        }
    }
}
