//package org.com.crnk.demo.util;
//
//import org.slf4j.MDC;
//
//import java.util.UUID;
//
//public class CorrelationIdUtil {
//
//    // Method to generate a unique correlation ID (ggid)
//    public static String generateCorrelationId() {
//        return UUID.randomUUID().toString();
//    }
//
//    // Method to put the correlation ID in MDC
//    public static void putCorrelationIdInMDC(String correlationId) {
//        MDC.put("ggid", correlationId);
//    }
//
//    // Method to remove the correlation ID from MDC (for cleanup)
//    public static void clearCorrelationId() {
//        MDC.remove("ggid");
//    }
//}
