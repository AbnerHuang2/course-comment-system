package com.huang;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class MyFirstServlet implements Servlet{
	
	 public void init(ServletConfig config) throws ServletException{
		 System.out.println("init succeed !");
	 }
	 
	 public ServletConfig getServletConfig(){
		 return null;
	 }
	 
	 public void service(ServletRequest request, ServletResponse response)
		throws ServletException, IOException{
			System.out.println("hello,world "+new java.util.Date());
			System.out.println(request.getContentLength());
			response.getWriter().println("hello world");
		}

	 public String getServletInfo()
	 {
		 return null;
	 }
	 
	 public void destroy()
	 {
		 
	 }
	 
}