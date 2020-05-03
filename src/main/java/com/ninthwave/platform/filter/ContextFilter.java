package com.ninthwave.platform.filter;

import com.ninthwave.platform.context.Context;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class ContextFilter implements Filter {
    private static final String REQUEST_ID_KEY = "requestId";

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        Context ctx = Context.getContext();
        ctx.addValue("requestTime", System.currentTimeMillis());
    }
}