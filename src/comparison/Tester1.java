package comparison;

import java.util.ArrayList;
import java.util.Arrays;

public class Tester1 
{
	public static void main(String args[])
	{
		AllCourses test = new AllCourses();
		ArrayList<String> line1 = new ArrayList<>(Arrays.asList("LEC","01","TUTH","07:00-08:20PM","FREY","HALL","100"));
		ArrayList<String> line2 = new ArrayList<>(Arrays.asList("40202","LAB","L01","MW","08:30-9:50AM"));
		ArrayList<String> line3 = new ArrayList<>(Arrays.asList("40203","LAB","L01","MW","08:30-9:50AM"));
		ArrayList<String> line4 = new ArrayList<>(Arrays.asList("40204","LAB","L01","MW","08:30-9:50AM"));
		test.addLine(line1);
		test.addLine(line2);
		test.addLine(line3);
		test.addLine(line4);
		test.makeClasses();
		test.hm.forEach((k,v)-> System.out.println(k+", "+v));
	}
}
