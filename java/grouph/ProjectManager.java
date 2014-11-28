/**
 * 
 */
package grouph;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Holds all values for 
 * @author stb
 *
 */
public class ProjectManager 
{
	GregorianCalendar deadline;
	ArrayList<Student[]> forceMatch,forceApart;
	Course course;
	int size;
	ArrayList<Course> marks;
	
	//Creates a blank project manager
	public ProjectManager()
	{
		forceMatch = new ArrayList<Student[]>(0);
		forceApart = new ArrayList<Student[]>(0);
		marks = new ArrayList<Course>(0);
	}
	
	/*
	 * Gets a list of important marks
	 * @return The list of important marks
	 */
	ArrayList<Course> getReqMarks()
	{
		return marks;
	}
	
	/*
	 * Adds a reqired Course to list of important grades
	 * @param course The course being added
	 */
	void addMark(Course course)
	{
		marks.add(course);
	}
	
	/*
	 * Removes a course from list of important courses
	 */
	void removeMark(Course course)
	{
		if(marks.contains(course))
		{
			marks.remove(course);
		}
	}
	/*
	 * gets the Max size of the groups
	 * @return The max size of the groups
	 */
	int getGroupSize()
	{
		return size;
	}
	
	/*
	 * Sets the size of a group
	 * @param size the new max group size
	 */
	void setGroupSize(int size)
	{
		this.size=size;
	}
	
	/*
	 * Gets the deadline for students to enter data
	 * @return The deadline for entries
	 */
	GregorianCalendar getDeadline()
	{
		return deadline;
	}
	
	/*
	 * Sets the date for the deadline
	 * @param deadline The new deadline
	 */
	void setDeadline(GregorianCalendar deadline)
	{
		this.deadline = deadline;
	}
	
	/*
	 * Gets a list of students that have to work together
	 * @return The list of students to force together
	 */
	ArrayList<Student[]> getForcedMatches()
	{
		return forceMatch;
	}
	
	/*
	 * Adds a pair of students to be forced matched
	 * @param stu1 student to be matched
	 * @param stu2 student to be matched
	 */
	void addForceMatch(Student stu1,Student stu2)
	{
		Student[] stu = {stu1,stu2}; 
		forceMatch.add(stu);
	}
	
	/*
	 * Removes a pair of students from the list of forced matches
	 * @param stu1 the first student
	 * @param stu2 the second student
	 */
	void removeForceMatch(Student stu1,Student stu2)
	{
		Student[] stu = {stu1,stu2};
		if(forceMatch.contains(stu))
		{
			forceMatch.remove(stu);
		}
		Student[] stuR = {stu2,stu1};
		if(forceMatch.contains(stuR))
		{
			forceMatch.remove(stuR);
		}
		
	}
	
	/*
	 * Gets list of students to be forced apart
	 * @return The list of students to be separated
	 */
	ArrayList<Student[]> getForceApart()
	{
		return forceApart;
	}
	
	/*
	 * Adds a pair of students to be seperated
	 * @param stu1 the first student
	 * @param stu2 the second student
	 */
	void addForceApart(Student stu1,Student stu2)
	{
		Student[] stu = {stu1,stu2};
		forceApart.add(stu);
	}
	
	/*
	 * Removes a pair of students from list of forced apart students
	 * @param stu1 the first student
	 * @param stu2 the second student
	 */
	void removeForceApart(Student stu1,Student stu2)
	{
		Student[] stu = {stu1,stu2};
		if(forceApart.contains(stu))
		{
			forceApart.remove(stu);
		}
		Student[] stuR = {stu2,stu1};
		if(forceApart.contains(stuR))
		{
			forceApart.remove(stuR);
		}
	}

	/*
	 * Gets the course the groups are being made for
	 * @return The Course
	 */
	Course getCourse()
	{
		return course;
	}
	
	/*
	 * Sets a course for matching
	 * @param course The new course
	 */
	void setCourse(Course course)
	{
		this.course = course;
	}
}
