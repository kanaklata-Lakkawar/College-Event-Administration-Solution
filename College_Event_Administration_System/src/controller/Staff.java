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


@WebServlet("/staffserv")
public class Staff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Staff() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession h=request.getSession();
		String uname=(String) h.getAttribute("email");
		String upass=(String) h.getAttribute("pswd");
		
		request.getRequestDispatcher("adminprofile").include(request, response);
		
		out.print("<head>");
	    out.print("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css'>");
		out.print("<script src='https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js'></script>");
		out.print("<script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js'></script>");
		out.print("<script src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js'></script>");
        out.print("</head>");
        
        out.print("<div style='width: 100%;  text-align: center; padding: 10px;'>");
        out.print("<h3>Welcome Admin " + "");
        out.print("<a href='addstaff.html' class='btn btn-success' style='float: right;'>Add New</a></h3>");
        out.print("</div>");
        
        
        String message = (String) request.getAttribute("message");
		if (message != null) {
		    out.print("<div class='alert alert-success' role='alert'>" + message + "</div>");
		}
        
        String message2 = (String) request.getAttribute("message2");
		if (message2 != null) {
		    out.print("<div class='alert alert-danger' role='alert'>" + message2 + "</div>");
		}
        
         UserStaff s=new UserStaff(request.getParameter("name"), request.getParameter("email"), request.getParameter("designation"), request.getParameter("city"), request.getParameter("phoneno"));
        
         ArrayList<UserStaff> stafflist;
         int pId=Integer.parseInt(request.getParameter("spId"));
       
 		int total=10;
// 		
 		if(pId==1){}
 		else
 		{
 			pId=pId-1;				
 			pId=pId*total+1; //
 		}
		try {
			stafflist = new UserDao().getStaff(pId,total);
out.print("<div style='width: 100%;  text-align: center; padding: 10px;'>");
		    
		    out.print("<h2>Staff List</h2>");
		    out.print("</div>");
			out.print("		    <div class='col-12'>");
			out.print("<table class='table table-hover' >");
			out.print("		    <tbody>");
			out.print("		    <thead>");
			out.print("		      <tr>");
			out.print("		        <th class='col-1'>Staff ID</th>");
			out.print("		        <th class='col-1'>Name</th>");
			out.print("		        <th class='col-1'>Email</th>");
			out.print("		        <th class='col-2'>Designation</th>");
			out.print("		        <th class='col-1'>City</th>");
			out.print("		        <th class='col-2'>Phoneno</th>");
			out.print("		        <th class='col-2'>Action</th>");
			out.print("		      </tr>");
			out.print("		    </thead>");

			for( UserStaff us:stafflist){
				 out.print("		      <tr>");
				 System.out.println("getting id");
			    out.print("		        <td>"+us.getsId()+"</td>");
				 System.out.println("getting name");
			    out.print("		        <td>"+us.getSname()+"</td>");
				 System.out.println("getting email");
			    out.print("		        <td>"+us.getSemail()+"</td>");
				 System.out.println("getting uname");
			    out.print("		        <td>"+us.getSdesignation()+"</td>");
			    out.print("		        <td>"+us.getScity()+"</td>");
			    out.print("		        <td>"+us.getSphoneno()+"</td>");
//				    out.print("		        <td class='btn btn-danger' style='margin-right: 100px; width: 100px'><a href='editshowserv?id='>Detele</a></td>");
			  out.print("<td><a href='editshowserv?id="+us.getsId()+"' class='btn btn-primary'>Edit</a>  <a href='deleteserv?id="+us.getsId()+"' class='btn btn-danger'>Detele</a> </td></tr>");
//				    out.print("		        <td class='btn btn-primary' style='width: 100px'>Edit</a></td>");
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
		out.print("<a href='staffserv?spId=1'>1</a>&emsp;");
		out.print("<a href='staffserv?spId=2'>2</a>&emsp; ");
		out.print("<a href='staffserv?spId=3'>3</a> ");
		
        
        

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
