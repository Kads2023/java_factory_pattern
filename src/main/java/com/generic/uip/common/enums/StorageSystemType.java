package com.generic.uip.common.enums;

public enum StorageSystemType {
    INCREMENTAL_RAW("ORACLE_OIS"),
    ORACLE_NON_OIS("ORACLE_NON-OIS"),
    BIGQUERY_RAW_OIS("BIGQUERY_RAW_OIS"),
    BIGQUERY_RAW_NON_OIS("BIGQUERY_RAW_NON-OIS"),
    HIVE_GCP("HIVE_GCP");

    public final String name;

    private StorageSystemType(String name) {
        this.name = name;
    }
}
