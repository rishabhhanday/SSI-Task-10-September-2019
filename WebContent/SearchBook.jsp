<%@page import="com.ssi.BookDetailsServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% 
    com.ssi.Test t = new com.ssi.Test(application);
    java.sql.Connection con = t.getData();
    String sql = "select subject from books";
    java.sql.PreparedStatement st =con.prepareStatement(sql);
    java.sql.ResultSet rs = st.executeQuery();
	    
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Select The Desired Subject</h3>
<hr>
			<form action="BookListServlet">
			<% 
				while(rs.next()){
               %>
<input type="checkbox" name="books" value=<%=rs.getString(1)%>><%=rs.getString(1)%>



				<%
				}
				%>
				<input type="submit" value="Search Books">
			</form>
</body>
</html>