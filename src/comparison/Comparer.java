package comparison;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

public class Comparer
{
	private ArrayList<String> courseIdArr = new ArrayList<>();
	public Comparer(String input)
	{
		generateId(input);
	}
	
	public void  generateId(String line)
	{
		ArrayList<String> wordList = new ArrayList<>();
		
		boolean word = false;
			
			int endOfLine = (int) line.length() - 1;
			int startOfWord = 0;
			
			for(int i = 0; i < line.length(); i++){
			if((line.charAt(i) != ' ') && i != endOfLine){
				
					if(word == false)
						startOfWord = i;
				
					word = true;
				}else if((line.charAt(i) == ' ') && word){
					if((line.substring(startOfWord).length() == 5) && 
							(StringUtils.isNumeric(line.substring(startOfWord)))){
						wordList.add(line.substring(startOfWord, i));
					}else{
						System.out.println("Please try again and check for proper course Ids");
						break;
					}
					word = false;
				}else if(!(line.charAt(i) == ' ') && i == endOfLine){
					if((line.substring(startOfWord).length() == 5) && 
							(StringUtils.isNumeric(line.substring(startOfWord)))){
						wordList.add(line.substring(startOfWord, i));
					}
				}
			}
		this.courseIdArr = wordList;
	}
	
	public void compareCourses(ArrayList<String> courseId, HashMap<String,TimeInterval> hm)
	{
		TimeInterval[] courses = new TimeInterval[courseId.size()];
		ArrayList<Double> mondayTimes = new ArrayList<Double>();
		ArrayList<Double> mondayLength = new ArrayList<Double>();
		ArrayList<Double> tuesdayTimes = new ArrayList<Double>();
		ArrayList<Double> tuesdayLength = new ArrayList<Double>();
		ArrayList<Double> wednesdayTimes = new ArrayList<Double>();
		ArrayList<Double> wednesdayLength = new ArrayList<Double>();
		ArrayList<Double> thursdayTimes = new ArrayList<Double>();
		ArrayList<Double> thursdayLength = new ArrayList<Double>();
		ArrayList<Double> fridayTimes = new ArrayList<Double>();
		ArrayList<Double> fridayLength = new ArrayList<Double>();
		
		for(int i = 0; i < courseId.size(); i++)
		{
			courses[i] = hm.get(courseId.get(i));
		}
		for(TimeInterval temp: courses)
		{
			if(temp.isMonday())
			{
				mondayTimes.add(temp.getTimeBegin());
				mondayLength.add(temp.getTimeInterval());

			}
			if(temp.isTuesday())
			{
				tuesdayTimes.add(temp.getTimeBegin());
				tuesdayLength.add(temp.getTimeInterval());

			}
			if(temp.isWednesday())
			{
				wednesdayTimes.add(temp.getTimeBegin());
				wednesdayLength.add(temp.getTimeInterval());

			}
			if(temp.isThursday())
			{
				thursdayTimes.add(temp.getTimeBegin());
				thursdayLength.add(temp.getTimeInterval());
			}
			if(temp.isFriday())
			{
				fridayTimes.add(temp.getTimeBegin());
				fridayLength.add(temp.getTimeInterval());
			}
		}
		
		
		
		
	}
	
	public ArrayList<String> getCourseIdArr(){
		return courseIdArr;
	}
}