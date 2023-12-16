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


@WebServlet("/editserv")
public class EditServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditServ() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		
		
		HttpSession h=request.getSession();
		String uname=(String) h.getAttribute("email");
		String upass=(String) h.getAttribute("pswd");
		
		System.out.println("my id= "+request.getParameter("sid"));
int sId=Integer.parseInt(request.getParameter("sid"));

	
		
		
		UserStaff us=new UserStaff(sId,request.getParameter("name"),request.getParameter("email"),request.getParameter("city"),request.getParameter("phoneno"));
		
		
		try {
			new UserDao().edituser(us);
		System.out.println("data updated");
		out.println("data updated");
		request.getRequestDispatcher("staffserv").forward(request, response);
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
