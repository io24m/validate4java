package com.github.io24m.validate4java.validate.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:27
 */
public class ValidateConfig {
    public static ValidateConfig Default = new ValidateConfig();

    private Map<String, Object> config = new HashMap<>();

    public void add(String configKey, Object obj) {
        this.config.put(configKey, obj);
    }

    public Object get(String configKey) {
        return config.get(configKey);
    }
}
