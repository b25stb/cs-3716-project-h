package grouph;


import java.awt.*;

import javax.swing.*;
import javax.swing.filechooser.*;

import java.io.*;
import java.util.*;


/**
 * Controller receives information in terms of Groups,
 * Students, Grades, Schedules and creates groups.
 * 
 */

public class Controller
{
	ProjectManager manager;
	ArrayList<Group> groups;
	int num;
	public Controller()
	{
		manager = new ProjectManager();
	}
	
	//Writes the inputs from initiator to a file for later use
	void makeFile(String path,ArrayList<String> input)
	{
		MakeFileProfReq.makeFile(path, input);
	}
	
	//Starts off the make groups method by reading a file to get project details
	void startGrouping(String path)
	{
		FileHandler fh = new FileHandler(path);
		String s = fh.getProperties();
		Scanner read = new Scanner(s);
		read.useDelimiter(",");
		manager.setCourse(Registry.getCourse(read.next()));
		manager.setGroupSize(Integer.parseInt(read.next()));
		String[] sa = {read.next(),read.next()};
		manager.setDeadline(sa);
		read.close();
		s=fh.getGrades();
		read = new Scanner(s);
		read.useDelimiter(",");
		while(read.hasNext())
		{
			manager.addMark(read.next());
		}
		read.close();
		s=fh.getForceMatches();
		read = new Scanner(s);
		read.useDelimiter(",");
		while(read.hasNext())
		{
			String temp = read.next();
			String[] stus = temp.split("/");	
			manager.addForceMatch(Registry.findStudentByID(stus[0]), Registry.findStudentByID(stus[1]));
		}
		read.close();
		s=fh.getForceSeparations();
		read = new Scanner(s);
		read.useDelimiter(",");
		while(read.hasNext())
		{
			String temp = read.next();
			String[] stus = temp.split("/");
			//Enter methods for getting stus[1] and stus[2]
			//add to arraylist of stus
		}
		//Set arraylist to manager
		read.close();	
	}
	
	//Fetches a list of match initiator needs
	ArrayList<Student[]> getForcedMatches()
	{
		return manager.getForcedMatches();
	}
	
	//Fetchs list of matchs that can not be made
	ArrayList<Student[]> getForcedSeparations()
	{
		return manager.getForceApart();
	}
	
	int getGroupSize()
	{
		return manager.getGroupSize();
	}
	
	Course getCourse()
	{
		return manager.getCourse();
	}
	
	boolean isDeadlineUp()
	{
		//Will return true for now as we are simulating
		return true;
	}
	
	
	//Used to find if we are allowed to match a pair of students
	boolean areForcedApart(Student stuA,Student stuB)
	{
		Student[] s = {stuA,stuB};
		if(this.getForcedSeparations().contains(s))
		{
			return true;
		}
		s[0]=stuB;
		s[1]=stuA;
		if(this.getForcedSeparations().contains(s))
		{
			return true;
		}
		return false;
	}
	
	//Gets number of groups
	void setNumberOfGroups()
	{
		int n = manager.getCourse().getClassList().size()/this.getGroupSize();
		if(manager.getCourse().getClassList().size()%this.getGroupSize()>0)
		{
			n++;
		}
		num= n;
	}
	
	//Set the group list
	void setGroupList(ArrayList<Group> g)
	{
		groups=g;
	}
    
	ArrayList<Group> getGroupList()
	{
		return groups;
	}
	
	int getGroupNum()
	{
		return num;
	}
	
	void setIDS()
	{
		char i='A';
		for(Group g:this.getGroupList())
		{
			g.setId(String.valueOf(i));
			i++;
		}
	}
    
}

