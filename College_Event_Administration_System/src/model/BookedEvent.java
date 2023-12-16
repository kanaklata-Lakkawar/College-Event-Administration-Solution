package model;

public class BookedEvent {
	
		
		private int eventId;
		private String stu_mail;
	    private String category;
	    private String CatDesc; 
	    private String startDate;
	    private String endDate;
	    private String startTime ;
	    private String endTime ;
	    
		public int getEventId() {
			return eventId;
		}
		public void setEventId(int eventId) {
			this.eventId = eventId;
		}
		
		public String getstu_mail() {
			return stu_mail;
		}
		public void setstu_mail(String stu_mail) {
			this.stu_mail = stu_mail;
		}
		
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getCatDesc() {
			return CatDesc;
		}
		public void setCatDesc(String catDesc) {
			CatDesc = catDesc;
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
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
		public BookedEvent(int eventId, String stu_mail, String category, String catDesc, String startDate,
				String endDate, String startTime, String endTime) {
			super();
			this.eventId = eventId;
			this.stu_mail = stu_mail;
			this.category = category;
			CatDesc = catDesc;
			this.startDate = startDate;
			this.endDate = endDate;
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
		
	    
	   
	    
	    
		
		
	}


