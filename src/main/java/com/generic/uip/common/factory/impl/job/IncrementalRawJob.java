package com.generic.uip.common.factory.impl.job;

import com.generic.uip.common.factory.impl.job.DefaultJob;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IncrementalRawJob extends DefaultJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultJob.class);
    private static boolean IS_JOB_FAILED = false;

    public IncrementalRawJob(String jobArgs, String sourceType, String targetType, String metaType) throws Exception {
        super(jobArgs, sourceType, targetType, metaType);
    }

    @Override
    public void preChecks() throws Exception {
        LOGGER.info("Inside IncrementalRawJob's preChecks");
        super.preChecks();
    }

    @Override
    public void process() throws Exception {
        LOGGER.info("Inside IncrementalRawJob's process");
        super.process();
    }

    @Override
    public void postChecks() throws Exception {
        LOGGER.info("Inside IncrementalRawJob's postChecks");
        super.postChecks();
    }
}
