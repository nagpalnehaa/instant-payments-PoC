package com.poc.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuditLogger {

    private static final Logger logger = LoggerFactory.getLogger("AUDIT");

    public static void log(String stage, Object payload) {
        logger.info("[AUDIT][{}] Payload: {}", stage, payload);
    }
}
