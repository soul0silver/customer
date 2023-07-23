package com.customer.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class MyFilter implements Filter{



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;
        String path=req.getServletPath();
        if (!path.equals("/user") && !path.equals("sign")){
            HttpSession session=req.getSession();
            String username=(String) session.getAttribute("username-ss");
            if (username==null||username=="") request=new HttpServletRequestWrapper(req){
                @Override
                public String getRequestURI(){
                    return "/user";
                }
            };
        }
        chain.doFilter(request,response);

    }


}
