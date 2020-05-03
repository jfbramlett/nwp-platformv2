package com.ninthwave.platform.metrics;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

public class Metrics {
    private static final MetricRegistry registry = new MetricRegistry();

    public static Meter getMeter(String name) {
        return registry.meter("meter." + name);
    }

    public static Timer getTimer(String name) {
        return registry.timer("timer." + name);
    }

    public static Counter getCounter(String name) {
        return registry.counter("counter." + name);
    }

}
