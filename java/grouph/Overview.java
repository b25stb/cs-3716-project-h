package grouph;

//Allows us to swap out students from one group to another



public class Overview

{
	//private Controller controller = new Controller();
	static void swap(Group g1,Group g2,Student stu1,Student stu2)

	{

		if(g1.isInGroup(stu1)&&g2.isInGroup(stu2))

		{

			g1.remove(stu1);

			g2.remove(stu2);

			g1.add(stu2);

			g2.add(stu1);

		}

	}

}

