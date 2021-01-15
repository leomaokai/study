package com.kai.Filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    @Override
    //初始化
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("initok");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");

        //filterChain过滤器链
        /*
        * 1.过滤器中的所有代码,在过滤特定请求的时候都会执行
        * 2.必须要让过滤器继续通行
        * */
        System.out.println("CharacterEncodingFilter执行前");
        //让我们的请求继续走,如果不写,程序将被拦截
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("CharacterEncodingFilter执行后");
    }

    @Override
    //销毁
    public void destroy() {
        System.out.println("destroyok");
    }
}
