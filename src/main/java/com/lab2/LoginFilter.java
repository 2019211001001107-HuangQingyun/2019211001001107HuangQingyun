package com.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
        System.out.println("i am in LoginFilter-->destroy()");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in LoginFilter--doFilter()-- request before chain");
        chain.doFilter(request, response);
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse)response;

        if(req.getSession(false).isNew()){
            req.getRequestDispatcher("/lab2/welcome.jsp").forward(req,res);

        }else {
            res.sendRedirect(req.getContextPath()+"/lab2/login.jsp");
        }

        System.out.println("i am in LoginFilter--doFilter()-- request after chain");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in LoginFilter-->init()");
    }

}
