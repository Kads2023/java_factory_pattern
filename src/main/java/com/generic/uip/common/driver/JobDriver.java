package com.generic.uip.common.driver;

import java.io.Serializable;

public abstract class JobDriver implements Serializable {

    abstract public void resolveJob(String jobType, String jobArgs) throws Exception;
}
