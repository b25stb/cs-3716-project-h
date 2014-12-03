/**
 * 
 */
package grouph;

import java.util.ArrayList;

/**
 * Takes input from the initiator and saves it so it can be used later
 * @author stb
 *
 */
public class InitiatorMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		InitiatorInterface InUI = new InitiatorInterface();
		InUI.setVisible(true);
		ArrayList<String> profReq = InUI.input;
		//System.out.println(profReq.toString());
		//Simulates class
		Course course = Registry.getCourse(profReq.get(0));
		InUI.dispose();
		profReq.add(":");
		ForceGroups FG = new ForceGroups();
		FG.addStudents(course);
		FG.setVisible(true);
		ArrayList<String[]> force = FG.getForceMatches();
		ArrayList<String> forceMatch = new ArrayList<String>(0);
		for(String[] ss:force)
		{
			String out="";
			int j=0;
			for(String s:ss)
			{
				out=out+s;
				if(j==0)
				{
					out=out+"/";
				}
				j++;
			}
			forceMatch.add(out);
		}
		forceMatch.add(":");
		force = FG.getForcedSeperations();
		//Adds a pair of student id to list to write to file (Stu1/stu2)
		for(String[] ss:force)
		{
			String out="";
			int j=0;
			for(String s:ss)
			{
				out=out+s;
				if(j==0)
				{
					out=out+"/";
				}
				j++;
			}
			forceMatch.add(out);
		}
		FG.dispose();
		forceMatch.add(":");
		for(String s:forceMatch)
		{
			profReq.add(s);
		}
		MakeFileProfReq.makeFile("files/profreqs.csv",profReq);
	}

}
