package comparison;

import java.util.HashMap;


public class CourseList{
	
	public CourseList(){
		
	}
	
	private HashMap<String, TimeInterval> hm = new HashMap<>();

	public HashMap<String, TimeInterval> getHm() {
		return hm;
	}

	public void setHmValues(String courseId, TimeInterval courseTime) {
		this.hm.put(courseId, courseTime);
	}
}