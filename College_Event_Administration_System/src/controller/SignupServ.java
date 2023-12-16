package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDao;
import model.UserSignup;
import model.UserStaff;
import model.UserStudent;


@WebServlet("/signupserv")
public class SignupServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SignupServ() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("email");
		//out.print("<h1>Welcome "+uname+"</h1>");
		
		//UserSignup us=new UserSignup(request.getParameter("rolelist"),request.getParameter("name"),request.getParameter("email"),request.getParameter("pswd"));
        
		try {
			
		int	exist =new UserDao().checkMail(uname);
		
		if(exist>0){
			out.print("<p style='color: red; text-align: centre;'>this email Id is already registerd please try again with another one<p>");
			request.getRequestDispatcher("signup.html").include(request, response);
		}
		if(exist<=0){
			 int signData= new UserDao().signupData(request.getParameter("rolelist"),request.getParameter("name"),request.getParameter("email"),request.getParameter("pswd"));
				
				
				if(signData>0){
					out.print("User registered successfully");
					
					request.getRequestDispatcher("login.html").forward(request, response);
				}
		}
	   
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
