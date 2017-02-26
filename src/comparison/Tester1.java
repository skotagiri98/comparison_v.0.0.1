package comparison;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Tester1 {
	
	static ArrayList<String[]> spr2017 = new ArrayList<String[]>();
	static ArrayList<Course> spr2017Courses = new ArrayList<Course>();
	

	public static void main(String args[]) throws Exception {
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Spring_2017.txt"), "UTF-8"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	line = line.trim();
				if(line.length() > 5 && (line.contains("LEC") || line.substring(0, 4).matches("(\\d+)"))) {
					spr2017.add(line.split("\\s+"));
				}
		    }
		}
		
	}
	
	
	public void assignData(){
		for(int i = 0; i < spr2017.size(); i++){
			int startHour;
			int startMin;
			int endHour;
			int endMin;
			if(spr2017.get(i)[0].equals("LEC")){
				if(spr2017.get(i)[3].substring(5,6).equals("PM")){
					startHour = Integer.parseInt(spr2017.get(i)[3].substring(0,2)) + 12;
					startMin = Integer.parseInt(spr2017.get(i)[3].substring(4,6));
				}else{
					startHour = Integer.parseInt(spr2017.get(i)[3].substring(0,2));	
					startMin = Integer.parseInt(spr2017.get(i)[3].substring(4,6));
				}
				
				if(spr2017.get(i)[3].substring(5,6).equals("PM")){
					endHour = Integer.parseInt(spr2017.get(i)[3].substring(6,8)) + 12;
					endMin = Integer.parseInt(spr2017.get(i)[3].substring(11));
				}else{
					endHour = Integer.parseInt(spr2017.get(i)[3].substring(6,8));	
					endMin = Integer.parseInt(spr2017.get(i)[3].substring(11));
				}
			
			}
		}
	}
	
	
}
