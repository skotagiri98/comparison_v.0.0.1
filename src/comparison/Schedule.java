package comparison;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;


public class Schedule {
	
	public static ArrayList<String> generateSetOfWords(String input){
		
		String line = input;
		
		ArrayList<String> wordList = new ArrayList<>();
		
		boolean word = false;
		
		int endOfLine = line.length() - 1;
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
		
		return wordList;
		
	}
	
	/*public static boolean isCourseNumber(String word){
		if((word.length() == 5) && (StringUtils.isNumeric(word)))
			return true;
		else return false;
	}
	
	public static boolean isCourseTime(String word){
		if(word.substring(11) == "AM" || word.substring(11) == "PM"){
			return true;
		}else return false;
	}*/
	
	public static TimeInterval findTime(ArrayList<String> list){
		
		String time = null;
		TimeInterval interval = new TimeInterval();
		
		for(String temp: list){
			if(temp.substring(11) == "AM"){
				time = temp.replaceAll("-"," ");
				time = time.replaceAll(":", ".");
				interval.setTimeBegin(Double.parseDouble(time.substring(0, 5)));
				interval.setTimeEnd(Double.parseDouble(time.substring(6,11)));
			} else if (temp.substring(11) == "PM"){
				time = temp.replaceAll("-"," ");
				time = time.replaceAll(":", ".");
				interval.setTimeBegin(Double.parseDouble(time.substring(0, 5)) + 12);
				interval.setTimeEnd(Double.parseDouble(time.substring(6,11)) + 12);
			}
		}
		return interval;
		
	}
	
	/*public static String findCourseNumber(ArrayList<String> list){
		
		for(String temp: this.words){
			if((temp.length() == 5) && (StringUtils.isNumeric(temp)){
				this.courseId = list.get(i);
			} 
		}
		
		for(String temp: this.words){
			if(temp.substring(11) == "AM"){
				time = temp.replaceAll("-"," ");
				time = time.replaceAll(":", ".");
				courseTime.setTimeBegin(Double.parseDouble(time.substring(0, 5)));
				courseTime.setTimeEnd(Double.parseDouble(time.substring(6,11)));
			} else if (temp.substring(11) == "PM"){
				time = temp.replaceAll("-"," ");
				time = time.replaceAll(":", ".");
				courseTime.setTimeBegin(Double.parseDouble(time.substring(0, 5)) + 12);
				courseTime.setTimeEnd(Double.parseDouble(time.substring(6,11)) + 12);
			}
		}
	}*/
	
	public  HashMap<String, TimeInterval> constructHashmap() throws Exception{
		HashMap<String, TimeInterval> hm = new HashMap<>();
		
		ArrayList<String> words = new ArrayList<>();
		FileReader file = new FileReader("D:/Users/skota/Downloads/Spring_2017.txt");
		BufferedReader reader = new BufferedReader(file);
		
		String line = reader.readLine();
		while(line != null){
			
			words = generateSetOfWords(line);
			if((findCourseNumber(words) != " ") && (findTime(words).getTimeBegin() != 0)){
				hm.put(findCourseNumber(words), findTime(words));
			}
			
			line = reader.readLine();
			
		}
		reader.close();
		return hm;
	}
	
}
	
