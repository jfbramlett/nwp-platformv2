package com.ninthwave.platform.web.filter;

import com.ninthwave.platform.context.Context;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * This filter defines a unique request id and places it in the request's
 * Context. It also sets it in the logging MDC (ammped document context).
 */
@Component
public class CorrelationFilter implements Filter {
    private static final String REQUEST_ID_KEY = "requestId";

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String requestId = req.getHeader(REQUEST_ID_KEY);
        if (requestId == null) {
            requestId = UUID.randomUUID().toString();
        }

        MDC.put(REQUEST_ID_KEY, requestId);

        Context ctx = Context.getContext();
        ctx.addValue(REQUEST_ID_KEY, requestId);
        Context.setContext(ctx);

        chain.doFilter(request, response);
    }
}