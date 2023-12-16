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


@WebServlet("/cancelevent")
public class CancelEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CancelEvent() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		HttpSession h=request.getSession();
		String uname=(String) h.getAttribute("email");
		String upass=(String) h.getAttribute("pswd");
		
		
		int Eid=  Integer.parseInt(request.getParameter("eventid"))  ;
				out.print("Eid "+Eid);
				try {
					int deleteevent=new UserDao().deleteEvent(Eid);
					System.out.println("Event deleted successfully");
					request.getRequestDispatcher("eventserv").forward(request, response);
					
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
