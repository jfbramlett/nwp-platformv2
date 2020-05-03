package com.ninthwave.platform.metrics;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

/**
 * Wrapper around DropWizard metrics initialization  along with simple accessor
 * to obtain references to various metric types.
 */
public class Metrics {
    private static final MetricRegistry registry = new MetricRegistry();

    /**
     * Gets a new meter
     * @param name The name of the meter
     * @return Meter The meter
     */
    public static Meter getMeter(String name) {
        return registry.meter("meter." + name);
    }

    /**
     * Gets a new timer
     * @param name The name of the timer
     * @return Timer The timer
     */
    public static Timer getTimer(String name) {
        return registry.timer("timer." + name);
    }

    public static Counter getCounter(String name) {
        return registry.counter("counter." + name);
    }

}
