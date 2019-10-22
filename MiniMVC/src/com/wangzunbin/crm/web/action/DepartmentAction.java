package com.wangzunbin.crm.web.action;

import com.wangzunbin.core.web.ActionContext;

/**
 * ClassName:DepartmentAction  <br/>
 * Funtion: ${TODD} <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/10/22 11:06   <br/>
 */
public class DepartmentAction {

    public void execute(){
        System.out.println(".....department......" + ActionContext.getContext().getRequest().getParameter("name"));
    }
}
