package com.oaed.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Resource(name="jdbc/prjStudent")
   private DataSource datasource;
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter() ;
		response.setContentType("text/plain");
	//get the connection to the database
		Connection myCon=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		try {
			myCon=datasource.getConnection();
			//create a sql statement
			String sql="Select * from Student";
			myStmt =myCon.createStatement();
			//execute sql query
			myRs=myStmt.executeQuery(sql);
			//process the resultset
			while(myRs.next()) {
				String Name=myRs.getString("name");
				out.println(Name);
			}
		}//try
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
