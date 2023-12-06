package com.generic.uip.common.factory.impl.job;

import com.generic.uip.common.factory.iface.IJob;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultJob extends IJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultJob.class);
    private static boolean IS_JOB_FAILED = false;

    public DefaultJob(String jobArgs, String sourceType, String targetType, String metaType) throws Exception {
        super(jobArgs, sourceType, targetType, metaType);
    }

    @Override
    public void preChecks() throws Exception {
        LOGGER.info("Inside DefaultJob's preChecks");
        LOGGER.info("ALL THE COMMON PRE-CHECKS ACROSS JOBS LIKE METADATA WILL BE DONE HERE Inside DefaultJob's preChecks");
//        super.jobState;
        LOGGER.info("Job: ({} - {}), Sequence ({}).",
                super.jobState.getJobKey(),
                super.jobState.getJobRuntimeMs(),
                super.jobState.getJobRunSequence());
        LOGGER.info("Job_properties: ({}).",
                super.jobState.getProperties());
    }

    @Override
    public void process() throws Exception {
        LOGGER.info("Inside DefaultJob's process");
    }

    @Override
    public void postChecks() throws Exception {
        LOGGER.info("Inside DefaultJob's postChecks");
        LOGGER.info("ALL THE COMMON POST-CHECKS ACROSS JOBS LIKE METADATA WILL BE DONE HERE Inside DefaultJob's postChecks");
    }

    @Override
    public void runJob() throws Exception {
        LOGGER.info("Inside DefaultJob's run_load");
        this.preChecks();
        this.process();
        this.postChecks();
    }
}
