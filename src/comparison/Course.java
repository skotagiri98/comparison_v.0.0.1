package comparison;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;

public class Course {
	private int startHour;
	private int startMin;
	private int endHour;
	private int endMin;
	private boolean[] days = {false,false,false,false,false};

	private int RECstartHour;
	private int RECstartMin;
	private int RECendHour;
	private int RECendMin;
	private boolean[] RECDays= {false,false,false,false,false};
	
	
	public Course(int startHour, int startMin, int endHour, int endMin, boolean[] days){
		//Setting course lecture times
		this.startHour = startHour;
		this.startMin = startMin;
		this.endHour = endHour;
		this.endMin = endMin;
		this.days = days;
	}
	
	public Course(int startHour, int startMin, int endHour, int endMin, boolean[] days, int RECstartHour, int RECstartMin, int RECendHour, int RECendMin, boolean[] RECDays){
		//Setting course lecture times
		this.startHour = startHour;
		this.startMin = startMin;
		this.endHour = endHour;
		this.endMin = endMin;
		this.days = days;
		//Setting course rec times
		this.RECstartHour = RECstartHour;
		this.RECstartMin = RECstartMin;
		this.RECendHour = RECendHour;
		this.RECendMin = RECendMin;
		this.RECDays = RECDays;
	}
	
	
	
    
}
