package com.wangzunbin.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:ActionContext  <br/>
 * Funtion: 封装了请求和响应的对象 <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/10/22 17:20   <br/>
 */

public class ActionContext {

    private HttpServletRequest request;
    private HttpServletResponse response;

    public ActionContext(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    private static ThreadLocal<ActionContext> actionContextThreadLocal = new ThreadLocal<>();



    public static void setContext(ActionContext context){
        actionContextThreadLocal.set(context);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ActionContext getContext() {
        return actionContextThreadLocal.get();
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }
}
