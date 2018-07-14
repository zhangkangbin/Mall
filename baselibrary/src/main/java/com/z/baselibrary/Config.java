package com.z.baselibrary;

/**
 * Created by zhangkb on 2017/12/22 0022.
 */

public class Config {

    private Config() {

    }

    private boolean isDebug = true;
    private static Config config;
    public static Config getConfig() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }
    public boolean isDebug() {
        return isDebug;
    }
    public void setDebug(boolean debug) {
        isDebug = debug;
    }

}
