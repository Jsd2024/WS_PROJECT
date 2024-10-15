//package org.com.crnk.demo.config;
//
//import org.com.crnk.demo.util.CorrelationIdUtil;
//import org.slf4j.MDC;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//public class CorrelationIdInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        // Generate correlation ID
//        String correlationId = CorrelationIdUtil.generateCorrelationId();
//
//        // Add it to the MDC
//        CorrelationIdUtil.putCorrelationIdInMDC(correlationId);
//
//        // Add the correlation ID to the response headers (optional)
//        response.setHeader("ggid", correlationId);
//
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        // Clear the MDC after the request is completed
//        CorrelationIdUtil.clearCorrelationId();
//    }
//}
