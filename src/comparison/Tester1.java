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
		
		assignData();
		
		
	}
	
	
	public static void assignData(){
		for(int i = 0; i < spr2017.size(); i++){
			int startHour;
			int startMin;
			int endHour;
			int endMin;
			boolean[] day = {false,false,false,false,false};
			
			ArrayList<Course> extraClasses = new ArrayList<>();
			if(spr2017.get(i)[0].equals("LEC")){
				

				int startHour2;
				int startMin2;
				int endHour2;
				int endMin2;
				boolean[] day2= {false,false,false,false,false};

				
				if(spr2017.get(i)[3].substring(5,6).equals("PM")){
					startHour = Integer.parseInt(spr2017.get(i)[3].substring(0,2)) + 12;
					startMin = Integer.parseInt(spr2017.get(i)[3].substring(3,5));
				}else{
					startHour = Integer.parseInt(spr2017.get(i)[3].substring(0,2));	
					startMin = Integer.parseInt(spr2017.get(i)[3].substring(3,5));
				}
				
				if(spr2017.get(i)[3].substring(11).equals("PM")){
					endHour = Integer.parseInt(spr2017.get(i)[3].substring(6,8)) + 12;
					endMin = Integer.parseInt(spr2017.get(i)[3].substring(9,11));
				}else{
					endHour = Integer.parseInt(spr2017.get(i)[3].substring(6,8));	
					endMin = Integer.parseInt(spr2017.get(i)[3].substring(9,11));
				}
				
				String days = spr2017.get(i)[2];
				while(days.length() >  0)
				{
					if(days.charAt(0) == 'M'){
						day[0] = true;
						days = days.substring(1);
					}
					else if(days.charAt(0) == 'W'){
						day[2] = true;
						days = days.substring(1);
					}
					else if(days.charAt(0) == 'T' && days.length() >= 2){
						if(days.charAt(1) =='U'){
							day[1] = true;
							days = days.substring(2);
						}
						else if(days.charAt(1) =='H'){
							day[3] = true;
							days = days.substring(2);
						}
						else{
							break;
						}
						
					}
					else if(days.charAt(0) == 'F'){
						day[4] = true;
						days = days.substring(1);
					}else{
						break;
					}
				}
				
				int counter = i+1;
				while(spr2017.get(counter)[1].equals("REC") || spr2017.get(counter).equals("LAB")){
					if(spr2017.get(counter)[3].substring(5,6).equals("PM")){
						startHour2 = Integer.parseInt(spr2017.get(counter)[3].substring(0,2)) + 12;
						startMin2 = Integer.parseInt(spr2017.get(counter)[3].substring(4,6));
					}else{
						startHour2 = Integer.parseInt(spr2017.get(counter)[3].substring(0,2));	
						startMin2 = Integer.parseInt(spr2017.get(counter)[3].substring(4,6));
					}
					
					if(spr2017.get(i)[3].substring(5,6).equals("PM")){
						endHour2 = Integer.parseInt(spr2017.get(counter)[3].substring(6,8)) + 12;
						endMin2 = Integer.parseInt(spr2017.get(counter)[3].substring(11));
					}else{
						endHour2 = Integer.parseInt(spr2017.get(counter)[3].substring(6,8));	
						endMin2 = Integer.parseInt(spr2017.get(counter)[3].substring(11));
					}
					
					days = spr2017.get(i)[2];
					while(days.length() >  0)
					{
						if(days.charAt(0) == 'M'){
							day2[0] = true;
							days = days.substring(1);
						}
						else if(days.charAt(0) == 'W'){
							day2[2] = true;
							days = days.substring(1);
						}
						else if(days.charAt(0) == 'T' && days.length() >= 2){
							if(days.charAt(1) =='U'){
								day2[1] = true;
								days = days.substring(2);
							}
							else if(days.charAt(1) =='H'){
								day2[3] = true;
								days = days.substring(2);
							}
							else{
								break;
							}
							
						}
						else if(days.charAt(0) == 'F'){
							day2[4] = true;
							days = days.substring(1);
						}else{
							break;
						}
					}
					
					Course temp1 = new Course(startHour2, startMin2, endHour2, endMin2, day2);
					extraClasses.add(temp1);
				}
			Course temp = new Course(startHour, startMin, endHour, endMin, day, extraClasses);
			spr2017Courses.add(temp);
			}
			
		}
	}
	
	
}
