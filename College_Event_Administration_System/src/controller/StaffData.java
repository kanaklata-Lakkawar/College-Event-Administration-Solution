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


@WebServlet("/staffdataserv")
public class StaffData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public StaffData() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession h=request.getSession();
		String uname=(String) h.getAttribute("email");
		String upass=(String) h.getAttribute("pswd");
		
		PrintWriter out=response.getWriter();
		String fname=request.getParameter("name");
		String email=request.getParameter("email");
		String desig=request.getParameter("designation");
		String city=request.getParameter("city");
		String phone=request.getParameter("phoneno");
		System.out.print("name "+fname);
		System.out.print("email "+email);
		System.out.print("designation "+desig);
		System.out.print("city "+city);
		System.out.print("phoneno "+phone);
		UserStaff s=new UserStaff(request.getParameter("name"), request.getParameter("city"), request.getParameter("designation"), request.getParameter("email"), request.getParameter("phoneno"));
        UserDao db=new UserDao();
        
        try {
			int stafflist=db.addStaff(s);
			
		
		        out.print("Data Inserted!");
		        request.setAttribute("message", "New Staff added successfully!");
				request.getRequestDispatcher("staffserv").forward(request, response);
		
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
