package com.generic.uip.common.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.generic.uip.common.dto_utils.JobStateDeserializer;
import com.generic.uip.common.dto_utils.JobStateSerializer;

import java.util.Properties;

public class JobState {

    private Properties properties;
    private JobConfiguration sourceJobConfiguration;
    private JobConfiguration targetJobConfiguration;
    private Long jobRuntimeMs;
    private Long jobKey;
    private Long parentJobKey;
    private String jobName;
    private Long jobInitiationTimeMs;
    private Long jobCompletionTimeMs;
    private Integer jobRunSequence;
    private Integer jobFrequencyCode;
    private Integer tenantPartyKey;
    private String submittedBy;
    private String jobExecutionId;

    public JobState() {
    }

    public static JobState getInstanceFromConfig(String config) throws JsonProcessingException {
        SimpleModule simpleModule = new SimpleModule("JobStateDeserializer");
        simpleModule.addDeserializer(JobState.class, new JobStateDeserializer());

        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(simpleModule);

        return objectMapper.readValue(config, JobState.class);
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public JobConfiguration getSourceJobConfiguration() {
        return sourceJobConfiguration;
    }

    public void setSourceJobConfiguration(JobConfiguration sourceJobConfiguration) {
        this.sourceJobConfiguration = sourceJobConfiguration;
    }

    public JobConfiguration getTargetJobConfiguration() {
        return targetJobConfiguration;
    }

    public void setTargetJobConfiguration(JobConfiguration targetJobConfiguration) {
        this.targetJobConfiguration = targetJobConfiguration;
    }

    public Long getJobRuntimeMs() {
        return jobRuntimeMs;
    }

    public void setJobRuntimeMs(Long jobRuntimeMs) {
        this.jobRuntimeMs = jobRuntimeMs;
    }

    public Long getJobKey() {
        return jobKey;
    }

    public void setJobKey(Long jobKey) {
        this.jobKey = jobKey;
    }

    public Long getParentJobKey() {
        return parentJobKey;
    }

    public void setParentJobKey(Long parentJobKey) {
        this.parentJobKey = parentJobKey;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Long getJobInitiationTimeMs() {
        return jobInitiationTimeMs;
    }

    public void setJobInitiationTimeMs(Long jobInitiationTimeMs) {
        this.jobInitiationTimeMs = jobInitiationTimeMs;
    }

    public Long getJobCompletionTimeMs() {
        return jobCompletionTimeMs;
    }

    public void setJobCompletionTimeMs(Long jobCompletionTimeMs) {
        this.jobCompletionTimeMs = jobCompletionTimeMs;
    }

    public Integer getJobRunSequence() {
        return jobRunSequence;
    }

    public void setJobRunSequence(Integer jobRunSequence) {
        this.jobRunSequence = jobRunSequence;
    }

    public Integer getJobFrequencyCode() {
        return jobFrequencyCode;
    }

    public void setJobFrequencyCode(Integer jobFrequencyCode) {
        this.jobFrequencyCode = jobFrequencyCode;
    }

    public Integer getTenantPartyKey() {
        return tenantPartyKey;
    }

    public void setTenantPartyKey(Integer tenantPartyKey) {
        this.tenantPartyKey = tenantPartyKey;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getJobExecutionId() {
        return jobExecutionId;
    }

    public void setJobExecutionId(String jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }

    public String writeAsString() throws JsonProcessingException {
        SimpleModule simpleModule = new SimpleModule("JobStateSerializer");
        simpleModule.addSerializer(JobState.class, new JobStateSerializer());

        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(simpleModule);
        return objectMapper.writeValueAsString(this);
    }

    public JsonNode writeAsJson() {
        SimpleModule simpleModule = new SimpleModule("JobStateSerializer");
        simpleModule.addSerializer(JobState.class, new JobStateSerializer());

        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(simpleModule);
        return objectMapper.convertValue(this, JsonNode.class);
    }
}
