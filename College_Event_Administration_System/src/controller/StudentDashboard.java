package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDao;
import model.UserStaff;
import model.UserStudent;

@WebServlet("/studentdashboard")
public class StudentDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentDashboard() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
	    request.getRequestDispatcher("studentNav.html").include(request, response);
	
	
		HttpSession h=request.getSession();
		String email=(String) h.getAttribute("email");
		String upass=(String) h.getAttribute("pswd");
		
		out.print("<head>");
	    out.print("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css'>");
		out.print("<script src='https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js'></script>");
		out.print("<script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js'></script>");
		out.print("<script src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js'></script>");
        out.print("</head>");
        
        
		//UserStaff u=new UserStaff(request.getParameter("name"), request.getParameter("email"), request.getParameter("designation"), request.getParameter("city"), request.getParameter("phoneno"));
//		int sId, String sname, String semail, String sdesignation, String scity, String sphoneno)
		try {
			UserStudent u=new UserDao().getStudentInfo(email);
			out.print("<br><br>");
			out.print("<div style='width: 50%; margin: 0 auto; background-color: #ffcccc; padding: 20px; border-radius: 10px;'>");
			out.print("<div style='margin-right: 70px; margin-left: 70px; padding: 10px; background-color: #ffffff; border-radius: 5px;'>");
			out.print("<h3 style='color: #333333;'> Welcome(Student) " + u.getStuName() + "</h3><br>");
			out.print("<h5>Employee ID: " + u.getStuId() + "</h5>");
			out.print("<h5>Name: " + u.getStuName()+ "</h5>");
			out.print("<h5>Email: " + u.getStuEmail()+ "</h5>");
			out.print("<h5>City: " + u.getStuCity()+ "</h5>");
			out.print("<h5>Course: " + u.getStuCourse() + "</h5>");
			out.print("<h5>Phone number: " + u.getStuPhoneno() + "</h5>");
			out.print("</div>");
			out.print("</div>");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
