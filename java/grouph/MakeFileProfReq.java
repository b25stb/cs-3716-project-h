/**
 * 
 */
package grouph;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author stb
 *
 */
public class MakeFileProfReq
{
	static String name;
	static ArrayList<String> input;
	public static void makeFile(String fileName,ArrayList<String> in)
	{
		input=in;
		name=fileName;
		try
		{
		    FileWriter writer = new FileWriter(name);
		    int count=0;
		    int lineCount = 0;
		    for(String s:input)
		    {
		    	count++;
		    	lineCount++;
		    	if(count>1&&!s.equals(":"))
		    	{
		    		writer.append(",");
		    	}
		    	if(s.equals(":"))
		    	{
		    		writer.append("\n");
		    		count=0;
		    	}
		    	else
		    	{
		    		writer.append(s);
		    	}
		    }
	 
		    writer.flush();
		    writer.close();
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		} 
		
	}
	
	
}
