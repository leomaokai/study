package com.kai.Listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//统计网站在线人数:统计Session
public class OnlineCountListener implements HttpSessionListener {
    @Override
    //创建Session监听
    //一旦创建Session就会触发这个事件
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();

        System.out.println(httpSessionEvent.getSession().getId());

        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");


        if (onlineCount == null) {
            onlineCount = new Integer(1);
        } else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count + 1);
        }
        servletContext.setAttribute("OnlineCount", onlineCount);
    }

    @Override
    //销毁Session监听
    //一旦销毁Session就会触发这个事件
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");


        if (onlineCount == null) {
            onlineCount = new Integer(0);
        } else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count - 1);
        }
        servletContext.setAttribute("OnlineCount", onlineCount);


    }
}
