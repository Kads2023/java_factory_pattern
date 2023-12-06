package com.generic.uip.common.factory.provider;

import com.generic.uip.common.factory.iface.IEndPoint;
import com.generic.uip.common.factory.impl.endpoints.BQEndPoint;
import com.generic.uip.common.factory.impl.endpoints.OracleEndPoint;

public class EndPointFactory {
    public static IEndPoint getEndPoint(String endpointType) throws Exception {
        if (endpointType.equalsIgnoreCase("BQ")) {
            return new BQEndPoint();
        }
        else if (endpointType.equalsIgnoreCase("ORACLE")) {
            return new OracleEndPoint();
        }
        else {
            throw new Exception("Invalid endpointType --> " + endpointType);
        }
    }
}