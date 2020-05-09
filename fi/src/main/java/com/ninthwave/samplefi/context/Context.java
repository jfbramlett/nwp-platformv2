package com.ninthwave.samplefi.context;

import java.util.HashMap;
import java.util.Map;

/**
 * Context is a per-call collection of key values that provides a mechanism for sharing
 * information across calls.
 */
public class Context {
    public static final ThreadLocal<Context> contextThreadLocal = ThreadLocal.withInitial(Context::new);

    private Map<String, Object> ctx = new HashMap<>();

    /**
     * Constructor
     */
    private Context() {
    }

    /**
     * Adds a value to the context
     * @param key The key for the info we are storing
     * @param val The value
     * @return Context The updated context
     */
    public Context addValue(final String key, Object val) {
        this.ctx.put(key, val);
        return this;
    }

    /**
     * Gets a value from the context
     * @param key The key we are looking up
     * @return Object The value from the context of null if there is no value associated
     * with the key
     */
    public Object getValue(final String key) {
        return this.ctx.get(key);
    }

    /**
     * Sets the context
     * @param ctx The context
     */
    public static void setContext(Context ctx) {
        contextThreadLocal.set(ctx);
    }

    /**
     * Gets our current context
     * @return Context The context
     */
    public static Context getContext() {
        return contextThreadLocal.get();
    }

    /**
     * Initializes our context
     */
    public static void initContext() {
        contextThreadLocal.set(new Context());
    }
}
