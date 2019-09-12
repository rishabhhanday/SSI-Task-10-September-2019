package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String subject=request.getParameter("subject");
		PrintWriter out=response.getWriter();
		try{
//	
		
		out.println("<html>");
		out.println("<html><body>");
		out.println("<h3>Select The Desired Title</h3>");
		out.println("<hr>");
		Connection con = new Test(request.getServletContext()).getData();
		String sql = "select * from books where subject=?";
		String str[] = request.getParameterValues("books");
		PreparedStatement st =con.prepareStatement(sql);
		for(String s :str){
			st.setString(1,s);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
			response.getWriter().println("<a href=BookDetailsServlet?code="+rs.getString(1)+">");
			response.getWriter().println(rs.getString(2));
			response.getWriter().println("</a>");
			response.getWriter().println("<br>");
			
			}
			
		}
		out.println("<hr>");
		out.println("<a href=SubjectPageServlet>Subject-Page</a>");
		out.println("<a href=buyerpage.jsp>Buyer-Page</a>");
		out.println("</body></html>");
		
		
		
		
		}catch(Exception e){
			out.println(e);
		}
	}
}
