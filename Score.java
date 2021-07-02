/*
Write a program to input the name, subject, and marks of a student. The program throw a 
user-defined exception "NotPassed" if the entered marks are less than 40.
Use InputStreamReader and BufferedReader class for reading the data from keyboard.
*/
import java.util.*;
import java.io.*;
class NotPassed extends Exception
{
	public NotPassed( String msg)
	{
		super(msg);
	}
	
}


class Score
{
	void marksCheck(int[] marks)throws NotPassed
	{
		for(int i=0; i<marks.length; i++)
		{
			if(marks[i] <40)
			{
				throw new NotPassed("Fail !");
			}
		}
	}
	public static void main(String args[])throws IOException, ArithmeticException
	{
		DataInputStream ds = new DataInputStream(System.in);
		String name;
		System.out.println("Enter Your Name : ");
		name = ds.readLine();
		System.out.println("How many subject you study :");
		int NoOfSubject = Integer.parseInt(ds.readLine());
		String subject[] = new String[NoOfSubject];
		int marks[]= new int[NoOfSubject];
		System.out.println("Enter subject name and marks respectively : ");
		for(int i=0; i<=NoOfSubject-1; i++)
		{
			subject[i] = ds.readLine();
			marks[i] = Integer.parseInt(ds.readLine());
		}
		Score obj = new Score();
		try
		{
			obj.marksCheck(marks);
		}
		catch(NotPassed np)
		{
			System.out.println("Exception caught");
			System.out.println("NotPassed :"+np.getMessage());
		}
	}
}