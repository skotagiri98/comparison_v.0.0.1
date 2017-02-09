package comparison;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.io.*;
import java.util.Scanner;


public class Main 
{

	public static void main(String[] args) throws Exception
	{
		
		FileReader file = new FileReader("Spring_2017.txt");
		BufferedReader reader = new BufferedReader(file);
		CourseList spring2017 = new CourseList();
		
		String line = reader.readLine();
		
		while (line != null)
		{
			Course temp = new Course(line);
			temp.generate();
			spring2017.setHmValues(temp.getCourseId(), temp.getCourseTime());
			line = reader.readLine();
		}
		
		System.out.println("Enter class numbers with a "
				+ "space in between each inputted class number, hit enter at end.");
		Scanner scan = new Scanner(System.in);
		String classNums = scan.nextLine();
	}
}