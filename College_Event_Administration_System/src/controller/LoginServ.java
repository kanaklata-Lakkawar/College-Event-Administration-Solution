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
import model.UserSignup;


@WebServlet("/loginserv")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServ() {
        super();// TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		
		String email=request.getParameter("email");
		String pass=request.getParameter("pswd");
		
		HttpSession h=request.getSession();
		h.setAttribute("email", email);
		h.setAttribute("pswd", pass);
		
//		out.print("email "+email);
//		out.print("pswd "+pass);
	
		
		//UserSignup us= new UserSignup(email, pass);
		String role;
		try {
			role = new UserDao().checkUser(email, pass);
		
			System.out.println("Role : "+role);
			if (role != null) {
			    if ("Admin".equals(role)) {
			        request.getRequestDispatcher("adminprofile").forward(request, response);
			       // request.setAttribute("pId", arg1);
			        
			    } else if ("Staff".equals(role)) {
			        request.getRequestDispatcher("staffdashboard").forward(request, response);
			    } else if ("Student".equals(role)) {
			    	
			        request.getRequestDispatcher("studentdashboard").forward(request, response);
			    }
			} else {
			    out.println("User doesn't exist");
			    request.getRequestDispatcher("signup.html").include(request, response);
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
