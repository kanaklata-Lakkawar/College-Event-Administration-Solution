package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BookedEvent;
import model.CombinedData;
import model.Event;
import model.UserDao;
import model.UserStudent;


@WebServlet("/adminbookedevents")
public class AdminBookedEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminBookedEvents() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("");
		
		HttpSession h=request.getSession();
		String uname=(String) h.getAttribute("email");
		String upass=(String) h.getAttribute("pswd");
		
		out.print("			<head>");


		out.print("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css'>");
		out.print("			  <script src='https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js'></script>");
		out.print("			  <script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js'></script>");
		out.print("			  <script src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js'></script>");

		out.print("			</head>");
		
		request.getRequestDispatcher("adminprofile").include(request, response);
		
		try {
			HashSet<UserStudent> booked=new UserDao().bookEventStudents();
		
			HashSet<BookedEvent> details=new UserDao().bookEventsDetails(uname);
			
			HashSet<CombinedData> combinedDataList = new HashSet<>();

			for (UserStudent userStudent : booked) {
			    for (BookedEvent bookedEvent : details) {
			        if (userStudent.getStuEmail().equals(bookedEvent.getstu_mail())) {
			            CombinedData combinedData = new CombinedData(
			                userStudent.getStuId(),
			                userStudent.getStuName(),
			                userStudent.getStuCourse(),
			                bookedEvent.getCategory(),
			                bookedEvent.getCatDesc(),
			                bookedEvent.getStartDate(),
			                bookedEvent.getEndDate()
			            );
			            combinedDataList.add(combinedData);
			        }
			    }
			}
out.print("<div style='width: 100%;  text-align: center; padding: 10px;'>");
		    
		    out.print("<h2>Events Booked</h2>");
		    out.print("</div>");
			out.print("<table class='table table-hover' >");
			out.print("<tbody>");
			out.print("<thead>");
			out.print("<tr>");
			out.print("<th>Student ID</th>");
			out.print("<th>Student Name</th>");
			out.print("<th>Course</th>");
			out.print("<th>Event Description</th>");
			out.print("<th>Event Category</th>");
			out.print("<th>Start Date</th>>");
			out.print("<th>End Date</th>");
			out.print("<tr>");
			out.print("</thead>");
			
			for (CombinedData combinedData : combinedDataList) {
			    out.print("<tr>");
			    out.print("<td>" + combinedData.getStudentId() + "</td>");
			    out.print("<td>" + combinedData.getStudentName() + "</td>");
			    out.print("<td>" + combinedData.getCourse() + "</td>");
			    out.print("<td>" + combinedData.getEventDescription()  +"</td>");
			    out.print("<td>" +combinedData.getEventCategory()  + "</td>");
			    out.print("<td>" + combinedData.getStartDate() + "</td>");
			    out.print("<td>" + combinedData.getEndDate() + "</td>");
			    out.print("</tr>");
			}

			out.print("</table>");

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
