package comparison;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws Exception{
		
		FileReader file = new FileReader("D:/Users/skota/Downloads/Spring_2017.txt");
		BufferedReader reader = new BufferedReader(file);
		CourseList spring2017 = new CourseList();
		
		String line = reader.readLine();
		
		while (line != null){
			Course temp = new Course(line);
			temp.generate();
			spring2017.setHmValues(temp.getCourseId(), temp.getCourseTime());
			line = reader.readLine();
		}
		
		for(String temp: spring2017.getHm().keySet()){
			
			double value = spring2017.getHm().get(temp).getTimeBegin();
			System.out.println("CourseId: " + temp + " " + "Time Begin: " + value);
		}
	}

		

}
