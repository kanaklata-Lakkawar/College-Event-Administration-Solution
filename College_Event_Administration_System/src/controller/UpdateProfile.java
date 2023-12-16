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


@WebServlet("/updaterofileserv")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession h=request.getSession();
		String uname=(String) h.getAttribute("email");
		String upass=(String) h.getAttribute("pswd");
		
		
//		String newuname=request.getParameter("newuname");
				String newpass=request.getParameter("newpass");
		
		out.print("Welcome "+uname);
//		out.println("new uanme "+newuname);
		out.println("new pass "+newpass);
		
//		if (newpass != null && !newuname.isEmpty()   ) {
			
			try {
				
				UserSignup us=new UserSignup(uname,upass,newpass);
		   int change=	new UserDao().changeprofile(uname,upass,newpass);
			
			out.println("data updated");
			} 
			catch (ClassNotFoundException e) {
			 e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
