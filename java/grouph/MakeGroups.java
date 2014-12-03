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
			SimulateSelfEval.Simulate(course);
			ArrayList<Student> classList= course.getClassList();
			con.setGroupList(new ArrayList<Group>(0));
			ArrayList<Student[]> forceMatches = con.getForcedMatches();
			ArrayList<Student[]> forceApart = con.getForcedSeparations();
			con.setNumberOfGroups();
			//Do force matching
			for(Student[] s:forceMatches)
			{
				Student stuA=s[0];
				Student stuB=s[1];
				boolean bool = Match.forceMatch(stuA, stuB, con);
				if(bool)
				{
					if(classList.contains(stuA))
					{
						classList.remove(stuA);
					}
					if(classList.contains(stuB))
					{
						classList.remove(stuB);
					}
					//System.out.println(classList.size());
				}
			}
			//System.out.println(classList.size()+" "+con.getGroupList().size()+" "+con.getGroupNum());
			int counter = con.getGroupList().size();
			while(counter<con.getGroupNum()){
				Match.startMatch(classList, con);
				counter++;
			}
			//System.out.println(classList.size()+" "+con.getGroupList().size());
			
			counter=0;
			while(counter>classList.size())
			{
				boolean bool=Match.matchSkills(classList.get(counter), con);
				if(bool)
				{
					classList.remove(0);
				}
				else
				{
				counter++;
				}
			}
			
			counter = classList.size();
			while(counter>0)
			{
				//System.out.println("HI");
				Match.matchRest(classList.remove(0), con);
				counter--;
			}
			con.setIDS();

			OverViewInterface ui = new OverViewInterface();
			ui.makeList(con.getGroupList());
			ui.setVisible(true);
			WriteFile.write("files/Groups.java", con.getGroupList());
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Deadline is not met yet.");
		}
	}

}
