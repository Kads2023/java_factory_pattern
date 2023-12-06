package com.generic.uip.common.dto;

import com.google.cloud.spark.bigquery.SparkBigQueryConfig;
import com.google.cloud.spark.bigquery.repackaged.com.google.cloud.bigquery.TimePartitioning;
import com.generic.uip.common.enums.GoogleCloudStorageType;
import com.generic.uip.common.enums.ColumnDataType;
import com.generic.uip.common.enums.ExtractType;
import com.generic.uip.common.enums.FetchBy;
import com.generic.uip.common.enums.SaveModeType;
import com.generic.uip.common.enums.StorageSystemType;

public class JobConfiguration {

    private Long dataEntityKey;
    private StorageSystemType storageSystemType;
    private String project;
    private String database;
    private String table;
    private Integer tableSize;
    private Long tableRowCount;
    private String primarykey;
    private ColumnDataType primaryKeyType;
    private String cdcColumn;
    private ColumnDataType cdcColumnType;
    private FetchBy fetchBy;
    private ExtractType extractType;
    private Integer partitionSize;
    private Integer partitionMaxRows;
    private Integer numPartitions;
    private Long lowerBound;
    private Long upperBound;
    private Long lowerBoundEpochMs;
    private Long upperBoundEpochMs;
    private String[] predicates;
    private String sqlPredicate;
    private Long tableInsertedRows;
    private Long tableUpdatedRows;
    private Long tableDeletedRows;
    private Boolean tableIsFSL;
    private String logicalTableName;
    private String logicalFCDTableName;
    private Boolean tableIncrementalJobStatus;
    private Boolean allowSchemaEvolution;
    private Boolean allowAuditColumns;
    private String googleCloudStoragePath;
    private GoogleCloudStorageType googleCloudStorageType;
    private SaveModeType saveMode;
    private SparkBigQueryConfig.WriteMethod writeMethod;
    private String clusteredFields;
    private String partitionColumn;
    private TimePartitioning.Type partitionType;
    private Long partitionExpirationMs;
    private Boolean requirePartition;

    public JobConfiguration() {
    }

    public Long getDataEntityKey() {
        return dataEntityKey;
    }

    public void setDataEntityKey(Long dataEntityKey) {
        this.dataEntityKey = dataEntityKey;
    }

    public StorageSystemType getStorageSystemType() {
        return storageSystemType;
    }

    public void setStorageSystemType(StorageSystemType storageSystemType) {
        this.storageSystemType = storageSystemType;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Integer getTableSize() {
        return tableSize;
    }

    public void setTableSize(Integer tableSize) {
        this.tableSize = tableSize;
    }

    public Long getTableRowCount() {
        return tableRowCount;
    }

    public void setTableRowCount(Long tableRowCount) {
        this.tableRowCount = tableRowCount;
    }

    public String getPrimarykey() {
        return primarykey;
    }

    public void setPrimarykey(String primarykey) {
        this.primarykey = primarykey;
    }

    public ColumnDataType getPrimaryKeyType() {
        return primaryKeyType;
    }

    public void setPrimaryKeyType(ColumnDataType primaryKeyType) {
        this.primaryKeyType = primaryKeyType;
    }

    public String getCdcColumn() {
        return cdcColumn;
    }

    public void setCdcColumn(String cdcColumn) {
        this.cdcColumn = cdcColumn;
    }

    public ColumnDataType getCdcColumnType() {
        return cdcColumnType;
    }

    public void setCdcColumnType(ColumnDataType cdcColumnType) {
        this.cdcColumnType = cdcColumnType;
    }

    public FetchBy getFetchBy() {
        return fetchBy;
    }

    public void setFetchBy(FetchBy fetchBy) {
        this.fetchBy = fetchBy;
    }

    public ExtractType getExtractType() {
        return extractType;
    }

    public void setExtractType(ExtractType extractType) {
        this.extractType = extractType;
    }

    public Integer getPartitionSize() {
        return partitionSize;
    }

    public void setPartitionSize(Integer partitionSize) {
        this.partitionSize = partitionSize;
    }

    public Integer getPartitionMaxRows() {
        return partitionMaxRows;
    }

    public void setPartitionMaxRows(Integer partitionMaxRows) {
        this.partitionMaxRows = partitionMaxRows;
    }

    public Integer getNumPartitions() {
        return numPartitions;
    }

    public void setNumPartitions(Integer numPartitions) {
        this.numPartitions = numPartitions;
    }

    public Long getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(Long lowerBound) {
        this.lowerBound = lowerBound;
    }

    public Long getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(Long upperBound) {
        this.upperBound = upperBound;
    }

    public Long getLowerBoundEpochMs() {
        return lowerBoundEpochMs;
    }

    public void setLowerBoundEpochMs(Long lowerBoundEpochMs) {
        this.lowerBoundEpochMs = lowerBoundEpochMs;
    }

    public Long getUpperBoundEpochMs() {
        return upperBoundEpochMs;
    }

    public void setUpperBoundEpochMs(Long upperBoundEpochMs) {
        this.upperBoundEpochMs = upperBoundEpochMs;
    }

    public String[] getPredicates() {
        return predicates;
    }

    public void setPredicates(String[] predicates) {
        this.predicates = predicates;
    }

    public String getSqlPredicate() {
        return sqlPredicate;
    }

    public void setSqlPredicate(String sqlPredicate) {
        this.sqlPredicate = sqlPredicate;
    }

    public Long getTableInsertedRows() {
        return tableInsertedRows;
    }

    public void setTableInsertedRows(Long tableInsertedRows) {
        this.tableInsertedRows = tableInsertedRows;
    }

    public Long getTableUpdatedRows() {
        return tableUpdatedRows;
    }

    public void setTableUpdatedRows(Long tableUpdatedRows) {
        this.tableUpdatedRows = tableUpdatedRows;
    }

    public Long getTableDeletedRows() {
        return tableDeletedRows;
    }

    public void setTableDeletedRows(Long tableDeletedRows) {
        this.tableDeletedRows = tableDeletedRows;
    }

    public Boolean getTableIsFSL() {
        return tableIsFSL;
    }

    public void setTableIsFSL(Boolean tableIsFSL) {
        this.tableIsFSL = tableIsFSL;
    }

    public String getLogicalTableName() {
        return logicalTableName;
    }

    public void setLogicalTableName(String logicalTableName) {
        this.logicalTableName = logicalTableName;
    }

    public String getLogicalFCDTableName() {
        return logicalFCDTableName;
    }

    public void setLogicalFCDTableName(String logicalFCDTableName) {
        this.logicalFCDTableName = logicalFCDTableName;
    }

    public Boolean getTableIncrementalJobStatus() {
        return tableIncrementalJobStatus;
    }

    public void setTableIncrementalJobStatus(Boolean tableIncrementalJobStatus) {
        this.tableIncrementalJobStatus = tableIncrementalJobStatus;
    }

    public SaveModeType getSaveMode() {
        return saveMode;
    }

    public void setSaveMode(SaveModeType saveMode) {
        this.saveMode = saveMode;
    }

    public Boolean getAllowSchemaEvolution() {
        return allowSchemaEvolution;
    }

    public void setAllowSchemaEvolution(Boolean allowSchemaEvolution) {
        this.allowSchemaEvolution = allowSchemaEvolution;
    }

    public Boolean getAllowAuditColumns() {
        return allowAuditColumns;
    }

    public void setAllowAuditColumns(Boolean allowAuditColumns) {
        this.allowAuditColumns = allowAuditColumns;
    }

    public String getGoogleCloudStoragePath() {
        return googleCloudStoragePath;
    }

    public void setGoogleCloudStoragePath(String googleCloudStoragePath) {
        this.googleCloudStoragePath = googleCloudStoragePath;
    }

    public GoogleCloudStorageType getGoogleCloudStorageType() {
        return googleCloudStorageType;
    }

    public void setGoogleCloudStorageType(GoogleCloudStorageType googleCloudStorageType) {
        this.googleCloudStorageType = googleCloudStorageType;
    }

    public SparkBigQueryConfig.WriteMethod getWriteMethod() {
        return writeMethod;
    }

    public void setWriteMethod(SparkBigQueryConfig.WriteMethod writeMethod) {
        this.writeMethod = writeMethod;
    }

    public String getClusteredFields() {
        return clusteredFields;
    }

    public void setClusteredFields(String clusteredFields) {
        this.clusteredFields = clusteredFields;
    }

    public String getPartitionColumn() {
        return partitionColumn;
    }

    public void setPartitionColumn(String partitionColumn) {
        this.partitionColumn = partitionColumn;
    }

    public TimePartitioning.Type getPartitionType() {
        return partitionType;
    }

    public void setPartitionType(TimePartitioning.Type partitionType) {
        this.partitionType = partitionType;
    }

    public Long getPartitionExpirationMs() {
        return partitionExpirationMs;
    }

    public void setPartitionExpirationMs(Long partitionExpirationMs) {
        this.partitionExpirationMs = partitionExpirationMs;
    }

    public Boolean getRequirePartition() {
        return requirePartition;
    }

    public void setRequirePartition(Boolean requirePartition) {
        this.requirePartition = requirePartition;
    }

    /**
     * @return The OIS table name.
     */
    public String getGGTable() {
        if (null == this.table)
            return null;

        return "GG_" + this.table.toUpperCase();
    }

    /**
     * @return The source system fully qualified table name.
     */
    public String getEntity() {
        if (null == this.database || null == this.table)
            return null;

        return this.database.toUpperCase() + "." + this.table.toUpperCase();
    }

    /**
     * @return The OIS fully qualified table name.
     */
    public String getGGEntity() {
        if (null == this.database || null == this.table)
            return null;

        return this.database.toUpperCase() + "." + "GG_" + this.table.toUpperCase();
    }

    /**
     * @return The OIS FCD fully qualified table name.
     */
    public String getFCDEntity() {
        if (null == this.database || null == this.table)
            return null;

        return this.database.toUpperCase() + "." + this.table.toUpperCase() + "_FCD";
    }

    /**
     * @return Fully qualified table name in BigQuery.
     */
    public String getBigqueryFullTableName() {
        if (null == this.project
                || null == this.database
                || null == this.table)
            return null;

        return this.project + "." + this.database + "." + this.table;
    }

    /**
     * @return Fully qualified table name in BigQuery.
     */
    public String getBigqueryTableName() {
        if (null == this.database
                || null == this.table)
            return null;

        return this.database + "." + this.table;
    }
}
