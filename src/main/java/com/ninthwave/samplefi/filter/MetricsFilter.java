package com.ninthwave.samplefi.filter;

import com.codahale.metrics.Meter;
import com.codahale.metrics.Timer;
import com.ninthwave.platform.metrics.Metrics;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A filter that defines a set of metrics around each incoming http request.
 */
@Component
public class MetricsFilter implements Filter {
    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String metricName = req.getRequestURI().replace("/", ".");

        Meter meter = Metrics.getMeter(metricName);
        meter.mark();

        Metrics.getCounter(metricName + ".requests").inc();

        Timer timer = Metrics.getTimer(req.getRequestURI());
        Timer.Context ctx = timer.time();
        try {
            chain.doFilter(request, response);
            Metrics.getCounter(metricName + ".success").inc();
        } catch (Throwable t) {
            Metrics.getCounter(metricName + ".error").inc();
            throw t;
        } finally {
            ctx.close();
        }
    }
}
