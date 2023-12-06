package com.generic.uip.common.dto_utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.generic.uip.common.dto.JobState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JobStateSerializer extends StdSerializer<JobState> {

    private static final Logger log = LoggerFactory.getLogger(JobStateSerializer.class);

    public JobStateSerializer() {
        this(JobState.class);
    }

    protected JobStateSerializer(Class<JobState> vc) {
        super(vc);
    }

    @Override
    public void serialize(
            JobState jobState,
            JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider) throws IOException {
        log.info("Serializing job configuration.");
        jsonGenerator.writeStartObject();

        if (null != jobState.getJobRuntimeMs())
            jsonGenerator.writeNumberField("jobRuntimeMs", jobState.getJobRuntimeMs());
        if (null != jobState.getJobKey())
            jsonGenerator.writeNumberField("jobKey", jobState.getJobKey());
        if (null != jobState.getParentJobKey())
            jsonGenerator.writeNumberField("parentJobKey", jobState.getParentJobKey());
        if (null != jobState.getJobName())
            jsonGenerator.writeStringField("jobName", jobState.getJobName());
        if (null != jobState.getJobInitiationTimeMs())
            jsonGenerator.writeNumberField("jobInitiationTimeMs", jobState.getJobInitiationTimeMs());
        if (null != jobState.getJobRunSequence())
            jsonGenerator.writeNumberField("jobRunSequence", jobState.getJobRunSequence());
        if (null != jobState.getJobFrequencyCode())
            jsonGenerator.writeNumberField("jobFrequencyCode", jobState.getJobFrequencyCode());

        if (null != jobState.getTenantPartyKey())
            jsonGenerator.writeNumberField("tenantPartyKey", jobState.getTenantPartyKey());
        if (null != jobState.getSubmittedBy())
            jsonGenerator.writeStringField("submittedBy", jobState.getSubmittedBy());
        if (null != jobState.getJobExecutionId())
            jsonGenerator.writeStringField("jobExecutionId", jobState.getJobExecutionId());

        jsonGenerator.writeEndObject();
    }
}
