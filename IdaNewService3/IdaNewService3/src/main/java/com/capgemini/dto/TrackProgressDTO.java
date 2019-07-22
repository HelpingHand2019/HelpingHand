package com.capgemini.dto;

import com.capgemini.filter.CorsFilter;
import java.sql.Date;

public class TrackProgressDTO {

	    private long requestTo;
	    private long requestFrom;
	    private boolean inProgress;
	    private boolean iscompleted;
	    private String appointmentDate;
		public long getRequestTo() {
			return requestTo;
		}
		public void setRequestTo(long requestTo) {
			this.requestTo = requestTo;
		}
		public long getRequestFrom() {
			return requestFrom;
		}
		public void setRequestFrom(long requestFrom) {
			this.requestFrom = requestFrom;
		}
		public boolean isInProgress() {
			return inProgress;
		}
		public void setInProgress(boolean inProgress) {
			this.inProgress = inProgress;
		}
		public boolean isIscompleted() {
			return iscompleted;
		}
		public void setIscompleted(boolean iscompleted) {
			this.iscompleted = iscompleted;
		}
		public String getAppointmentDate() {
			return appointmentDate;
		}
		public void setAppointmentDate(String appointmentDate) {
			this.appointmentDate = appointmentDate;
		}
		@Override
		public String toString() {
			return "TrackProgressDTO [requestTo=" + requestTo + ", requestFrom=" + requestFrom + ", inProgress="
					+ inProgress + ", iscompleted=" + iscompleted + ", appointmentDate=" + appointmentDate + "]";
		}
		
	    
	   
	    
	    
	    
	    
}
