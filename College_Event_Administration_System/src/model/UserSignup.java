package model;

public class UserSignup {
private  String name;
private  String email;
private  String role;
private String pswd;
private String newemail;
private String newPswd;

public String getnewemail() {
	return newemail;
}
public void setnewemail(String newemail) {
	this.newemail = newemail;
}

public String getnewPswd() {
	return newPswd;
}
public void setnewPswd(String newPswd) {
	this.newPswd = newPswd;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

public String getemail() {
	return email;
}
public void setemail(String email) {
	this.email = email;
}


public String getPswd() {
	return pswd;
}
public void setPswd(String pswd) {
	this.pswd = pswd;
}
public UserSignup(String role, String uname, String pswd,String name,String email) {
	super();
	this.role = role;
	
	this.pswd = pswd;
	this.name=name;
	this.email=email;
	
}
public UserSignup( String email, String pswd,String newemail,String newPswd) {
	super();
	this.email = email;
	this.pswd = pswd;
	this.newemail=newemail;
	this.newPswd=newPswd;
	
	
}
public UserSignup(String email, String pswd) {
	super();
	
	this.email = email;
	this.pswd = pswd;
	
	
}
public UserSignup(String email, String pswd,String newPswd) {
	super();
	this.email = email;
	this.pswd = pswd;
	
	this.newPswd=newPswd;
}






}
