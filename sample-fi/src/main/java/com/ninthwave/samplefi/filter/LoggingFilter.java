package com.ninthwave.samplefi.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Logs each incoming web request.
 *
 */
@Component
public class LoggingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        logger.info(
                "Logging Request  {} : {}", req.getMethod(),
                req.getRequestURI());

        MDC.put("METHOD", req.getMethod());
        MDC.put("URI", req.getRequestURI());

        chain.doFilter(request, response);
        logger.info(
                "Logging Response :{}",
                res.getContentType());
    }
}
