package com.wangzunbin.core.web.filter;

import com.wangzunbin.core.web.ActionConfig;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:ActionFilter  <br/>
 * Funtion: ${TODD} <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/10/22 11:10   <br/>
 */
public class ActionFilter implements Filter {

    private Map<String, ActionConfig> actionConfigMap = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Document doc = this.getDocument();
        NodeList nodeList = doc.getElementsByTagName("action");
        for(int i = 0; i < nodeList.getLength(); i++) {
            Element actionEl = (Element)nodeList.item(i);
            String name = actionEl.getAttribute("name");
            String className = actionEl.getAttribute("class");
            String method = actionEl.getAttribute("method");
            ActionConfig actionConfig = new ActionConfig(name, className, method);
            actionConfigMap.put(name, actionConfig);
        }
        System.out.println(actionConfigMap);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        String requestUri = req.getRequestURI().substring(1);
        /************  第一版 start  ************/
//        if("employee".equals(requestUri)) {
//            EmployeeAction action = new EmployeeAction();
//            action.execute();
//        } else if("department".equals(requestUri)) {
//            DepartmentAction action = new DepartmentAction();
//            action.execute();
//        }
        /************  第二版  end  ************/
        ActionConfig actionConfig = actionConfigMap.get(requestUri);
        String className = actionConfig.getClassName(); // 获取action类的全限定名
        String method = actionConfig.getMethod(); // 获取action类的方法
        try {
            Class actionClass = Class.forName(className);
            Object actionObject = actionClass.newInstance();
            Method method1 = actionClass.getMethod(method); // 获取请求方法的对象
            method1.invoke(actionObject);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {

    }

    private Document getDocument(){
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("actions.xml");
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
