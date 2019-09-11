package com.ssi;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config=this.getServletConfig();
		String s1=config.getInitParameter("city");
		String s2=config.getInitParameter("state");
		response.getWriter().print(s1+","+s2);
		
		
		
	}

}
