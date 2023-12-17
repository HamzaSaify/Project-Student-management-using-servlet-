package com.oaed.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudDbUtil {
	private DataSource dSrc;
	public StudDbUtil(DataSource dSrc01) {
		dSrc=dSrc01;
	}		
	
	public List<Student> getStudents() throws Exception{
		List<Student> students = new ArrayList<>();
		Connection myCon=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
		try {
			//0.1get a connection
			myCon=dSrc.getConnection();
			//02. create sql statement
			String sql="select * from students order by Name";
			myStmt=myCon.createStatement();
			//03.execute a query
			myRs=myStmt.executeQuery(sql);
			//04 process result set
			//rs01 retrieve data from result set row
		
			while(myRs.next()) {
			String sID=myRs.getString("studId");
			String sName=myRs.getString("Name");
			String fName=myRs.getString("fName");
			String sMobile=myRs.getString("Mobile");
			String sAddress=myRs.getString("Address");
			
			//rs02 create new student object
			
			Student tStud=new Student(sID,sName,fName,sMobile,sAddress);
			//rs03.add it to the list of students
			students.add(tStud);
			
			}
			//05.close jdbc,
			return students;
			
		}//try}
		finally {
			close(myCon,myStmt,myRs);
		}//finally
		}
	private void close(Connection myCon, Statement myStmt, ResultSet myRs) {
		try {
			if(myRs != null) {
				myRs.close();
			}
			if(myStmt !=null) {
				myStmt.close();
			}
			if(myCon !=null) {
				myCon.close();
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}//close
	
	public void updateStudent(Student theStudent) throws Exception{
		Connection myConn=null;
		PreparedStatement myStmt=null;
		try {
			myConn=dSrc.getConnection();
			String sql="update students "
					+ "set Name=?, fName=?, Mobile=?, Address=? "
					+ "where studId=?";					
		
		myStmt=myConn.prepareStatement(sql);
		
		myStmt.setString(1, theStudent.getsName());
		myStmt.setString(2, theStudent.getfName());
		myStmt.setString(3, theStudent.getsMobile());
		myStmt.setString(4, theStudent.getsAddress());
		myStmt.setString(5, theStudent.getStudID());

		myStmt.execute();
			}finally {
				close(myConn,myStmt,null);
			}
	}
	
	
	
	
	
	
	
	
	
	
	public void addStudent(Student Stud) throws Exception {
		Connection myCon=null;
		PreparedStatement myStmt= null;
		try {
			//get db connection
			myCon=dSrc.getConnection();
			//create a sql
			String sql= "insert into students "
			+ "(studId, Name, fName, Mobile, Address) "
			+ "values (?, ?, ?, ?, ?)";
			
			myStmt=myCon.prepareStatement(sql);
			
			myStmt.setString(1, Stud.getStudID());
			myStmt.setString(2, Stud.getsName());
			myStmt.setString(3, Stud.getfName());
			myStmt.setString(4, Stud.getsMobile());
			myStmt.setString(5, Stud.getsAddress());
			
			//execute sql insert
			myStmt.execute();
		
			}catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				close(myCon,myStmt,null);
			}
		
	}

	public void deleteStudent(String theStudentId) throws Exception {

		Connection myCon = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			//int studentId = Integer.parseInt(theStudentId);
			
			//String studentId = theStudentId;
			
			// get connection to database
			myCon = dSrc.getConnection();
			
			// create sql to delete student
			String sql = "delete from students where studId= ?";
			
			// prepare statement
			myStmt = myCon.prepareStatement(sql);
			
			// set params
			 
			myStmt.setString(1, theStudentId);  
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myCon, myStmt, null);
		}	
	}

	public Student getStudent(String theStudentId)throws Exception {
		
		Student theStudent=null;
		Connection myCon=null;
		PreparedStatement myStmt=null;
		ResultSet myRs=null;
		//@SuppressWarnings("unused")
		int studentId;
		try {
			myCon=dSrc.getConnection();
			String sql="select * from students where studId=?";
			myStmt=myCon.prepareStatement(sql);
			myStmt.setString(1, theStudentId);
			myRs=myStmt.executeQuery();
			if(myRs.next()) {
				String sID=myRs.getString("studId");
				String sName=myRs.getString("Name");
				String fName=myRs.getString("fName");
				String sMobile=myRs.getString("Mobile");
				String sAddress=myRs.getString("Address");
				theStudent = new Student(sID,sName,fName,sMobile,sAddress);
			}
			else {
				throw new Exception("could not find studnet id" + theStudentId);
			}return theStudent;
			
		}finally {
			close(myCon,myStmt,myRs);
		}
	}}
		
		
		
		
		
		