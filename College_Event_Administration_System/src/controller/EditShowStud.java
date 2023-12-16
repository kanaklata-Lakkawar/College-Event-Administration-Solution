package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDao;
import model.UserStudent;

@WebServlet("/editshowstud")
public class EditShowStud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditShowStud() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		HttpSession h=request.getSession();
		String uname=(String) h.getAttribute("email");
		String upass=(String) h.getAttribute("pswd");
		
		
		int  stuId=Integer.parseInt(request.getParameter("id"));
		System.out.println("id  "+stuId);
		

		
		try {
			UserStudent u = new UserDao().getOneStudent(stuId);
			
			if(u!=null)
			{
				out.print("<head>");
				
				out.print("  <meta charset='utf-8'>");
				out.print("  <meta name='viewport' content='width=device-width, initial-scale=1'>");
				out.print("  <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css'>");
				out.print("  <script src='https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js'></script>");
				out.print("  <script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js'></script>");
				out.print("  <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet'>");
				out.print("  <script src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js'></script>");
				
				out.print("</head>");
				
				
				
			
			out.print("<h4 style='text-align: center;'>Edit Student Info</h4>");
			out.print("<div class='container' style='background-color: #ccffcc; padding: 15px; width: 50%; margin: 0 auto;'>");
			
			out.print(" <form action='editstuserv' method='get' enctype='multipart/form-data'>");
			
			out.print("<input type='hidden' name='stuid' value='" + u.getStuId() + "' readonly>");
			out.print("  <div class='form-group'>");
			out.print("      <label for='empID'>Employee ID:</label>");
			out.print(" <input type='text' class='form-control' id='sid'  name='sid'value="+u.getStuId()+" readonly>");
			out.print(" </div>");
			out.print("  <div class='form-group'>");	
			out.print("      <label for='name'>Name:</label>");
			out.print(" <input type='text' class='form-control' id='fname'  name='name' value="+u.getStuName()+">");
			out.print(" </div>");
			
			out.print("  <div class='form-group'>");	
			out.print("      <label for='course'>Course:</label>");
			out.print(" <input type='text' class='form-control' id='designation'  name='course' value="+u.getStuCourse()+" readonly>");
			out.print(" </div>");
			
//			out.print("  <div class='form-group'>");	
//			out.print("      <label for='city'>City:</label>");
//			out.print(" <input type='text' class='form-control' id='city'  name='city' value="+u.getStuCity()+">");
//			out.print(" </div>");

			out.print("  <div class='form-group'>");	
			out.print("      <label for='email'>Email:</label>");
			out.print(" <input type='text' class='form-control' id='email'  name='email' value="+u.getStuEmail()+">");
			out.print(" </div>");
			
			
//			
			out.print("  <div class='form-group'>");
			out.print("      <label for='phone'>Phoneno:</label>");
			out.print(" <input type='text' class='form-control' id='phoneno'  name='phoneno' value="+u.getStuPhoneno()+">");
			out.print(" </div>");
			out.print("<input type='submit'class='btn btn-success'  value='Update'><br>");
			out.print(" </div>");
				
				
			}
			else
			{
				out.print("<h2>User Not found</h2>");
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
