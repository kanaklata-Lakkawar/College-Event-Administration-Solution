package controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserSignup;




@WebServlet("/changeprofileserv")
public class ChangeProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ChangeProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession h=request.getSession();
		String uname=(String) h.getAttribute("email");
		String upass=(String) h.getAttribute("pswd");
		
	
		
		UserSignup us=new UserSignup(uname, upass);
		
		out.print("<head>");
		
		out.print("  <meta charset='utf-8'>");
		out.print("  <meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.print("  <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css'>");
		out.print("  <script src='https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js'></script>");
		out.print("  <script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js'></script>");
		out.print("  <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet'>");
		out.print("  <script src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js'></script>");
		out.print("<style>");
				
	            
		out.print("  background-image: url('pict1.jpg'); ");
		out.print("   background-size: cover; ");
		out.print("  background-repeat: no-repeat;");
	    out.print(" </style>");
		
		out.print("</head>");
		
		request.getRequestDispatcher("adminprofile").include(request, response);
		out.print("<div class='container' style='margin-top: 120px;'>");
		
		out.print("    <div class='container' style='background-color: #00897b; padding: 15px; width: 50%; margin: 0 auto;'>");
		out.print("    ");
		out.print("     <h4 style='text-align: center;'>Change Password</h4>");
		out.print("  <form action='updaterofileserv'> ");

		
		out.print("    <div class='form-group '>");
		out.print("      <label for='pwd'>Password:</label>");
		out.print("      <input type='text' class='form-control' id='pwd' name='pswd'value="+us.getPswd()+" readonly>");
		out.print("    </div>");
	
		out.print("     <div class='form-group '>");
		out.print("      <label for='newpass'>new Password:</label>");
		out.print("      <input type='newpass' class='form-control' id='newpass'  name='newpass' placeholder='Enter new Password' required >");
		out.print("    </div>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='reenterpass'>Re-enter New Password:</label>");
		out.print("<input type='password' class='form-control' id='reenterpass' name='reenterpass' placeholder='Re-enter new Password' required >");
		out.print("</div>");

		out.print("<span id='password-error' style='color: red;'></span>");
		
		out.print("    <button type='submit' class='btn btn-primary'>Update</button>");
		out.print("  </form>");
		out.print("</div>");
		out.print("</div>");
		
		

	    
	    out.print("<script>");
	    out.print("function validatePassword() {");
	    out.print("  var newPassword = document.getElementById('newpass').value;");
	    out.print("  var reenteredPassword = document.getElementById('reenterpass').value;");
	    out.print("  var errorSpan = document.getElementById('password-error');");
	    out.print("  if (newPassword !== reenteredPassword) {");
	    out.print("    errorSpan.textContent = 'Passwords do not match. Please re-enter the same password.';");
	    out.print("    return false;");
	    out.print("  }");
	    out.print("  errorSpan.textContent = '';"); 
	    out.print("  return true;");
	    out.print("}");
	    out.print("</script>");
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
