package com.kai.servlet;

import com.kai.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        //得到Session
        HttpSession session = req.getSession();
        //给Session存东西
        //session.setAttribute("name", "好好学习");
        session.setAttribute("person",new Person("好好学习",20));
        //获取Session的ID
        String id = session.getId();

        //判断Session是不是新创建的
        if (session.isNew()) {
            out.write("Session创建成功,ID为:" + id);
        } else {
            out.write("Session已经存在,ID为:" + id);
        }
        //Session创建时做了什么事情
//        Cookie jsessionid = new Cookie("JSESSIONID", id);
//        resp.addCookie(jsessionid);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
