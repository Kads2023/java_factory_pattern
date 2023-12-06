package com.generic.uip.common.enums;

import java.util.Map;

public enum JobType {
    INCREMENTAL_RAW("INCREMENTAL_RAW"),
    INCREMENTAL_MERGE("INCREMENTAL_MERGE");

    public final String name;

    private JobType(String name) {
        this.name = name;
    }

}
