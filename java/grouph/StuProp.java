/**
 * 
 */
package grouph;
import java.util.ArrayList;
/**
 * Holds properties of the student we can use to match students
 * @author stb
 *
 */
public class StuProp 
{
	//Schedule of a student
	Schedule schedule;
	//Lists of desired/forced matches and separations
	ArrayList<Student> desiredMatch, desiredApart;//, forceMatch, forceApart;
	//List of grades for completed courses
	ArrayList<Grade> marks;
	//List of values to represent skills from a self evaluation
	ArrayList<Integer> skills;
	
	/*
	 * Creates all empty student properties
	 */
	public StuProp()
	{
		schedule = new Schedule();
		desiredMatch = new ArrayList<Student>(0);
		desiredApart = new ArrayList<Student>(0);
		//forceMatch = new ArrayList<Student>(0);
		//forceApart = new ArrayList<Student>(0);
		marks = new ArrayList<Grade>(0);
		skills = new ArrayList<Integer>(0);
	}
	
	/*
	 * Makes properties with all initiated values
	 */
	public StuProp(Schedule schedule, ArrayList<Grade>marks ,
			//ArrayList<Student> forceMatch, ArrayList<Student> forceApart,
			ArrayList<Student> desiredMatch, ArrayList<Student> desiredApart,ArrayList<Integer> skills)
	{
		this.schedule =schedule;
		this.desiredMatch = desiredMatch;
		this.desiredApart = desiredApart;
		//this.forceApart = forceApart;
		//this.forceMatch =forceMatch;
		this.marks = marks;
		this.skills = skills;
	}
	
	/*
	 * Makes props where only the schedule has an initial value
	 */
	public StuProp(Schedule schedule)
	{
		this.schedule = schedule;
		desiredMatch = new ArrayList<Student>(0);
		desiredApart = new ArrayList<Student>(0);
		//forceMatch = new ArrayList<Student>(0);
		//forceApart = new ArrayList<Student>(0);
		marks = new ArrayList<Grade>(0);
		skills = new ArrayList<Integer>(0);
		
	}
	/*
	 * Set this students current Schedule
	 * @param schedule The new schedule
	 */
	void setSchedule(Schedule schedule)
	{
		this.schedule = schedule;
	}
	
	/*
	 * Gets the current schedule for this student
	 * @return The Current Schedule
	 */
	Schedule getSchedule()
	{
		return schedule;
	}
	
	/*
	 * Adds a skill value to the list of skill values
	 * @param skill the new skill to add to the list of skills 
	 */
	void addSkill(int skill)
	{
		skills.add(skill);
	}
	
	/*
	 * Gets the average value held by the skills entered
	 * If no skills were entered the student will have a score of 0
	 * @return The Average value of the skills entered by the student
	 */
	int getSkillValue()
	{
		int value=0;
		int count=0;
		for(int i:skills)
		{
			count++;
			value+=i;
		}
		if(count>0)
		{
			return (value/count);
		}
		return 0;
	}
	
	/*
	 * Gets the gpa of the student
	 * @return grade point average of this student
	 */
	double getGPA()
	{
		int total=0;
		int count=0;
		for(Grade g:marks)
		{
			count++;
			total += g.getMark();
		}
		if (count>0)
		{
		  return (total/count);
		}
		return 0;
	}
	
	/*
	 * Adds a Grade to the list of completed courses
	 * @param garde The new grade to add to the list of completed courses
	 */
	void addMark(Grade grade)
	{
		marks.add(grade);
	}
	
	/*
	 * returns a list of completed courses 
	 * @return List of grades
	 */
	ArrayList<Grade> getMarks()
	{
		return marks;
	}
	
	/*
	 * Sets the list of completed courses
	 * @param the list of courses completed
	 */	
	void setMarks(ArrayList<Grade> marks)
	{
		this.marks=marks;
	}
	
	/*
	 * Gets the list of students that this student wishes to be matched with
	 * @return The list of desired matches
	 */
	ArrayList<Student> getDesiredMatches()
	{
		return desiredMatch;
	}
	
	/*
	 * Adds a student to the list of desired matched
	 * @param student The student to be added
	 */
	void addDesiredMatch(Student student)
	{
		desiredMatch.add(student);
	}
	
	/*
	 * Gets a list of students that this student would prefer not to work with
	 * @return List of students they wish to be seprated from
	 */
	ArrayList<Student> getDesiredSeperations()
	{
		return desiredApart;
	}
	
	/*
	 * Adds a student to the list of undesireable matches
	 * @param student The student to be added
	 */
	void addDesiredApart(Student student)
	{
		desiredApart.add(student);
	}
	
	/*
	 * Gets the list of students this student has to be matched with if possible
	 * @return The list of students this studnt has to be matched with
	 */
	//ArrayList<Student> getForceMatches()
	{
		//return forceMatch;
	}
	
	/*
	 * Adds a student to the list of students this student must be matched with
	 * @param student The Student to be added 
	 */
	//void addForceMatch(Student student)
	{
		//forceMatch.add(student);
	}
	
	/*
	 * Removes a student from the list of forced to work together
	 * @param student The student to be removed
	 */
	//void removeForceMatch(Student student)
	{
		//forceMatch.remove(student);
	}
	
	/*
	 * Gets the list of students this cannot work with under any circumstances
	 * @return The list of banned matches for this student
	 */
	//ArrayList<Student> getForcedApart()
	{
		//return forceApart;
	}
	
	/*
	 * Adds a student to the list of students that this student cannot work with
	 * @param student The student to be added
	 */
	//void addForceApart(Student student)
	{
		//forceApart.add(student);
	}
	
	/*
	 * Remove a student from the force apart list
	 * @param student The student to be removed
	 */
	//void removeForceApart(Student student)
	{
		//forceApart.remove(student);
	}
}
