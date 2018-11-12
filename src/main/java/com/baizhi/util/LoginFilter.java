package com.baizhi.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest  servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Object login = session.getAttribute("login");
        if(login!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            response.sendRedirect("/cmfz_zg/back/login.jsp");
        }

    }

    @Override
    public void destroy() {

    }
}
