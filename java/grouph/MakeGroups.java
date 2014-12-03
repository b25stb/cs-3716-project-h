package grouph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MakeGroups 
{
	public static void main(String[] args)
	{
		Controller con = new Controller();
		con.startGrouping("files/profreqs.csv");
		if(con.isDeadlineUp())
		{
			Course course = con.getCourse();
			ArrayList<Student> classList= course.getClassList();
			System.out.println(course.getCRN());
			int groupSize = con.getGroupSize();
			System.out.println(groupSize);
			int numOfGroups = classList.size()/groupSize;
			System.out.println(numOfGroups);
			//Adds Extra group if needed
			if(classList.size()%groupSize>0)
			{
				numOfGroups++;
			}
			ArrayList<Group> groupList = new ArrayList<Group>(0);
			ArrayList<Student[]> forceMatches = con.getForcedMatches();
			ArrayList<Student[]> forceApart = con.getForcedSeparations();
			//Add matching
			
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Deadline is not met yet.");
		}
	}

}
