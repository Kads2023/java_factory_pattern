package com.generic.uip.common.factory.provider;

import com.generic.uip.common.factory.iface.IMeta;
import com.generic.uip.common.factory.impl.meta.MySqlMeta;

public class MetaFactory {
    public static IMeta getMeta(String metaType) throws Exception {
        if (metaType.equalsIgnoreCase("MYSQL")) {
            return new MySqlMeta();
        }
        else {
            throw new Exception("Invalid metaType --> " + metaType);
        }
    }
}