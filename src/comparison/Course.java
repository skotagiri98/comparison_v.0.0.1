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
	private ArrayList<Course> rec = new ArrayList<>();
	
	
	public Course(int startHour, int startMin, int endHour, int endMin, boolean[] days){
		//Setting course lecture times
		this.startHour = startHour;
		this.startMin = startMin;
		this.endHour = endHour;
		this.endMin = endMin;
		this.days = days;
	}
	
	public Course(int startHour, int startMin, int endHour, int endMin, boolean[] days, ArrayList<Course> rec){
		//Setting course lecture times
		this.startHour = startHour;
		this.startMin = startMin;
		this.endHour = endHour;
		this.endMin = endMin;
		this.days = days;
		this.rec = rec;
	}
	
	
	public String toString(){
		return "" + startHour;
	}
    
}
