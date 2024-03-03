package Online_Reservation_System;

import java.sql.Time;
import java.util.Date;

public class Train {
	
	private String train_name;
	private String train_number;
	private Time from_time;
	private int from_platform;
	private String from_place;
	private Time to_time;
	private String to_place;
	private Date date;
	
	public String getTrain_name() {
		return train_name;
	}
	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}
	
	
	public String getTrain_number() {
		return train_number;
	}
	public void setTrain_number(String train_number) {
		this.train_number = train_number;
	}
	
	
	public Time getFrom_time() {
		return from_time;
	}
	public void setFrom_time(Time from_time) {
		this.from_time = from_time;
	}
	
	
	public int getFrom_platform() {
		return from_platform;
	}
	public void setFrom_platform(int from_platform) {
		this.from_platform = from_platform;
	}
	
	
	public String getFrom_place() {
		return from_place;
	}
	public void setFrom_place(String from_place) {
		this.from_place = from_place;
	}
	
	
	public String getTo_place() {
		return to_place;
	}
	public void setTo_place(String to_place) {
		this.to_place = to_place;
	}
	
	
	public Time getTo_time() {
		return to_time;
	}
	public void setTo_time(Time to_time) {
		this.to_time = to_time;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

	
	

}
