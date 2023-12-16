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


@WebServlet("/showevents")
public class ShowEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShowEvents() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("");
		
		HttpSession h=request.getSession();
		String uname=(String) h.getAttribute("email");
		String upass=(String) h.getAttribute("pswd");
		
		
		request.getRequestDispatcher("studentNav.html").include(request, response);
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
			}
			
		
out.print("<div style='width: 100%;  text-align: center; padding: 10px;'>");
out.print("<h3 style='color: #333333;'> Hello(Student) " + uname + "</h3><br>");
	    out.print("<h2>Events</h2>");
	    out.print("</div>");
	         
	         ArrayList<Event> eventlist = new UserDao().getEventlist();
	         out.print("<head>");
	     
	      out.print("<style>");
	      out.print(".card-container {");
	      out.print("    display: flex;");
	      out.print("    flex-wrap: wrap;");
	      out.print("}");

	      out.print(".w3-card-4 {");
	      out.print("    width: 30%; /* Adjust the width as needed */");
	      out.print("    margin-bottom: 20px;");
	      out.print("    text-align: center; /* Center the content */");
	      out.print("    padding: 10px;");
	      out.print("    box-sizing: border-box; /* Include padding and border in the element's total width and height */");
	      out.print("}");
	      out.print("</style>");

	     
	      out.print("</head>");
	        
	         out.print("<div class='card-container'>");

	         for (Event e : eventlist) {
	             if (e.getCategory() != null) {
	                 out.print("<div class='w3-card-4'>"); // Use the specified styling for the card container
	                 out.print("<div class='card' style='width:400px'>");
	                 out.print("<img src='./upload/" + e.getImageName() + "' class='card-img-top mx-auto d-block' width='200' height='200' alt='Event Image'>");
	                 out.print("<div class='card-body'>");
	                 out.print("<h4 class='card-title'>" + e.getCategory() + "</h4>");
	                 out.print("<p class='card-text'>" + e.getCatDesc() + "</p>");
	                 out.print("<h5 class='card-title'>" + "Date: " + e.getStartDate() + " to " + e.getEndDate() + "</h5>");
	                 out.print("<h5 class='card-title'>" + "Time: " + e.getStartTime() + " to " + e.getEndTime() + "</h5>");
	                 out.print("<br><a href='bookevent?eventid=" + e.getEventId() + "' class='btn btn-success' style='float: left;'>Join Event</a></h3>");
	                 out.print("</div>");
	                 out.print("</div>");
	                 out.print("</div>");
	             }
	         }

	         out.print("</div>");
	         } catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
