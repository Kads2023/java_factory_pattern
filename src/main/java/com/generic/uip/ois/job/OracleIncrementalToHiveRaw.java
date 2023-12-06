package com.generic.uip.ois.job;

import com.generic.uip.common.factory.impl.job.DefaultJob;
import com.generic.uip.common.factory.impl.job.IncrementalRawJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleIncrementalToHiveRaw extends IncrementalRawJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultJob.class);
    private static boolean IS_JOB_FAILED = false;

    public OracleIncrementalToHiveRaw(String jobArgs, String sourceType, String targetType, String metaType) throws Exception {
        super(jobArgs, sourceType, targetType, metaType);
    }

    @Override
    public void preChecks() throws Exception {
        LOGGER.info("Inside OracleIncrementalToHiveRaw's preChecks");
        super.preChecks();
    }

    @Override
    public void process() throws Exception {
        LOGGER.info("Inside OracleIncrementalToHiveRaw's process");
        super.process();
    }

    @Override
    public void postChecks() throws Exception {
        LOGGER.info("Inside OracleIncrementalToHiveRaw's postChecks");
        super.postChecks();
    }

}
