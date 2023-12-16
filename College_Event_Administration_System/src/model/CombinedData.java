package model;

public class CombinedData {
	
	    private int studentId;
	    private String studentName;
	    private String course;
	    private String eventCategory;
	    private String eventDescription;
	    private String startDate;
	    private String endDate;

	    // Getters and setters for the fields

	    public CombinedData(int studentId, String studentName, String course, String eventCategory, String eventDescription, String startDate, String endDate) {
	        this.studentId = studentId;
	        this.studentName = studentName;
	        this.course = course;
	        this.eventCategory = eventCategory;
	        this.eventDescription = eventDescription;
	        this.startDate = startDate;
	        this.endDate = endDate;
	    }

		public int getStudentId() {
			return studentId;
		}

		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}

		public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public String getCourse() {
			return course;
		}

		public void setCourse(String course) {
			this.course = course;
		}

		public String getEventCategory() {
			return eventCategory;
		}

		public void setEventCategory(String eventCategory) {
			this.eventCategory = eventCategory;
		}

		public String getEventDescription() {
			return eventDescription;
		}

		public void setEventDescription(String eventDescription) {
			this.eventDescription = eventDescription;
		}

		public String getStartDate() {
			return startDate;
		}

		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}

		public String getEndDate() {
			return endDate;
		}

		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
	

}
