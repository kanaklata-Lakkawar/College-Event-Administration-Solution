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


@WebServlet("/bookevent")
public class BookEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BookEvent() {
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
		request.getRequestDispatcher("studentNav.html").include(request, response);
		int EId=Integer.parseInt(request.getParameter("eventid"));
		out.print(" Event Id : "+EId);
		System.out.println("eventid "+EId);
		
		
		

		try {
			int ev=new UserDao().setEvent(EId,uname);
			int joinEvent=new UserDao().joinEvent(uname);
			request.getRequestDispatcher("studentbookedevents").forward(request, response);
		
						
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
			
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
