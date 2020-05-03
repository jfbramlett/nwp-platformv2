package com.ninthwave.platform.context;

import java.util.HashMap;
import java.util.Map;

public class Context {
    public static final ThreadLocal<Context> contextThreadLocal = ThreadLocal.withInitial(Context::new);

    private Map<String, Object> ctx = new HashMap<>();

    public Context() {
    }

    public Context addValue(final String key, Object val) {
        this.ctx.put(key, val);
        return this;
    }

    public Object getValue(final String key) {
        return this.ctx.get(key);
    }

    public static void setContext(Context ctx) {
        contextThreadLocal.set(ctx);
    }

    public static Context getContext() {
        return contextThreadLocal.get();
    }

    public static void clearContext() {
        contextThreadLocal.set(new Context());
    }
}
