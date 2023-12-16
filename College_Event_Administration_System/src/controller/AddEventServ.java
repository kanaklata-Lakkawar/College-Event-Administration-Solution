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


@WebServlet("/addeventserv")
public class AddEventServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AddEventServ() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();

		    

	        out.print("<html>");
	        out.print("<head>");
	        out.print("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css'>");
	        out.print("<script src='https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js'></script>");
	        out.print("<script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js'></script>");
	        out.print("<script src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js'></script>");
	        
	       
	        out.print("</head>");
	        
	        out.print("<body>");
	    	HttpSession h=request.getSession();
			String email=(String) h.getAttribute("email");
			String upass=(String) h.getAttribute("pswd");
	        UserDao db = new UserDao();

	        try {
	            ArrayList<Category> categorylist = db.getCategorylist();

	            
				
	            out.print("<div class='container' style='background-color: #00897b; padding: 15px; width: 50%; margin: 0 auto;'>");
	            out.print("<h4 style='text-align: center;'>Add Event Category</h4>");
	            out.print("<form action='eventserv' method='get'>");
	            out.print("<div class='form-group'>");
	            
	            out.print("<label for='category'>Category</label>");
	            out.print("<select name='category' class='form-control'>");

	            for (Category c : categorylist) {
	                out.print("<option value='" +  c.getCat_name()  + "'>" + c.getCat_name() + "</option>");
	            }

	            out.print("</select>");
	            out.print("</div>");

	            out.print(" <div class='form-group'>");
	             out.print("<label for='categoryDescription'>Category Description</label>");
	            out.print("<textarea class='form-control' id='categoryDescription' rows='3' name='categoryDescription'></textarea>");
	            out.print(" </div>");
            
	            out.print(" <div class='form-group'>");
	            out.print(" <label for='startDateDate'>Start Date</label>");
	         	  out.print(" <input type='date' class='form-control' id='startDateDate' name='startDate' required >");
	           out.print(" </div>");
	           out.print(" <div class='form-group'>");
	            out.print(" <label for='startDateDate'>End Date</label>");
	         	  out.print(" <input type='date' class='form-control' id='startDateDate' name='endDate' required >");
	           out.print(" </div>");
	           out.print("<div class='form-group'>");
	             out.print("  <label for='startTime'>Start Time</label>");
	            out.print(" <input type='time' class='form-control' id='startTime' name='startTime' required >");
	          out.print("</div>");
	          out.print("<div class='form-group'>");
	             out.print("  <label for='startTime'>End Time</label>");
	            out.print(" <input type='time' class='form-control' id='startTime' name='endTime' required >");
	          out.print("</div>");
	           

	            out.print("<input type='submit' value='Add Event' class='btn btn-primary'>");
	            out.print("</form>");
	            out.print("</div>");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        out.print("</body>");
	        out.print("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
