package com.github.io24m.validate4java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:27
 */
public class ValidateConfig {
    public static ValidateConfig Default;

    static {
        Default = new ValidateConfig();
    }

    private boolean enableConfig = false;

    //配置
    private List<ValidateConfig> configs = new ArrayList<>();
    private String configKey;
    private String configName;
    private boolean check;
    private Class clazz;

    public void add() {

    }

}
