package com.beaconfire.crud_app.Trace;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {

    @Bean
    public Filter traceIdFilter() {
        return new TraceIdFilter();
    }
}