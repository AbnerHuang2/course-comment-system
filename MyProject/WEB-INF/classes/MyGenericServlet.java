package com.huang;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class MyGenericServlet extends GenericServlet{
	
	public void service(ServletRequest request, ServletResponse
             response) throws ServletException, IOException{
		String s = "<h1>son of a bitch</h1>";
		response.getWriter().println(s);
		response.getWriter().println("<br>用户名：<input type=\'text\'  name=\'user\'>");
	}

}