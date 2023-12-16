 package model;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;



public class UserDao {
	
	Connection getConnect() throws ClassNotFoundException, SQLException
	{
		//step 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Step 1");
		//step 2
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management_db","root","abc123");
		System.out.println("Step 2");
		
		return con;
	}
	
	public String checkUser(String email, String pass) throws ClassNotFoundException, SQLException {
	    Connection con = getConnect();
	    System.out.println("Step 1 check user");
	    String sql = "SELECT role FROM signup_tbl WHERE email = ? AND password = ?";
	    PreparedStatement st = con.prepareStatement(sql);
	    System.out.println("Step 2 check user");
	    st.setString(1, email);
	    st.setString(2, pass);
	    
	    System.out.println("email "+email);
	    System.out.println("pass "+pass);
	    System.out.println("Step 3 check user");
	    ResultSet rs = st.executeQuery();
	    System.out.println("Step 4 check user");
	    String role = null;
	    if (rs.next()) {
	    
	        role = rs.getString("role");
	        System.out.print("role : "+role);
	    }
	    System.out.println("Step 5 check user "+role);
	    con.close();
	    return role;
//		Connection con = getConnect();
//		System.out.println("Step 1 check user");
//
//		String sql = "SELECT role FROM signup_tbl WHERE email = ? AND password = ?";
//		PreparedStatement st = con.prepareStatement(sql);
//		System.out.println("Step 2 check user");
//
//		st.setString(1, email);
//		st.setString(2, pass);
//
//		System.out.println("email " + email);
//		System.out.println("pass " + pass);
//		System.out.println("Step 3 check user");
//
//		ResultSet rs = st.executeQuery();
//		System.out.println("Step 4 check user");
//
//		String role = null;
//		if (rs.next()) {
//		    role = rs.getString("role");
//		    System.out.println("role: " + role);
//		}
//
//		System.out.println("Step 5 check user " + role);
//
//		rs.close(); // Close the ResultSet
//		st.close(); // Close the PreparedStatement
//		con.close(); // Close the Connection
//
//		return role;

	}
	
	public int setEventCategory(Category c) throws ClassNotFoundException, SQLException {
		
		Connection con=getConnect();
		System.out.println("Step 3");
		String sql="INSERT INTO category_tbl (cat_name) values(?)";
		System.out.println("Step 4");
		PreparedStatement ps=con.prepareStatement(sql);
		System.out.println("Step 5");
		ps.setString(1, c.getCat_name());
		System.out.println("Step 6");
		int categorylist=ps.executeUpdate();
		System.out.println("Step 7");
		return categorylist;
	}
	public ArrayList<Category> getCategorylist() throws ClassNotFoundException, SQLException {
		
		Connection con=getConnect();
		System.out.println("Step 1 Category");
		String sql="SELECT * FROM category_tbl";
		System.out.println("Step 2 Category");
		PreparedStatement ps=con.prepareStatement(sql);
		System.out.println("Step 3 Category");
		
		
		ResultSet rs= ps.executeQuery();
		System.out.println("Step 4 Category");
		ArrayList<Category> categorylist=new ArrayList<>();
		System.out.println("Step 5 Category");
		 while(rs.next())
		 {
			 Category c=new Category(rs.getInt(1),rs.getString(2));
			 System.out.println("Step 6 Category");
			 categorylist.add(c);
			 System.out.println("Step 7 Category");
		 }
		
		return categorylist;
	}
	public int addEvent(Event ev) throws ClassNotFoundException, SQLException {
		
			Connection con=getConnect();
			System.out.println("Step 1 Event");
			String sql="INSERT INTO event_tbl (cat_name,cat_desc,start_dt,end_dt,start_time,end_time) values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			System.out.println("Step 2 Event");
			ps.setString(1, ev.getCategory());
			ps.setString(2, ev.getCatDesc());
			ps.setString(3, ev.getStartDate());
			ps.setString(4, ev.getEndDate());
			ps.setString(5, ev.getStartTime());
			ps.setString(6, ev.getEndTime());
			System.out.println("Step 3 Event");
			int eventadded=ps.executeUpdate();
			System.out.println("Step 4 Event   "+eventadded);
			return eventadded;
		
		
	}
	
	
	public int addStaff(UserStaff s) throws ClassNotFoundException, SQLException {
		
		Connection con=getConnect();
		String sql="INSERT INTO staff_tbl (name,email,designation,city,phoneno) values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		System.out.println("Step 3 Staff");
		ps.setString(1, s.getSname() );
        ps.setString(2, s.getSemail());	
        ps.setString(3, s.getSdesignation());
        ps.setString(4, s.getScity());
        ps.setString(5, s.getSphoneno());
        
        System.out.println("Step 4 Staff");
        int stafflist=ps.executeUpdate();
        System.out.println("Step 5 Staff   "+stafflist);
		return stafflist;
		
	}
	
	
	
	public ArrayList<UserStaff> getStaff(int pId, int total) throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
		//String sql="SELECT * FROM staff_tbl";//+(pId-1)+","+total;
		String sql="SELECT * FROM staff_tbl limit "+(pId-1)+","+total;
		//String sql="SELECT * FROM student_tbl 
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		ArrayList<UserStaff> stafflist=new ArrayList<>();
		while(rs.next()){
			UserStaff us=new UserStaff(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(3));
			stafflist.add(us);
		
	}
		return stafflist;
	
	
	}
	public int deleteUser(int sId) throws ClassNotFoundException, SQLException {
		
		Connection con=getConnect();
		
		String sql="DELETE FROM staff_tbl WHERE staff_ID=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, sId);
		int delete=ps.executeUpdate();
		System.out.println(" delete "+delete);
			return delete;
	}
	
	public UserStaff getOneUser(int sId) throws ClassNotFoundException, SQLException {
		
		Connection con=getConnect();
		System.out.println(" edit show step 1" );
		String sql="SELECT * FROM staff_tbl WHERE staff_ID=?";
		PreparedStatement ps=con.prepareStatement(sql);
	
		ps.setInt(1, sId);
		System.out.println(" edit show step 2" );
		UserStaff us=null;
		ResultSet rs=ps.executeQuery();
		System.out.println(" edit show step 3" );
		while(rs.next()){
			us=new UserStaff(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			System.out.println(" edit show step 4 "+us );
		}
		System.out.println(" edit show step 5 "+us );
		return us;
	}
	
	public int edituser(UserStaff us) throws ClassNotFoundException, SQLException {
		
		Connection con=getConnect();
		System.out.println(" edit  step 1 ");
		String sql="UPDATE staff_tbl set name=?, email=?, city=?, phoneno=? WHERE staff_ID=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, us.getSname());
		ps.setString(2, us.getSemail());
		ps.setString(3, us.getScity());
		ps.setString(4, us.getSphoneno());
		ps.setInt(5, us.getsId());
		System.out.println( " sid = " +us.getsId());
		System.out.println(" edit  step 2 ");
		int edit=ps.executeUpdate();
		System.out.println(" edit  step 3 "+edit); 
		return edit;
	
	}
	
	public int addStudent(UserStudent u) throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
		System.out.println(" student  step 1 "); 
		String sql="INSERT INTO student_tbl (name, email,course,city,phoneno) VALUES (?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		System.out.println(" student  step 2 "); 
		ps.setString(1, u.getStuName());
		ps.setString(2, u.getStuEmail());
		ps.setString(3, u.getStuCourse());
		ps.setString(4, u.getStuCity());
		ps.setString(5, u.getStuPhoneno());
		System.out.println(" student  step 3 "); 
		int stulist=ps.executeUpdate();
		System.out.println(" student  step 4 "+stulist); 
		return stulist;
	}
	public ArrayList<UserStudent> getStudent(int pId, int total) throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
		String sql="SELECT * FROM student_tbl limit "+(pId-1)+","+total;
		 
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		ArrayList<UserStudent> stulist=new ArrayList<>();
		while(rs.next()){
			UserStudent u=new UserStudent(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			stulist.add(u);
		
	}
		return stulist;
	}
	public UserStudent getOneStudent(int stuId) throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
		System.out.println(" edit stud step 1" );
		String sql="SELECT * FROM student_tbl WHERE stu_ID=?";
		PreparedStatement ps=con.prepareStatement(sql);
	
		ps.setInt(1, stuId);
		System.out.println(" edit stud step 2" );
		UserStudent u=null;
		ResultSet rs=ps.executeQuery();
		System.out.println(" edit stud step 3" );
		while(rs.next()){
			u=new UserStudent(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			System.out.println(" edit stud step 4 "+u );
		}
		System.out.println(" edit stud step 5 "+u );
		return u;
		
	}
	public int editStudent(UserStudent u) throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
		System.out.println(" edit stu step 1 ");
		String sql="UPDATE student_tbl set name=?, email=?, city=?, phoneno=? WHERE stu_ID=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, u.getStuName());
		ps.setString(2, u.getStuEmail());
		ps.setString(3, u.getStuCity());
		ps.setString(4, u.getStuPhoneno());
		ps.setInt(5, u.getStuId());
		System.out.println( " sid = " +u.getStuId());
		System.out.println(" edit   stu step 2 ");
		int editStu=ps.executeUpdate();
		System.out.println(" edit  stu step 3 "+editStu); 
		return editStu;
		
	}
	public int deleteStud(int stuId) throws SQLException, ClassNotFoundException {
Connection con=getConnect();
		
		String sql="DELETE FROM student_tbl WHERE stu_ID=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, stuId);
		int deleteStu=ps.executeUpdate();
		System.out.println(" delete "+deleteStu);
			return deleteStu;
	}
	
	public int sigupStudent(UserStudent u) throws ClassNotFoundException, SQLException {
	    Connection con = getConnect();
	    String sql = "INSERT INTO student_tbl (name, email) VALUES (?, ?)";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, u.getStuName());
	    ps.setString(2, u.getStuEmail());
	    int sigupStu = ps.executeUpdate();
	    return sigupStu;
	}

	public int signupData(String role,String name, String email, String pswd) throws ClassNotFoundException, SQLException {
		 Connection con = getConnect();
			System.out.println(" signup step 1"); 
		    String sql = "INSERT INTO signup_tbl (role,name,email,password) VALUES (?,?,?,?)";
		    PreparedStatement ps = con.prepareStatement(sql);
		    System.out.println(" signup step 2"); 
		    ps.setString(1,role);
		   
		    ps.setString(2, name);
		    ps.setString(3, email);
		    ps.setString(4, pswd);
		    System.out.println(" signup step 3"); 
		    int signData = ps.executeUpdate();
		    System.out.println(" signup step 4 "+signData); 
		    return signData;
		
		
	}

	public int staffSignup(String name, String email) throws ClassNotFoundException, SQLException {
		Connection con = getConnect();
		System.out.println(" staffSignup step 1"); 
	    String sql = "INSERT INTO staff_tbl (name,email) VALUES (?,?)";
	    PreparedStatement ps = con.prepareStatement(sql);
	    System.out.println(" staffSignup step 2"); 
	   
	    ps.setString(1, name);
	    ps.setString(2, email);
	    System.out.println(" staffSignup step 3"); 
	    int staffSignup = ps.executeUpdate();
	    System.out.println(" staffSignup step 4 "+staffSignup); 
	    return staffSignup;
	
		
	}

	public UserStaff getStaffInfo(String email) throws ClassNotFoundException, SQLException {
		
		
		
		Connection con=getConnect();
		System.out.println(" getStaffInfo step 1" );
		String sql="SELECT * FROM staff_tbl WHERE email=?";
	
		PreparedStatement ps=con.prepareStatement(sql);
	
		ps.setString(1, email);
		System.out.println(" getStaffInfo step 2" );
		UserStaff u=null;
		ResultSet rs=ps.executeQuery();
		System.out.println(" getStaffInfo step 3" );
		while(rs.next()){
			u=new UserStaff(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			System.out.println(" getStaffInfo step 4 "+u );
		}
		System.out.println(" getStaffInfo step 5 "+u );
		return u;
		
		
	}

	public int changeprofile( String uname, String upass, String newpass) throws ClassNotFoundException, SQLException {
		
		Connection con=getConnect();
		System.out.println(" changeprofile stu step 1 ");
		String sql="UPDATE signup_tbl set  password=? WHERE email=? and password=?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		
		ps.setString(1, newpass);		
		ps.setString(2, uname);System.out.println("New pass "+newpass);
		
		ps.setString(3, upass);
	
		System.out.println(" changeprofile    step 2 ");
		int change=ps.executeUpdate();
		System.out.println(" changeprofile   step 3 "+change); 
		return change;
		
	}

	public ArrayList<Event> getEventlist() throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
		String sql="SELECT event_ID,cat_name,cat_desc,start_dt,end_dt,start_time,end_time,img_name  FROM event_tbl";
		//
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		ArrayList<Event> eventlist=new ArrayList<>();
		while(rs.next()){
			Event ev=new Event(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
			System.out.println("img : "+rs.getString(8));
			eventlist.add(ev);
		
	}
		return eventlist;
		
	}

	public int deleteEvent(int eid) throws ClassNotFoundException, SQLException {
Connection con=getConnect();
		
		String sql="DELETE FROM Event_tbl WHERE event_ID=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, eid);
		int deleteevent=ps.executeUpdate();
		System.out.println(" delete "+deleteevent);
			return deleteevent;
		
	}

	public int deleteCategory(int cId) throws SQLException, ClassNotFoundException {
Connection con=getConnect();
		
		String sql="DELETE FROM category_tbl WHERE cat_ID=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, cId);
		int deleteCat=ps.executeUpdate();
		System.out.println(" delete "+deleteCat);
			return deleteCat;
	}

	public UserStudent getStudentInfo(String email) throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
		System.out.println(" getStudentInfo step 1" );
		String sql="SELECT * FROM student_tbl WHERE email=?";
		PreparedStatement ps=con.prepareStatement(sql);
	
		ps.setString(1, email);
		System.out.println(" getStudentInfo step 2" );
		UserStudent us=null;
		ResultSet rs=ps.executeQuery();
		System.out.println(" getStudentInfo step 3" );
		while(rs.next()){
			us=new UserStudent(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			System.out.println(" getStudentInfo step 4 "+us );
		}
		System.out.println(" getStudentInfo step 5 "+us );
		return us;
	}

	public int setEvent(int EId,String email) throws ClassNotFoundException, SQLException {
		Connection con=getConnect();

		   
		String sql1 = "INSERT INTO stu_event (stu_mail) SELECT email FROM student_tbl WHERE email = ?";
	    PreparedStatement ps1 = con.prepareStatement(sql1);
	    ps1.setString(1, email);
	    int event1 = ps1.executeUpdate();

	    
	    String sql2 = "INSERT INTO stu_event (stu_mail, cat_name, cat_desc, start_dt, end_dt, start_time, end_time) " +
	                 "SELECT ?, cat_name, cat_desc, start_dt, end_dt, start_time, end_time " +
	                 "FROM event_tbl WHERE event_ID = ?";
	    PreparedStatement ps2 = con.prepareStatement(sql2);
	    ps2.setString(1, email);
	    ps2.setInt(2, EId);
	    int event2 = ps2.executeUpdate();
	    
	    
	    con.close();
	    return event1 + event2;
	}
	
	public ArrayList<Event> getEvent(String email) throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
		String sql="SELECT *FROM stu_event where stu_mail=? ";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, email);
		//Event ev=null;
		ArrayList<Event> bookedevent=new ArrayList<>();
		ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Event ev=new Event(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				System.out.println("img : "+rs.getString(9));
				bookedevent.add(ev);
			}
			
			return bookedevent;
	}

	public int joinEvent(String uname) throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
		String sql="UPDATE student_tbl SET event='booked' WHERE email=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, uname);
		
		int joinEvent=ps.executeUpdate();
		return joinEvent;
			
	}

	public HashSet<UserStudent> bookEventStudents() throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
		String sql="SELECT *FROM student_tbl where event='booked'";
		PreparedStatement ps=con.prepareStatement(sql);
		HashSet<UserStudent> booked=new HashSet<>();
		ResultSet rs=ps.executeQuery();
			while(rs.next()){
				UserStudent us=new UserStudent(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6));
				booked.add(us);
			}
				
			return booked;
		
	}

	public HashSet<BookedEvent> bookEventsDetails(String email) throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
		System.out.println("step 3");
		String sql="SELECT *FROM stu_event WHERE cat_name IS NOT NULL";
		System.out.println("step 4  "+email);
		PreparedStatement ps=con.prepareStatement(sql);
		System.out.println("step 5");

	    System.out.println("step 6");
	    HashSet<BookedEvent> details=new HashSet<>();
		System.out.println("step 7");
		ResultSet rs=ps.executeQuery();
		System.out.println("step 8");
			while(rs.next()){
				BookedEvent b=new BookedEvent(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8));
				details.add(b);
			}
			System.out.println("step 8 "+details);	
			return details;
			
			
			
	}

	public int checkMail(String uname) throws ClassNotFoundException, SQLException {
		Connection con=getConnect();
		String sql="SELECT * FROM signup_tbl WHERE email=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, uname);
	   ResultSet rs=ps.executeQuery();
	   if(rs.next()){
		   return 1;
	   }
	   else
	    return 0;
	}

	public void getNumOfStud() throws ClassNotFoundException, SQLException {
	  Connection con=getConnect();
	  String sql="SELECT COUNT * FROM student_tbl";
	  PreparedStatement ps=con.prepareStatement(sql);
		
	}

	public int saveImageName(String imageFileName, String category) throws ClassNotFoundException, SQLException {
	   
	        Connection con = getConnect();

	        
	        String stuEventSql = "UPDATE stu_event SET img_name=? WHERE cat_name=?";
	        PreparedStatement stuEventPs = con.prepareStatement(stuEventSql);
	        stuEventPs.setString(1, imageFileName);
	        stuEventPs.setString(2, category);
	        int stuEventResult = stuEventPs.executeUpdate();
System.out.println("img 1 "+stuEventResult);
	        // Update event_tbl table
	        String eventTblSql = "UPDATE event_tbl SET img_name=? WHERE cat_name=?";
	        PreparedStatement eventTblPs = con.prepareStatement(eventTblSql);
	        eventTblPs.setString(1, imageFileName);
	        eventTblPs.setString(2, category);
	        int eventTblResult = eventTblPs.executeUpdate();
	        System.out.println("img 2 "+eventTblResult);
	        
	        if (stuEventResult > 0 || eventTblResult > 0) {
	            System.out.println("Image Name inserted");
	            return 1; // Return 1 to indicate success
	        } else {
	            System.out.println("Image Name Not inserted");
	            return 0; // Return 0 to indicate failure
	        }
	    
	}
	

	

	
	

}
