package com.generic.uip.common.dto_utils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.generic.uip.common.dto.JobState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.generic.uip.common.utils.Constants;

import java.io.IOException;

public class JobStateDeserializer extends StdDeserializer<JobState> {

    private static final Logger log = LoggerFactory.getLogger(JobStateDeserializer.class);

    public JobStateDeserializer() {
        this(JobState.class);
    }

    protected JobStateDeserializer(final Class<?> vc) {
        super(vc);
    }

    @Override
    public JobState deserialize(
            JsonParser parser,
            DeserializationContext context) throws IOException, JacksonException {
        log.info("Deserializing job configuration.");

        JobState jobState = new JobState();
        JsonNode treeNode = parser.getCodec().readTree(parser);

        if (treeNode.has("jobRuntimeMs"))
            jobState.setJobRuntimeMs(treeNode.path("jobRuntimeMs").asLong());
        if (treeNode.has("jobKey"))
            jobState.setJobKey(treeNode.path("jobKey").asLong());
        if (treeNode.has("parentJobKey"))
            jobState.setParentJobKey(treeNode.path("parentJobKey").asLong());
        if (treeNode.has("jobName"))
            jobState.setJobName(treeNode.path("jobName").asText());
        if (treeNode.has("jobInitiationTimeMs"))
            jobState.setJobInitiationTimeMs(treeNode.path("jobInitiationTimeMs").asLong());
        if (treeNode.has("jobRunSequence"))
            jobState.setJobRunSequence(treeNode.path("jobRunSequence").asInt());
        if (treeNode.has("jobFrequencyCode"))
            jobState.setJobFrequencyCode(treeNode.path("jobFrequencyCode").asInt());
        else
            jobState.setJobFrequencyCode(Constants.DEFAULT_JOB_SCHEDULE);

        if (treeNode.has("tenantPartyKey"))
            jobState.setTenantPartyKey(treeNode.path("tenantPartyKey").asInt());
        if (treeNode.has("submittedBy"))
            jobState.setSubmittedBy(treeNode.path("submittedBy").asText());
        if (treeNode.has("jobExecutionId"))
            jobState.setJobExecutionId(treeNode.path("jobExecutionId").asText());

        return jobState;
    }
}
