package com.huang;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class MyHttpServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, 
             HttpServletResponse response) throws ServletException,
             IOException{
		response.getWriter().println("doGet()");
		
	}
	protected void doPost(HttpServletRequest request,
             HttpServletResponse response) throws ServletException,
             IOException{
		request.setCharacterEncoding("utf-8");
		response.getWriter().println("doPost()");
		response.getWriter().println(request.getParameter("username"));		
		
	}

	
}