package controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDao;
import model.UserStaff;
import model.UserStudent;


@WebServlet("/studentserv")
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Student() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();	
		request.getRequestDispatcher("adminprofile").include(request, response);
		
		HttpSession h=request.getSession();
		String uname=(String) h.getAttribute("email");
		String upass=(String) h.getAttribute("pswd");
		
		String message = (String) request.getAttribute("message");
		if (message != null) {
		    out.print("<div class='alert alert-success' role='alert'>" + message + "</div>");
		}

		String message3 = (String) request.getAttribute("message3");
		if (message3 != null) {
		    out.print("<div class='alert alert-danger' role='alert'>" + message3 + "</div>");
		}

		
		out.print("<head>");
	    out.print("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css'>");
		out.print("<script src='https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js'></script>");
		out.print("<script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js'></script>");
		out.print("<script src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js'></script>");
        out.print("</head>");
        
        
        
        out.print("<div style='width: 100%;  text-align: center; padding: 10px;'>");
        out.print("<h3>Welcome Admin " + "");
        out.print("<a href='addStudent.html' class='btn btn-success' style='float: right;'>Add New</a></h3>");
        out.print("</div>");
        
        UserStudent s=new UserStudent(request.getParameter("name"), request.getParameter("email"), request.getParameter("course"), request.getParameter("city"), request.getParameter("phoneno"));
        
       // int pId=1;
        int pId=Integer.parseInt(request.getParameter("pId"));
		int total=10;
//		
		if(pId==1){}
		else
		{
			pId=pId-1;				
			pId=pId*total+1; //
		}
		try {
			
			
			ArrayList<UserStudent> stulist = new UserDao().getStudent(pId,total);
out.print("<div style='width: 100%;  text-align: center; padding: 10px;'>");
		    
		    out.print("<h2>Students List</h2>");
		    out.print("</div>");
			out.print("		    <div class='col-12'>");
			out.print("<table class='table table-hover' >");
			out.print("		    <tbody>");
			out.print("		    <thead>");
			out.print("		      <tr>");
			out.print("		        <th class='col-1'>Student ID</th>");
			out.print("		        <th class='col-1'>Name</th>");
			out.print("		        <th class='col-1'>Email</th>");
			out.print("		        <th class='col-2'>Course</th>");
			out.print("		        <th class='col-1'>City</th>");
			out.print("		        <th class='col-2'>Phoneno</th>");
			out.print("		        <th class='col-2'>Action</th>");
			out.print("		      </tr>");
			out.print("		    </thead>");

			for( UserStudent u:stulist){
				 out.print("		      <tr>");
				 System.out.println("getting id");
			    out.print("		        <td>"+u.getStuId()+"</td>");
				 System.out.println("getting name");
			    out.print("		        <td>"+u.getStuName()+"</td>");
				 System.out.println("getting email");
			    out.print("		        <td>"+u.getStuEmail()+"</td>");
				 System.out.println("getting uname");
			    out.print("		        <td>"+u.getStuCourse()+"</td>");
			    out.print("		        <td>"+u.getStuCity()+"</td>");
			    out.print("		        <td>"+u.getStuPhoneno()+"</td>");
				   
			  out.print("<td><a href='editshowstud?id="+u.getStuId()+"' class='btn btn-primary'>Edit</a>  <a href='deletestud?id="+u.getStuId()+"' class='btn btn-danger'>Detele</a> </td></tr>");
			                          
			    out.print("		      </tr>");
			    
			}
			out.print("		    </tbody>");
			
			out.print("		    </table>");
			out.print("		    </div>");
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("<div style='text-align: centre'>");
		out.print("<a href='studentserv?pId=1' >1</a>&emsp;");
		out.print("<a href='studentserv?pId=2'>2</a>&emsp; ");
		out.print("<a href='studentserv?pId=3'>3</a> ");
				out.print("</div>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
