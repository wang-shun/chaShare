package com.holley.charging.intercepter;

import org.apache.log4j.Logger;

import com.holley.common.util.StringUtil;
import com.opensymphony.xwork2.ActionInvocation;

public class JsonActionInterceptor extends BaseInterceptor {

    private static final long   serialVersionUID = 1008901298342362080L;
    private static final Logger log              = Logger.getLogger(JsonActionInterceptor.class);

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        String actionName = invocation.getInvocationContext().getName();
        String className = invocation.getAction().getClass().getName();
        String servletPath = getServletPath();
        log.info("JsonInfo>>>>>>>>>>");
        log.info("className:" + className);
        log.info("actionName:" + actionName);
        log.info("servletPath:" + servletPath);
        if (!StringUtil.isEmpty(servletPath)) {
            getRequest().setAttribute("actionName", servletPath.substring(1, servletPath.length()));
            getRequest().setAttribute("action", actionName);
        }
        String result = null;
        try {
            result = invocation.invoke();
        } catch (Exception e) {
            log.error(e);
            log.error("Exception className :" + className);
            log.error("Exception methodName:" + actionName);
            log.error("Exception message   :", e);
        }
        return result;
    }

}
