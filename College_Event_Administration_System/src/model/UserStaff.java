package model;

public class UserStaff {

	private int sId;
	private String sname;
	private String semail;
	private String sdesignation;
	private String scity;
	private String sphoneno;
	
	public int getsId() {
		return sId;
	}
	public void setsId(String sname) {
		this.sId = sId;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getSdesignation() {
		return sdesignation;
	}
	public void setSdesignation(String sdesignation) {
		this.sdesignation = sdesignation;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	public String getSphoneno() {
		return sphoneno;
	}
	public void setSphoneno(String sphoneno) {
		this.sphoneno = sphoneno;
	}
	
	public UserStaff(String sname, String scity, String sdesignation, String semail, String sphoneno) {
		super();
		this.sname = sname;
		this.semail = semail;
		this.sdesignation = sdesignation;
		this.scity = scity;
		this.sphoneno = sphoneno;
	}
	public UserStaff(int sId, String sname, String semail, String sdesignation, String scity, String sphoneno) {
		super();
		this.sId=sId;
		this.sname = sname;
		this.semail = semail;
		this.sdesignation = sdesignation;
		this.scity = scity;
		this.sphoneno = sphoneno;
	}
	public UserStaff(String sname, String semail, String scity, String sphoneno) {
		super();
		
		this.sname = sname;
		this.semail = semail;
		this.scity = scity;
		this.sphoneno = sphoneno;
	}
	public UserStaff(int sId, String sname, String semail, String scity, String sphoneno) {
super();
this.sId=sId;
		this.sname = sname;
		this.semail = semail;
		this.scity = scity;
		this.sphoneno = sphoneno;
	}
	public UserStaff(String parameter, String parameter2) {
		super();	
		this.sname = sname;
		this.semail = semail;
				
	}
	
	
}
