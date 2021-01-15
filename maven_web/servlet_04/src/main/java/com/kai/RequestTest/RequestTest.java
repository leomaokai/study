package com.kai.RequestTest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String[] parameterValues = req.getParameterValues("hobby");

        for (String parameterValue : parameterValues) {
            resp.getWriter().print(parameterValue);
        }
        resp.setHeader("refresh","3;URL=success.jsp");

        //通过请求转发
        //req.getRequestDispatcher("/servlet_04-01/success.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
