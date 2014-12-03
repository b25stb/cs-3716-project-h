package grouph;

import java.util.Random;

public class SimulateSelfEval 
{
	//Gives each student a value between 1-3 in 2 skills
	static void Simulate(Course c)
	{
		Random rand = new Random();
		for(Student s:c.classList)
		{
			int i = rand.nextInt(3)+1;
			int j = rand.nextInt(3)+1;
			Schedule sched = new Schedule(7,16);
			for(int x=0;x<7;x++)
			{
				for(int y=0;y<16;y++)
				{
					if(rand.nextInt(5)==0)
					{
						sched.setBlockBusy(x, y);
					}
					else
					{
						sched.setBlockFree(x, y);
					}
				}
			}
			s.getProperties().skills.add(i);
			s.getProperties().skills.add(j);
			s.getProperties().setSchedule(sched);
		}
		
			
	}
}
