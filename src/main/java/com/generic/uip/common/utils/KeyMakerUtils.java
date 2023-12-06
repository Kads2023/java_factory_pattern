package com.generic.uip.common.utils;

import java.nio.charset.StandardCharsets;
import java.util.*;


public class KeyMakerUtils {

    private static String checkAndReturnKey(List<String> secretKeys, boolean isDecodeNeed) {
        if (!secretKeys.isEmpty()) {
            if(isDecodeNeed) {
                return new String(Base64.getDecoder().decode(secretKeys.get(0)), StandardCharsets.UTF_8);
            } else {
                return secretKeys.get(0);
            }
        } else {
            throw new RuntimeException("Mentioned key is not available");
        }
    }
}
