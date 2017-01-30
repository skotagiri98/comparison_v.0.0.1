package comparison;

import java.util.ArrayList;

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
	
	public ArrayList<String> getCourseIdArr(){
		return courseIdArr;
	}
}
