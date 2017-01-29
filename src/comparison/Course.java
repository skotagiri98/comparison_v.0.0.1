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
	}

	public void setReaderInput(String readerInput) {
		this.line = readerInput;
	}
	
	public void generateSetOfWords(){
			
			ArrayList<String> wordList = new ArrayList<>();
			
			boolean word = false;
			
			try{
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
			} catch(NullPointerException e){
				
			}
			this.words = wordList;
		}
	
	public void generate(){
		
		for(String temp: this.words){
			if((temp.length() == 5) && (StringUtils.isNumeric(temp)))
				this.courseId = temp; 
		}
		
		for(String temp: this.words){
			if(temp.length() == 13 && temp.substring(11).equals("AM")){
				temp = temp.replaceAll("-"," ");
				temp = temp.replaceAll(":", ".");
				courseTime.setTimeBegin(Double.parseDouble(temp.substring(0, 5)));
				courseTime.setTimeEnd(Double.parseDouble(temp.substring(6,12)));
			} else if (temp.length() == 13 && temp.substring(11).equals("PM")){
				temp = temp.replaceAll("-"," ");
				temp = temp.replaceAll(":", ".");
				courseTime.setTimeBegin((Double.parseDouble(temp.substring(0, 5))) + 12.0);
				courseTime.setTimeEnd((Double.parseDouble(temp.substring(6,12))) + 12.0);
			}
		}
		
	}

	public String getCourseId() {
		return courseId;
	}
	
	public TimeInterval getCourseTime(){
		return this.courseTime;
	}

}
