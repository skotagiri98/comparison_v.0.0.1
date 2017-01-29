
package comparison;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;

public class Course {

	private String line = "";
	private ArrayList<String> words = new ArrayList<>();
	private String courseId;
	private TimeInterval courseTime;
	
	public Course(String readerInput){
		this.line = readerInput;
		generateSetOfWords();
		courseTime = new TimeInterval();
	}

	public void setReaderInput(String readerInput) {
		this.line = readerInput;
	}
	
	public void generateSetOfWords(){
			
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
						wordList.add(line.substring(startOfWord, i));
						word = false;
					}else if(!(line.charAt(i) == ' ') && i == endOfLine){
						wordList.add(line.substring(startOfWord));
					}
				}
			this.words = wordList;
		}
	
	public void generate()
	{
		
		for(String temp: this.words)
		{
			if((temp.length() == 5) && (StringUtils.isNumeric(temp)))
				this.courseId = temp; 
		}
		
		for(String temp: this.words)
		{
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
		String days = words.get(3);
		while(days.length() >=  0)
		{
			if(days.charAt(0) == 'M')
			{
				courseTime.setDaysInWeek(0);
				days = days.substring(1);
			}
			else if(days.charAt(0) == 'W')
			{
				courseTime.setDaysInWeek(2);
				days = days.substring(1);
			}
			else if(days.charAt(0) == 'T')
			{
				if(days.charAt(1) =='U')
				{
					courseTime.setDaysInWeek(1);
					days = days.substring(2);
				}
				else if(days.charAt(1) =='H')
				{
					courseTime.setDaysInWeek(1);
					days = days.substring(2);
				}
			}
			else if(days.charAt(0) == 'F')
			{
				courseTime.setDaysInWeek(4);
				days = days.substring(1);
			}
		}
	}

	public String getCourseId() 
	{
		return courseId;
	}
	
	public TimeInterval getCourseTime(){
		return this.courseTime;
	}

}
