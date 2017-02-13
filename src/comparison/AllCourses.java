package comparison;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

public class AllCourses 
{
	public ArrayList<ArrayList<String>> allCourses = new ArrayList<ArrayList<String>>();
	public TimeInterval courseTime = new TimeInterval();
	public TimeInterval lecTime = new TimeInterval();
	private String courseID;
	private String lecID;
	public HashMap<String, TimeInterval> hm = new HashMap<>();
	
	public AllCourses()
	{
	
	}
	
	public void addLine(ArrayList<String> temp)
	{
		allCourses.add(temp);
	}
	public void makeClasses()
	{
		boolean hasLecture = false;
		for(int i = 0; i < allCourses.size(); i++)
		{
			if(allCourses.get(i).get(0).equals("LEC"))
			{
				hasLecture = true;
			}
			if(!hasLecture)
			{
				for(String temp: allCourses.get(i))
				{
					if((temp.length() == 5) && (StringUtils.isNumeric(temp)))
					{
						courseID = temp + allCourses.get(i).get(1);
					}
					if(temp.length() == 13 && temp.substring(11).equals("AM"))
					{
						temp = temp.replaceAll("-"," ");
						temp = temp.replaceAll(":", ".");
						courseTime.setTimeBegin(Double.parseDouble(temp.substring(0, 5)));
						courseTime.setTimeEnd(Double.parseDouble(temp.substring(6,11)));
					}
					//11 am to 12 pm classes edge case wrong.
					else if (temp.length() == 13 && temp.substring(11).equals("PM"))
					{
						temp = temp.replaceAll("-"," ");
						temp = temp.replaceAll(":", ".");
						courseTime.setTimeBegin((Double.parseDouble(temp.substring(0, 5))) + 12.0);
						courseTime.setTimeEnd((Double.parseDouble(temp.substring(6,11))) + 12.0);
					}
				}
				if(allCourses.get(i).size() >= 4)
				{
					String days = allCourses.get(i).get(3);
					while(days.length() >  0)
					{
						if(days.charAt(0) == 'M'){
							courseTime.setDaysInWeek(0);
							days = days.substring(1);
						}
						else if(days.charAt(0) == 'W'){
							courseTime.setDaysInWeek(2);
							days = days.substring(1);
						}
						else if(days.charAt(0) == 'T' && days.length() >= 2){
							if(days.charAt(1) =='U'){
								courseTime.setDaysInWeek(1);
								days = days.substring(2);
							}
							else if(days.charAt(1) =='H'){
								courseTime.setDaysInWeek(3);
								days = days.substring(2);
							}
							else{
								break;
							}
							
						}
						else if(days.charAt(0) == 'F'){
							courseTime.setDaysInWeek(4);
							days = days.substring(1);
						}else{
							break;
						}
					}
				}
				hm.put(courseID, courseTime);
			}
			while(hasLecture)
			{
				if((allCourses.get(i+1).get(0) != null && ((allCourses.get(i+1).get(0)).length() != 5) && 
						!(StringUtils.isNumeric(allCourses.get(i+1).get(0)))))
				{
					hasLecture = false;
				}
				String timing = allCourses.get(i).get(4);
				if(timing.length() == 13 && timing.substring(11).equals("AM"))
				{
					timing = timing.replaceAll("-"," ");
					timing = timing.replaceAll(":", ".");
					lecTime.setTimeBegin(Double.parseDouble(timing.substring(0, 5)));
					lecTime.setTimeEnd(Double.parseDouble(timing.substring(6,11)));
				}
				else if (timing.length() == 13 && timing.substring(11).equals("PM"))
				{
					timing = timing.replaceAll("-"," ");
					timing = timing.replaceAll(":", ".");
					lecTime.setTimeBegin((Double.parseDouble(timing.substring(0, 5))) + 12.0);
					lecTime.setTimeEnd((Double.parseDouble(timing.substring(6,11))) + 12.0);
				}
				
				String days = allCourses.get(i).get(2);
				while(days.length() >  0)
				{
					if(days.charAt(0) == 'M'){
						lecTime.setDaysInWeek(0);
						days = days.substring(1);
					}
					else if(days.charAt(0) == 'W'){
						lecTime.setDaysInWeek(2);
						days = days.substring(1);
					}
					else if(days.charAt(0) == 'T' && days.length() >= 2){
						if(days.charAt(1) =='U'){
							lecTime.setDaysInWeek(1);
							days = days.substring(2);
						}
						else if(days.charAt(1) =='H'){
							lecTime.setDaysInWeek(3);
							days = days.substring(2);
						}
						else{
							break;
						}	
					}
					else if(days.charAt(0) == 'F'){
						lecTime.setDaysInWeek(4);
						days = days.substring(1);
					}else if(true){
						break;
					}
				}
				
				i++;
				
				for(String temp: allCourses.get(i))
				{
					if((temp.length() == 5) && (StringUtils.isNumeric(temp)))
					{
						courseID = temp + allCourses.get(i).get(1);
						lecID = temp + "LEC";
					}
					if(temp.length() == 13 && temp.substring(11).equals("AM"))
					{
						temp = temp.replaceAll("-"," ");
						temp = temp.replaceAll(":", ".");
						courseTime.setTimeBegin(Double.parseDouble(temp.substring(0, 5)));
						courseTime.setTimeEnd(Double.parseDouble(temp.substring(6,11)));
					}
					else if (temp.length() == 13 && temp.substring(11).equals("PM"))
					{
						temp = temp.replaceAll("-"," ");
						temp = temp.replaceAll(":", ".");
						courseTime.setTimeBegin((Double.parseDouble(temp.substring(0, 5))) + 12.0);
						courseTime.setTimeEnd((Double.parseDouble(temp.substring(6,11))) + 12.0);
					}
				}
				hm.put(courseID, courseTime);
				hm.put(lecID, lecTime);
			}
		}
	}

}
