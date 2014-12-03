package grouph;


//Allows us to swap out students from one group to another



public class Overview

{
	/*
	 * Swaps by removing students from the group and appending them at the end of the other group
	 * @param g1 A group to be edited
	 * @param g2 Another group to be edited
	 * @param stu1 The student from g1 to be swapped
	 * @param stu2 The student from g2 to be swapped
	 */
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

