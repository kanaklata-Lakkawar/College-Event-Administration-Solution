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
import model.UserStudent;


@WebServlet("/studentdataserv")
public class StudentData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentData() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        HttpSession h=request.getSession();
        String uname=(String) h.getAttribute("email");
        String upass=(String) h.getAttribute("pswd");
//        UserStudent u=new UserStudent( request.getParameter("name"),  request.getParameter("city"),  request.getParameter("course"),  request.getParameter("email"),  request.getParameter("phoneno"));
		
        System.out.println("name "+request.getParameter("name"));
	    System.out.println("email "+request.getParameter("email"));
	    System.out.println("course  "+request.getParameter("course"));
	   System.out.println("city" +request.getParameter("city"));
	    System.out.println("phoneno "+request.getParameter("phoneno"));
        
          UserStudent u = new UserStudent(
        	    request.getParameter("name"),
        	    request.getParameter("email"),
        	    request.getParameter("course"),
        	    request.getParameter("city"),
        	    request.getParameter("phoneno")
        	);
        try {
			int stulist=new UserDao().addStudent(u);
			if (stulist > 0) {
				request.setAttribute("message", "New student added successfully!");
				request.getRequestDispatcher("studentserv").forward(request, response);
				
				System.out.println("Student data inserted ");
			}
			 else {
		           
		            out.print("<div class='alert alert-danger' role='alert'>Failed to add the student. Please try again.</div>");
		        }
			
			
			
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
