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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SubjectPageServlet
 */
@WebServlet("/SubjectPageServlet")
public class SubjectPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//reading the userid from session
		//fetch the session
		HttpSession session=request.getSession();
		//read the data from session
		String user=(String)session.getAttribute("user");
		
		
		if(user==null){
			response.sendRedirect("index.jsp");
		}
		
		PrintWriter out=response.getWriter();
		try{
		
		Connection con=new Test(request.getServletContext()).getData();
		String sql="SELECT distinct subject from books";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		out.println("<html>");
		out.println("<html><body>");
		out.println("<marquee><h4>Attractive Offers On All Books</h4></marquee>");
		out.println("<h3>Welcome "+user+"</h3>");
		out.println("<h3>Select The Desired Subject</h3>");
		out.println("<hr>");
		while(rs.next()){
			String sub=rs.getString(1);
			out.println("<a href=BookListServlet?subject="+sub+">");
			out.println(sub);
			out.println("</a><br>");
		}
		out.println("<hr>");
		out.println("<a href=buyerpage.jsp>Buyer-Page</a>");
		out.println("</body></html>");
		
		
		
		
		}catch(Exception e){
			out.println(e);
		}
	}

}
