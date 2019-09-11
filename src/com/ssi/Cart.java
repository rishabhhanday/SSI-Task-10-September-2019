package com.ssi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int i=0;
			ServletContext context = getServletContext();
			HashMap<String, ArrayList<String>> map = (HashMap<String, ArrayList<String>>) context.getAttribute("cart");
			HttpSession session = request.getSession();
			ArrayList<String> al = (ArrayList<String>) map.get((String) session.getAttribute("user"));
			Connection con = new Test(request.getServletContext()).getData();
			for (String s : al) {
				
				String sql = "select * from books where bcode=?";
				PreparedStatement st =con.prepareStatement(sql);
				st.setString(1,s);
				ResultSet rs =st.executeQuery();
				if(rs.next()){
					response.getWriter().println("Sr. no :" +(i+1)+"Bcode :"+rs.getString(1)+" btitle :"+rs.getString(2)+" Author :"+rs.getString(3)+" subject :"+rs.getString(4)+" Price :"+rs.getString(5));
					response.getWriter().println("<a href='RemoveCart?indexNo="+i+"'>Remove Above item from cart</a>");
					i++;
				}
			}
		} catch (Exception ex) {
ex.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
