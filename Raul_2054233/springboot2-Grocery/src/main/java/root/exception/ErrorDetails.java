package root.exception;

import java.util.Date;

public class ErrorDetails {
	
	private Date timestamp;
	private String messege;
	private String details;
	
	public ErrorDetails(Date timestamp, String messege, String details) {
		super();
		this.timestamp = timestamp;
		this.messege = messege;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
}
