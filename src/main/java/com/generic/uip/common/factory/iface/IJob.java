package com.generic.uip.common.factory.iface;

import com.generic.uip.common.dto.JobState;
import com.generic.uip.common.factory.provider.MetaFactory;
import com.generic.uip.common.factory.provider.EndPointFactory;
import com.generic.uip.common.factory.iface.IMeta;
import com.generic.uip.common.factory.iface.IEndPoint;


import java.io.Serializable;

public abstract class IJob implements Serializable {
    protected JobState jobState;
    protected IMeta metadataObject;
    protected IEndPoint sourceObject;
    protected IEndPoint targetObject;

    public IJob(String jobArgs, String sourceType, String targetType, String metaType) throws Exception {
        this.jobState = JobState.getInstanceFromConfig(jobArgs);
        this.metadataObject = MetaFactory.getMeta(metaType);
        this.sourceObject = EndPointFactory.getEndPoint(sourceType);
        this.targetObject = EndPointFactory.getEndPoint(targetType);
    }

    abstract public void preChecks() throws Exception;
    abstract public void process() throws Exception;
    abstract public void postChecks() throws Exception;
    abstract public void runJob() throws Exception;
}
