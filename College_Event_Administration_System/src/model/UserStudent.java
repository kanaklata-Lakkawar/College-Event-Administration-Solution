package model;


public class UserStudent {
	
	private int stuId;
	private String stuName;
	private String stuEmail;
	private String stuCourse;
	private String stuCity;
	private String stuPhoneno;
	
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuEmail() {
		return stuEmail;
	}
	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}
	public String getStuCourse() {
		return stuCourse;
	}
	public void setStuCourse(String stuCourse) {
		this.stuCourse = stuCourse;
	}
	public String getStuCity() {
		return stuCity;
	}
	public void setStuCity(String stuCity) {
		this.stuCity = stuCity;
	}
	public String getStuPhoneno() {
		return stuPhoneno;
	}
	public void setStuPhoneno(String stuPhoneno) {
		this.stuPhoneno = stuPhoneno;
	}
	public UserStudent(int stuId, String stuName, String stuEmail, String stuCourse, String stuCity,
			String stuPhoneno) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuEmail = stuEmail;
		this.stuCourse = stuCourse;
		this.stuCity = stuCity;
		this.stuPhoneno = stuPhoneno;
	}
	
	public UserStudent(String stuName, String stuEmail, String stuCourse, String stuCity,  String stuPhoneno) {
		
		super();
		this.stuName = stuName;
		this.stuCity = stuCity;
		this.stuCourse = stuCourse;
		this.stuEmail = stuEmail;
		this.stuPhoneno = stuPhoneno;
	}
	public UserStudent(String stuName, String stuEmail) {
        super();
        this.stuName = stuName;
		this.stuEmail = stuEmail;
	}
    

	
}
