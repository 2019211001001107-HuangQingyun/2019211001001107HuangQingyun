package com.HuangQingyun.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "LoggerFilter")
public class LoggerFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in LoggerFilter-->doFilter()- before servlet-(request come here)");//when called?
        //request blocked after this filter
        chain.doFilter(req, resp);// call next filter - if no next filter - then go to servlet
        //response after servlet come back here
        System.out.println("i am in LoggerFilter-->doFilter()- AFTER servlet (response come here)");//when called?
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
