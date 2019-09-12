<%@page import="java.sql.ResultSet"%>
<%@page import="com.ssi.Test"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Test t = new Test(application);
	java.sql.Connection con = t.getData();
	String sql = "select * from users where userid = ?";
	java.sql.PreparedStatement st = con.prepareStatement(sql);
	st.setString(1, (String) session.getAttribute("user"));
	ResultSet rs = st.executeQuery();
	rs.next();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateProfile">
	Userid     <input type="text" name="uid" value=<%=rs.getString(1)%>>
	Userpassword <input type="text" name="upassword" value=<%=rs.getString(2)%>>
	Username         <input type="text" name="uname" value=<%=rs.getString(3)%>>
	Usermobile         <input type="text" name="umobile" value=<%=rs.getString(4)%>>
	<input type="submit" value="Update profile">
	</form>
</body> 
</html>