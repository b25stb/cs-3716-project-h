//A class to simulate how we will match students to a group

package grouph;

import java.io.*;
import java.util.*;


public class Match 

{
		
	//How a student fits into a group
        private static Controller controller = new Controller();
		
	//	double compatable;

		Group group;

		Student student;

		static ArrayList<Student> stuList;
		

		public static ArrayList<Group> makeGroups(ArrayList<Student> studentList,int size){
			//System.out.println("Check match 1");
	
			stuList =  studentList;
			
			ArrayList<Group> groupList = new ArrayList<Group>();
			int n = stuList.size();
			int idNum = 65;
			String id = "";
			int gSize = size;
			//System.out.println(n+" "+gSize);
			//System.out.println("Check match 1");
			for (int x=(n / gSize); x>0; x-- ){
				
				id = "Group " + Character.toString((char)idNum);
                Group grp = new Group();
                grp.setSize(gSize);
				for (int y=gSize-1; y>=0; y--)
				{
                    grp.setId(id);
                   // System.out.println("Check match 2");
                    //System.out.println(stuList.size());
					//System.out.println(stuList.get(0).getName()+" "+grp.groupMems.size());
					Student stu = stuList.remove(0);
					
					//System.out.println(stu.getName());
                    grp.add(stu);
                    //System.out.println("Check match 2");
					//stuList.remove(y);
                }
				groupList.add(grp);               
				idNum++;
            }
            
			if (stuList.size() > 0){
                int i=0;
                while (stuList.size() != 0) { 
                    Group grp = groupList.get(i);
                    grp.groupMems.add(stuList.get(0));
                    stuList.remove(0);
                    groupList.set(i, grp);
                    i++;
                    }
            }
			return groupList;	
		}

	/*	public Match(Student s,Group g)

		{

		//Checks compatibility using a single rule an keeps the location of the match

		compatable=Math.abs(((s.getId()+g.getId())/2.0)-((double)g.getParam()));

		student=s;

		group=g;

	}

	

	double getCompatability()

	{

		return compatable;

	}
	*/
	

	Student getStudent()

	{

		return student;

	}

	

	Group getGroup()

	{

		return group;

	}

}

