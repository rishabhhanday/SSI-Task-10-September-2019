package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class CartManager
 */
@WebServlet("/CartManager")
public class CartManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("code");
		ServletContext context = getServletContext();
		HttpSession session = request.getSession();
		HashMap<String, ArrayList<String>> map;
		ArrayList<String> al = new ArrayList<>();
		map = (HashMap<String, ArrayList<String>>) context.getAttribute("cart");
		if (map == null) {
			map = new HashMap<String, ArrayList<String>>();
			al.add(request.getParameter("code"));
			map.put((String) session.getAttribute("user"), al);
			context.setAttribute("cart", map);

		} else {
			if (map.containsKey((String) session.getAttribute("user"))) {
				al = map.get(session.getAttribute("user"));
				al.add(request.getParameter("code"));
				map.put((String) session.getAttribute("user"), al);
				context.setAttribute("cart", map);
			} else {
				al.add(request.getParameter("code"));
				map.put((String) session.getAttribute("user"), al);
				context.setAttribute("cart", map);
			}
		}

		response.sendRedirect("Cart");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
