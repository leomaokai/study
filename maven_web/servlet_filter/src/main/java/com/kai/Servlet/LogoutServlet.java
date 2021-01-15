package com.kai.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object user_session = req.getSession().getAttribute("USER_SESSION");
        if(user_session!=null){
            req.getSession().removeAttribute("USER_SESSION");
            resp.sendRedirect("/servlet_filter_war/login.jsp");
        }else {
            resp.sendRedirect("/servlet_filter_war/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
