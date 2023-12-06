package com.generic.uip;

import com.generic.uip.common.exception.IncorrectArgumentsException;
import com.generic.uip.common.utils.CommonUtils;
import com.generic.uip.common.driver.JobDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UIPLauncher {

    static {
        String logFileName = (null != System.getProperty("logFileName")) ?
                System.getProperty("logFileName") : "log";
        System.setProperty("logFileName", logFileName + "_"
                + CommonUtils.dateTimeFormatter.format(CommonUtils.getDefaultCurrentDateTime()));
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(UIPLauncher.class);

    public static void main(String[] args) throws Exception {

        try {
            if (args.length < 3) {
                LOGGER.error("Invalid number arguments to main method {}", args.length);
                LOGGER.warn("Required arguments : {}, {}, {}",
                        "tenant", "jobType", "jobArgs");
                throw new IncorrectArgumentsException("Invalid number arguments to main method " + args.length);
            }

            String tenant = args[0];
            String jobType = args[1];
            String jobArgs = args[2];

            String className = "com.generic.uip." + tenant.toLowerCase() + ".driver." + tenant.toUpperCase() + "JobDriver";
            LOGGER.info("Instantiated className : {}", className);

            Class cls = Class.forName(className);
            JobDriver myJobDriver = (JobDriver) cls.getDeclaredConstructor().newInstance();
            myJobDriver.resolveJob(jobType, jobArgs);
        }
        catch (Exception e) {
            LOGGER.error("Problem in processing UIPLauncher", e);
            throw e;
        }
    }
}
