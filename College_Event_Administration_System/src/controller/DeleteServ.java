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


@WebServlet("/deleteserv")
public class DeleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteServ() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		HttpSession h=request.getSession();
		String uname=(String) h.getAttribute("email");
		String upass=(String) h.getAttribute("pswd");
		
		int sId=Integer.parseInt(request.getParameter("id"));
		
		try {
			int delete=new UserDao().deleteUser(sId);
			System.out.println("Staff deleted successfully");
			
			request.setAttribute("message2", "staff deleted succesfully");
			request.getRequestDispatcher("staffserv").include(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
