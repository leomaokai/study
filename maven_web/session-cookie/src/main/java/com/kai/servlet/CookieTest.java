package com.kai.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        //保存用户上一次访问的时间

        PrintWriter out = resp.getWriter();
        //Cookie,服务器从客户端获取
        Cookie[] cookies = req.getCookies();//返回数组,cookie可能存在多个

        boolean flag = false;//标记是否访问过
        for (Cookie cookie : cookies) {
            //判断设置的时间cookie是否存在
            //获取cookie的名字
            if (cookie.getName().equals("lastLoginTime")) {
                flag = true;
                out.write("你上一次访问的时间是:");
                //获取cookie中的值,将cookie值转为时间戳
                long l = Long.parseLong(cookie.getValue());
                Date date = new Date(l);
                out.print(date.toLocaleString());
            }
        }
        //如果没有访问过
        if(!flag)
            out.print("这是你第一次访问");

        //服务器给客户端响应一个cookie
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis() + "");
        //设置cookie有效期
        cookie.setMaxAge(100);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
