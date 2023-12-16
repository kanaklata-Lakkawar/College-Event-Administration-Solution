package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Event;
import model.UserDao;
import model.UserStudent;


@WebServlet("/eventserv")
public class EventServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EventServ() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("");
		
		HttpSession h=request.getSession();
		String uname=(String) h.getAttribute("email");
		String upass=(String) h.getAttribute("pswd");
		try {
			String role=new UserDao().checkUser(uname, upass);
			if(role.equals("Admin")){
				request.getRequestDispatcher("adminprofile").include(request, response);
			}
			
			if(role.equals("Staff")){
				request.getRequestDispatcher("staffNav.html").include(request, response);
			}
			
			 String category=request.getParameter("category");
			 String catDesc = request.getParameter("categoryDescription");
			 String startDateString = request.getParameter("startDate");
			 String endDateString = request.getParameter("endDate");
			 String startTimeString =request.getParameter("startTime");
		     String endTimeString =request.getParameter("endTime");
			 
			 
			Event ev=new Event( category,catDesc,startDateString,endDateString, startTimeString, endTimeString);
			try {
				UserDao db=new UserDao();
				
				if (category!=null){
				int eventadded=db.addEvent(ev);
				HttpSession event=request.getSession();
				event.setAttribute("category", category);
				
				request.getRequestDispatcher("AddImage.html").forward(request, response);
				}
		
				out.print("<head>");
			    out.print("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css'>");
			    out.print("<script src='https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js'></script>");
				out.print("<script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js'></script>");
				out.print("<script src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js'></script>");
			    out.print("</head>");
			    out.print("<div style='width: 100%;  text-align: center; padding: 10px;'>");
			    
			    out.print("<a href='addeventserv' class='btn btn-success' style='float: right;'>Add New</a></h3><br>");
			    out.print("</div>");
		         
	out.print("<div style='width: 100%;  text-align: center; padding: 10px;'>");
			    
			    out.print("<h2>Events</h2>");
			    out.print("</div>");
			    
		         ArrayList<Event> eventlist = new UserDao().getEventlist();
		         out.print("		    <div class='col-12'>");
				 out.print("<table class='table table-hover' >");
			    	out.print("		    <tbody>");
					out.print("		    <thead>");
					out.print("		      <tr>");
					
					out.print("		        <th class='col-2'>Name</th>");
					out.print("		        <th class='col-2'>Description</th>");
					out.print("		        <th class='col-1'>Stat Date</th>");
					out.print("		        <th class='col-1'>End Date</th>");
					out.print("		        <th class='col-1'>Start Time</th>");
					out.print("		        <th class='col-1'>End Time</th>");
					out.print("		        <th class='col-2'>Action</th>");
					out.print("		      </tr>");
					out.print("		    </thead>");
		         for(Event e: eventlist){

		        	 out.print("		      <tr>");
					 System.out.println("getting id");
				    out.print("		        <td>"+e.getCategory()+"</td>");
					 System.out.println("getting name");
				    out.print("		        <td>"+e.getCatDesc()+"</td>");
					 System.out.println("getting email");
				    out.print("		        <td>"+e.getStartDate()+"</td>");
					 System.out.println("getting uname");
				    out.print("		        <td>"+e.getEndDate()+"</td>");
				    out.print("		        <td>"+e.getStartTime()+"</td>");
				    out.print("		        <td>"+e.getEndTime()+"</td>");
					   
				  out.print("<td><a href='cancelevent?eventid="+e.getEventId()+"' class='btn btn-danger'>Cancel Event</a>  </tr>");
				                          
				    out.print("		      </tr>"); 
		         }	         
		            out.print("		    </tbody>");
					out.print("		    </table>");
					out.print("		    </div>");
			} catch (ClassNotFoundException e1) {
				
				e1.printStackTrace();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}

		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
