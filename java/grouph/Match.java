//A class to simulate how we will match students to a group

package grouph;

import java.io.*;
import java.util.*;


public class Match 
{	
	//Makes a forced matched if possible
	static boolean forceMatch(Student stuA,Student stuB,Controller con)
	{
		boolean matched=false;
		for(Group g:con.getGroupList())
		{
			//System.out.println(g.groupMems.size());
			if(g.isInGroup(stuA)&&!g.isFull())
			{
				for(Group g2:con.getGroupList())
				{
					if(g2.isInGroup(stuB)&&!(g==g2))
					{
						if((g2.groupMems.size()+g.groupMems.size())<con.getGroupSize())
						{
							for(Student s:g2.groupMems)
							{
								g.groupMems.add(s);
							}
							con.getGroupList().remove(g2);
							matched=true;
							break;
						}
						matched=true;
					}
				}
				if(!matched)
				{
					g.groupMems.add(stuB);
					matched=true;
				}
			}
			else if(g.isInGroup(stuB)&&!g.isFull()&&!matched)
			{
				g.groupMems.add(stuA);
				matched=true;
			}
		}
		if(!matched)
		{
			if(con.getGroupList().size()<con.getGroupNum())
			{
				Group g = new Group();
				g.groupMems.add(stuA);
				g.groupMems.add(stuB);
				con.getGroupList().add(g);
				//System.out.println(g.groupMems.size());
				matched=true;
			}
			else
			{
				for(Group g:con.getGroupList())
				{
					if(g.groupMems.size()-con.getGroupSize()>1&&!matched)
					{
						g.groupMems.add(stuA);
						g.groupMems.add(stuB);
						matched=true;
					}
				}
				
			}
		}
		return matched;
	}
	
	static void startMatch(ArrayList<Student> classList,Controller con)
	{
		//Make sure there are no empty groups
			Group g = new Group();
			g.groupMems.add(classList.remove(0));
			con.getGroupList().add(g);
	}
	
	//Cheezey way to match students based on skills and schedule// didn't work out schedule
	static boolean matchSkills(Student stu, Controller con)
	{
		{
			for(Group g:con.getGroupList())
			{
				int skill=0;
				for(Student s:g.groupMems)
				{
					skill=+s.getProperties().getSkillValue();
				}
				skill=skill/g.groupMems.size();
				if(!(g.groupMems.size()==con.getGroupSize())&&Math.abs(skill-stu.getProperties().getSkillValue())<2)
				{
				    g.groupMems.add(stu);
				    return true;
				}
			}
			
		}
		return false;
	}
	
	static void matchRest(Student stu, Controller con)
	{
		for(Group g:con.getGroupList())
		{
			if(!(g.groupMems.size()==con.getGroupSize()))
			{
				g.groupMems.add(stu);
				break;
			}
		}
	}
	
	/*
	
	static boolean matchDesired(Student stuA,Student stuB,Controller con)
	{
		if(stuA.getProperties().getDesiredMatches().contains(stuB) && stuB.getProperties().getDesiredMatches().contains(stuA))
		{
			//Check to see if match is allowed
			if(con.areForcedApart(stuA,stuB))
			{}
			else
			{
				//If both desire to be matched
				if(stuA.getProperties().getDesiredMatches().contains(stuB)&&stuB.getProperties().getDesiredMatches().contains(stuA))
				{
					boolean matched=false;
					for(Group g: con.getGroupList())
					{
						if(g.isInGroup(stuA)&&!g.isFull())
						{
							g.add(stuB);
							matched=true;
						}
						else if(g.isInGroup(stuB)&&!g.isFull())
						{
							g.add(stuA);
							matched=true;
						}
					}
					if(!matched)
					{
						if(con.getGroupList().size()<con.getNumberOfGroups())
						{
							Group g = new Group();
							g.groupMems.add(stuA);
							g.groupMems.add(stuB);
							con.getGroupList().add(g);
							matched=true;
						}
					}
					return matched;	
				}
				
			}
		}
		return false;
	}
	*/
	
	
}

