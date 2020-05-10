package com.ninthwave.samplefi.filter;

import com.ninthwave.samplefi.context.Context;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A web filter that establishes our context in the handling thread local.
 */
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

        chain.doFilter(request, response);

        Context.initContext();
    }
}