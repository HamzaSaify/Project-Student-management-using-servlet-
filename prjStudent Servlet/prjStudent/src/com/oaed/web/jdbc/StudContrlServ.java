package com.oaed.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
@WebServlet("/StudContrlServ")
public class StudContrlServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudDbUtil sDbUtl;
@Resource(name="jdbc/prjStudent")
	private DataSource dtSrc;
@Override
public void init() throws ServletException {
	
	super.init();
	try {
		sDbUtl =new StudDbUtil(dtSrc);
		
	}catch(Exception exc) {
		throw new ServletException(exc);
	}
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//read the command parameter
			String theCmnd=request.getParameter("command");
			//if the command is missing,then the default will be list out
			if(theCmnd == null) {
				theCmnd="List";
			}
			switch(theCmnd) {
			case "List" :
				//list the student in mvc fashion
				listStudents(request,response);
				break;
			
			case "Add":
				addStudent(request,response);
				break;
			case "DELETE":
				deleteStudent(request, response);
				break;	
						
				
			case "UPDATE":
				updateStudent(request,response);
				
				break;
			
			case "LOAD":
				loadStudent(request,response);
			
				
			default:
					listStudents(request,response);
				
			}
		}
		catch(Exception exc) {
			throw new ServletException(exc);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String theStudentId = request.getParameter("studId");

		// delete student from database
		sDbUtl.deleteStudent(theStudentId);
						
		// send them back to "list students" page
		listStudents(request, response);
		
		}
	
	//@SuppressWarnings("unused")
	private void updateStudent(HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		//read student info from the data
		String asID=request.getParameter("sID");
		String asname=request.getParameter("Name");
		String asfname=request.getParameter("fName");
		String asMobile=request.getParameter("Mobile");
		String asAddress=request.getParameter("addr");
		//create a new student object
		
		Student nStud=new Student(asID,asname,asfname,asMobile,asAddress);
		
		sDbUtl.updateStudent(nStud);
		listStudents(request,response);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//@SuppressWarnings("unused")
	private void loadStudent(HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		//read student id from data
		String theStudentId =request.getParameter("studId");
		//string the studnet id =request.getparameter("sid");
		//getStudent from database (dbutil)
		Student theStudent =sDbUtl.getStudent(theStudentId);
		//place student in the request attribute
		request.setAttribute("THE_STUDENT",theStudent );
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void addStudent(HttpServletRequest request, HttpServletResponse response)throws Exception  {
		String asID =request.getParameter("sID");
		String asname =request.getParameter("name");
		String asfname =request.getParameter("fName");
		String asMobile =request.getParameter("mobile");
		String asAddress =request.getParameter("addr");
	
		Student nStud=new Student(asID,asname,asfname,asMobile,asAddress);
		try {
			sDbUtl.addStudent(nStud);
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			listStudents(request,response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	
	
	
	
	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//get student from dbutl
		List<Student> students=sDbUtl.getStudents();
		//add students to the equest
		request.setAttribute("STUDENT_LIST", students);
		//SEND DATA TO JSP PAGE
		RequestDispatcher disp=request.getRequestDispatcher("/list-Student.jsp");
	disp.forward(request, response);
	}
	

}

