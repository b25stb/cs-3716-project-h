/**
 * 
 */
package grouph;


/**
 * A class that will create a 2D array of Boolean values that will determine if students are free 
 * at certain times during the day.Schedule is made of blocks that are divided into days and hours.
 *  If free a block will be true if busy a block will be false.
 * @author stb
 *
 */
public class Schedule 
{
	//private Controller controller = new Controller();
	//The 2D representation of a schedule
	boolean[][] schedule;
	
	/*
	 * Creates a Schedule for 24 hours and 7 days
	 */
	public Schedule()
	{
		schedule = new boolean[7][24];
		this.initialize();
	}
	
	/*
	 * Creates a schedule with a set number of days and hours
	 * @param days The number of days we are considering for the schedule
	 * @param hours The number of hours a day we consider for the schedule
	 */
	public Schedule(int days,int hours)
	{
		schedule = new boolean[days][hours];
		this.initialize();
	}
	
	/*
	 * Initializes the schedule to all free time
	 */
	void initialize()
	{
		for(int i=0;i<this.getDays();i++)
		{
			for(int j=0;j<this.getHours();j++)
			{
				schedule[i][j]=true;
			}
		}
	}
	
	/*
	 * Gets the number of days in a schedule
	 * @return The number of days in this schedule
	 */
	int getDays()
	{
		return schedule.length;
	}
	
	/*
	 * Gets the number of hours in a day of the schedule
	 * @return The number of hours the schedule considers in a day
	 */
	int getHours()
	{
		return schedule[0].length;
	}
	
	/*
	 * Gets the state of a certain block of the schedule
	 * @param day The selected day we are considering
	 * @param hour The Selected hour of the day we are considering
	 */
	boolean getBlock(int day,int hour)
	{
		return schedule[day][hour];
	}
	
	/*
	 * Changes a block to busy
	 * @param day The Selected day
	 * @param hour The Selected hour of the day
	 */
	void setBlockBusy(int day,int hour)
	{
		schedule[day][hour] = false;
	}
	
	/*
	 * Changes a block to free 
	 * @param day Selected day of the schedule
	 * @param hour Selected hour of the day
	 */
	void setBlockFree(int day,int hour)
	{
		schedule[day][hour]=true;
	}
	
	/*
	 * Returns a 2D array representing the schedule
	 * @return The schedule
	 */
	boolean[][] getSchedule()
	{
		return schedule;
	}
	
	/*
	 * Returns a string representation of if a block is free or busy
	 * @return State of the Block
	 */
	String blockToString(int day,int hour)
	{
		if(this.getBlock(day, hour)==true)
		{
			return "Free";
		}
		return "Busy";
	}
	
	/*
	 * Combines two schedules by getting all busy times from one schedule and adding them to this one
	 * @param schedule The schedule we are adding to this schedule
	 */
	void merge(Schedule schedule)
	{
		for(int i = 0;i<schedule.getDays();i++)
		{
			for(int j=0;j<schedule.getHours();j++)
			{
				if(schedule.getBlock(i, j) == false)
				{
					this.setBlockBusy(i,j);
				}
			}
		}
	}
	
	/*
	 * Returns number of blocks that each shedule has free
	 * @return The number of timeslots two schedule are free
	 */
	int compare(Schedule schedule)
	{
		int x = this.getDays();
		int y = this.getHours();
		int count=0;
		for(int i=0;i<x;i++)
		{
			for(int j =0;j<y;j++)
			{
				if(this.getBlock(i, j)==schedule.getBlock(i, j))
				{
					count++;
				}
			}
		}
		return count;
	}
}
