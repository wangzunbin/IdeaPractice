package com.wangzunbin.core.web;

/**
 * ClassName:ActionConfig  <br/>
 * Funtion: ${TODD} <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/10/22 16:06   <br/>
 */

public class ActionConfig {

    private String name;
    private String className;
    private String method;

    public ActionConfig(String name, String className, String method) {
        this.name = name;
        this.className = className;
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public String getMethod() {
        return method;
    }

    @Override
    public String toString() {
        return "ActionConfig{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
