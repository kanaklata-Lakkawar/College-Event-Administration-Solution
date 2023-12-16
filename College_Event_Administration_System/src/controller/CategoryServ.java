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

import model.Category;

import model.UserDao;


@WebServlet("/categoryserv")
public class CategoryServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CategoryServ() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out=response.getWriter();

HttpSession h=request.getSession();
String uname=(String) h.getAttribute("email");
String upass=(String) h.getAttribute("pswd");

out.print("			<head>");


out.print("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css'>");
out.print("			  <script src='https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js'></script>");
out.print("			  <script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js'></script>");
out.print("			  <script src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js'></script>");

out.print("			</head>");

request.getRequestDispatcher("adminprofile").include(request, response);
Category c=new Category(request.getParameter("categoryName"));
try {
	UserDao db =new UserDao();
	int categorylist=db.setEventCategory(c);
	
} catch (ClassNotFoundException e) {
	
	e.printStackTrace();
} catch (SQLException e) {
	
	e.printStackTrace();
}

ArrayList<Category> categorylist;
try {
	categorylist = new UserDao().getCategorylist();

    out.print("<div style='width: 100%;  text-align: center; padding: 10px; '>");
   
    out.print("<a href='category.html' class='btn btn-success' style='float: right;'>Add New</a></h3>");
    out.print("</div>");
    out.print("<br>");
    out.print("<div style='width: 100%;  text-align: center; padding: 10px;'>");
    
    out.print("<h2>Event Categories</h2>");
    out.print("</div>");
    out.print("<br>");
out.print("<table class='table table-hover' >");
out.print("		    <tbody>");
out.print("<thead>");
out.print("<tr>");
out.print("<th>CategoryID</th>");
out.print("<th>Category Name</th>");
out.print("<th>Action</th>");
out.print("</tr>");
out.print("</thead>");

for(Category c1:categorylist)
{

out.print("<tr><td>"+c1.getCat_Id()+"</td><td>"+c1.getCat_name()+"</td><td><a href='deletecat?id="+c1.getCat_Id()+"'class='btn btn-danger'>Detele</a></td></tr>");
}
out.print("		    </tbody>");
out.print("</table>");



} catch (ClassNotFoundException e) {
	
	e.printStackTrace();
} catch (SQLException e) {
	
	e.printStackTrace();
}

		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
