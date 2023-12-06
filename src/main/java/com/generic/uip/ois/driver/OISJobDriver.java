package com.generic.uip.ois.driver;

import com.generic.uip.common.driver.JobDriver;
import com.generic.uip.common.utils.CommonUtils;
import com.generic.uip.common.factory.iface.IJob;

import com.generic.uip.ois.driver.OISJobFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


public class OISJobDriver extends JobDriver {

    private static final Logger LOGGER = LoggerFactory.getLogger(OISJobDriver.class);

    public void resolveJob(String jobType, String jobArgs)  throws Exception {
        try {
            LOGGER.info("INSIDE OISJobDriver");
            LOGGER.info("INSIDE OISJobDriver, jobType: {}, args : {}", jobType, jobArgs);

            OISJobFactory oisJobFactory = new OISJobFactory();
            IJob ijob = oisJobFactory.getJob(jobType, jobArgs);
            ijob.runJob();
        }
        catch (Exception e) {
            LOGGER.error("Problem in processing OISJobDriver", e.getCause().getMessage());
            throw e;
        }
    }

}
