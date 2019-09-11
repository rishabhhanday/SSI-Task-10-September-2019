package com.ssi;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;

public class Test {
	ServletContext context;
	Test(ServletContext context){
		this.context = context;
	}
	
	public Connection getData() throws Exception {


		Class.forName(context.getInitParameter("drivername"));
		Connection con = DriverManager.getConnection(context.getInitParameter("connection"),context.getInitParameter("dbid"),context.getInitParameter("dbpassword"));
		return con;
	}

}
