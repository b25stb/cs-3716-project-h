package grouph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MakeGroups 
{
	public static void main(String[] args)
	{
		try
		{
			File file = new File("files/profreqs.csv");
			Scanner reader = new Scanner(file);
			//Reads line from the file containing some reqirements
			// course id, Group size, dealine month, deadline day
			String line = reader.nextLine();
			Scanner lineReader = new Scanner(line);
			lineReader.useDelimiter(",");
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
