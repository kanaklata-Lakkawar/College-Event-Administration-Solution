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


@WebServlet("/editstuserv")
public class EditStuServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EditStuServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		HttpSession h=request.getSession();
		String uname=(String) h.getAttribute("email");
		String upass=(String) h.getAttribute("pswd");
		System.out.println("my id= "+request.getParameter("stuid"));
int stuId=Integer.parseInt(request.getParameter("stuid"));

	
		
		
		UserStudent u=new UserStudent(stuId,request.getParameter("name"),request.getParameter("email"),request.getParameter("email"),request.getParameter("city"),request.getParameter("phoneno"));
		
		
		try {
			new UserDao().editStudent(u);
		System.out.println("data updated");
		//request.setAttribute("message2", "student's information edited successfully!");
		request.getRequestDispatcher("studentserv").forward(request, response);
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
