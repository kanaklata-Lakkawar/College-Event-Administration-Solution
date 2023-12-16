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


@WebServlet("/deletecat")
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		HttpSession h=request.getSession();
		String uname=(String) h.getAttribute("email");
		String upass=(String) h.getAttribute("pswd");
		
		int cId=Integer.parseInt(request.getParameter("id"));
		
		try {
			int deleteCat=new UserDao().deleteCategory(cId);
			System.out.println("category deleted successfully");
			request.getRequestDispatcher("categoryserv").include(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
