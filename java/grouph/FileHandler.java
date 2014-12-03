/**
 * 
 */
package grouph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author stb
 *
 */
public class FileHandler 
{
	String props;
	String skills;
	String grades;
	String forceMatch;
	String forceApart;
	
	public FileHandler(String path)
	{
		try
		{
			File file = new File(path);
			Scanner reader = new Scanner(file);
			props = reader.nextLine();
			skills= reader.nextLine();
			grades= reader.nextLine();
			forceMatch = reader.nextLine();
			forceApart = reader.nextLine();
			reader.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	String getProperties()
	{
		return props;
	}
	
	String getSkills()
	{
		return skills;
	}
	
	String getForceMatches()
	{
		return forceMatch;
	}
	
	String getForceSeparations()
	{
		return forceApart;
	}
	
	String getGrades()
	{
		return grades;
	}
}
