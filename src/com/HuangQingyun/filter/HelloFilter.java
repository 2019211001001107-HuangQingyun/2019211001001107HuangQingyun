package com.HuangQingyun.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "HelloFilter")
//2 way of mapping filter to servlet
//1 - use web.xml
//2 - use WebFilter
public class HelloFilter implements Filter {
    public void destroy() {
        System.out.println("i am in HelloFilter-->destroy()");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in HelloFilter-->doFilter()- before servlet-(request come here)");//when called?
        chain.doFilter(req, resp);// call next filter - if no next filter - then go to servlet
        //response after servlet come back here
        System.out.println("i am in HelloFilter-->doFilter()- AFTER servlet (response come here)");//when called?
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in HelloFilter-->init()");

    }

}
