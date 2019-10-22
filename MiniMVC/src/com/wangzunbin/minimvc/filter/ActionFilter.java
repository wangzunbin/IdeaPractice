package com.wangzunbin.minimvc.filter;

import com.wangzunbin.minimvc.action.DepartmentAction;
import com.wangzunbin.minimvc.action.EmployeeAction;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:ActionFilter  <br/>
 * Funtion: ${TODD} <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/10/22 11:10   <br/>
 */
public class ActionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        String requestUri = req.getRequestURI().substring(1);
        if("employee".equals(requestUri)) {
            EmployeeAction action = new EmployeeAction();
            action.execute();
        } else if("department".equals(requestUri)) {
            DepartmentAction action = new DepartmentAction();
            action.execute();
        }
    }

    @Override
    public void destroy() {

    }
}
