package com.HuangQingyun.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(filterName = "HelloFilter",urlPatterns = {"/hello"})
public class HelloFilter implements Filter {
    public void destroy() {
        System.out.println("i am in HelloFilter-->destroy()");//when called?
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //request come here - before go to servlet - doGet() or doPost()
        System.out.println("i am in HelloFilter-->doFilter()- before servlet-(request come here)");//when called?
        chain.doFilter(request, response);// call next filter - if no next filter - then go to servlet
        //response after servlet come back here
        System.out.println("i am in HelloFilter-->doFilter()- AFTER servlet (response come here)");//when called?
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in HelloFilter-->init()");//when called?

    }

}
