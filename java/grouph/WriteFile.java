//Writes groups to file
package grouph;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
public class WriteFile 
{	
	static void write(String name,ArrayList<Group> GL)
	{try{
		FileWriter writer = new FileWriter(name);
	    char A = 'A';
	    int count=-1;
	    for(Group g:GL)
	    {
	    	count++;
	    	writer.append("Group "+String.valueOf((char)(A+count))+": "+g.toString()+"\n");
	    }
 
	    writer.flush();
	    writer.close();
	}
	catch(IOException e)
	{
	     e.printStackTrace();
	} 
}}

