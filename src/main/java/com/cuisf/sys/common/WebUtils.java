package com.cuisf.sys.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2020-03-21.
 */
public class WebUtils {


    /**
     * 得到requset
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        return request;
    }


    /**
     * 得到session
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }


}
