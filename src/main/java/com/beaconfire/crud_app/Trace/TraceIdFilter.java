package com.beaconfire.crud_app.Trace;

import org.slf4j.MDC;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

public class TraceIdFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("TraceIdFilter executed");
        try {
            String traceId = UUID.randomUUID().toString();
            MDC.put("traceId", traceId);

            chain.doFilter(request, response);

        } finally {
            MDC.clear();
        }
    }
}
