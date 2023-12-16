package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/adminprofile")
public class adminProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public adminProfile() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		
		String email=request.getParameter("email");
		String pass=request.getParameter("pswd");
		
		HttpSession h=request.getSession();
		h.setAttribute("email", email);
		h.setAttribute("pswd", pass);
		out.print("<head>");
		out.print("<meta charset='ISO-8859-1'>");
		out.print("<title>Insert title here</title>");
		out.print("<title>Your Page Title</title>");
		out.print("");
		out.print("    <!-- Include Bootstrap CSS -->");
		out.print("    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css'>");
		out.print("");
		out.print("    <!-- Include jQuery -->");
		out.print("    <script src='https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js'></script>");
		out.print("");
		out.print("    <!-- Include Popper.js -->");
		out.print("    <script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js'></script>");
		out.print("");
		out.print("    <!-- Include Bootstrap JavaScript -->");
		out.print("    <script src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js'></script>");
		out.print("");
		out.print("</head>");
		out.print("");
		out.print("");
		out.print("<body>");
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='ISO-8859-1'>");
		out.print("<title>Insert title here</title>");
		out.print("");
		out.print(" <style>");
		out.print("       ");
		out.print("        .header-container {");
		out.print("            background-color: #00897b; /* Set your desired background color */");
		out.print("            padding: 10px;");
		out.print("            text-align: left;");
		out.print("            color: white;");
		out.print("        }");
		out.print("        .project-name {");
		out.print("            font-size: 24px;");
		out.print("            font-weight: bold;");
		out.print("            margin-bottom: 20px;");
		out.print("        }");
		out.print("    </style>");
		out.print("</head>");
		out.print("");
		out.print(" <div class='header-container'>");
		out.print("        <div class='container'>");
		out.print("            <div class='project-name'>");
		out.print("                College Event Administration System");
		out.print("            </div>");
		out.print("        </div>");
		out.print("    </div>");
		

		out.print("<nav class='navbar navbar-expand-sm bg-dark navbar-dark'>");
		out.print("  <div class='container-fluid'>");
		out.print("    <ul class='navbar-nav'>");
	
		out.print("      <li class='nav-item'>");
		out.print("       <a class='nav-link' href='categoryserv'>Categories</a>");
		out.print("      </li>");
		out.print("      <li class='nav-item'>");
		out.print("        <a class='nav-link' href='eventserv'>Events</a>");
		out.print("      </li>");
		out.print("      <li class='nav-item'>");
		out.print("        <a class='nav-link ' href='adminbookedevents'>Booked Events</a>");
		out.print("      </li>");
		out.print("      <li class='nav-item'>");
		out.print("        <a class='nav-link ' href='staffserv?spId=1'>Staff</a>");
		out.print("      </li>");
		out.print("      <li class='nav-item'>");
		out.print("        <a class='nav-link' href='studentserv?pId=1'>Students</a>");
		out.print("      </li>");
		out.print("      <li class='nav-item'>");
		out.print("        <a class='nav-link ' href='changeprofileserv'>Change Password</a>");
		out.print("      </li>");
		out.print("          <li class='nav-item'>  ");
		out.print("        <a href='index.html' class='nav-link ' class='btn btn-success' style='float: right;'>Logout</a>");
		out.print("      </li>");
		out.print("      ");
		out.print("    </ul>");
		out.print("  </div>");
		out.print("</nav>");
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
