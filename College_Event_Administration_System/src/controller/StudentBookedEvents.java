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

import model.Event;
import model.UserDao;
import model.UserStudent;


@WebServlet("/studentbookedevents")
public class StudentBookedEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentBookedEvents() {
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
		
		 ArrayList<Event> bookedevent;
		try {
			bookedevent = new UserDao().getEvent(uname);
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


			       for(Event e: bookedevent){
			    	   if (e.getCategory() != null && e.getCatDesc() != null && e.getStartDate() != null && e.getEndDate() != null
			    	            && e.getStartTime() != null && e.getEndTime() != null) {

					 out.print("<div class='w3-card-4'>"); // Use the specified styling for the card container
	                 out.print("<div class='card' style='width:400px'>");
	                
	                // out.print("<img src='./upload/" + e.getImageName() + "' class='card-img-top mx-auto d-block' width='200' height='200' alt='Event Image'>");
	                 out.print("<div class='card-body'>");
	                 out.print("<h4 class='card-title'>" + e.getCategory() + "</h4>");
	                 out.print("<p class='card-text'>" + e.getCatDesc() + "</p>");
	                 out.print("<h5 class='card-title'>" + "Date: " + e.getStartDate() + " to " + e.getEndDate() + "</h5>");
	                 out.print("<h5 class='card-title'>" + "Time: " + e.getStartTime() + " to " + e.getEndTime() + "</h5>");
	                 out.print("<br><a href='bookevent?eventid=" + e.getEventId() + "' class='btn btn-success' style='float: left;'>Join Event</a></h3>");
	                 out.print("</div>");
	                 out.print("</div>");
	                 out.print("</div>");
			}}
			       out.print("</div>");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Event bookedevent = new UserDao().getEvent(uname);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
