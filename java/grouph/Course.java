/**
 * 
 */
package grouph;

import java.util.ArrayList;

/**
 * A course has a List of students, a professor and a schedule is an input to the main program
 * @author stb
 *
 */
public class Course 
{
	//ID of a course
	String CRN;
	//List of students enrolled in course
	ArrayList<Student> classList;
	//Professor that teaches the course
	Prof prof;
	//Days the course takes place
	//mon-fri 24 hours a day
<<<<<<< HEAD
<<<<<<< HEAD
	Schedule schedule = new Schedule(5,16);
=======
	Schedule schedule = new Schedule(5,24);
>>>>>>> Shane
=======
	Schedule schedule = new Schedule(5,16);
>>>>>>> Shane
	
	/*
	 * Makes a empty course
	 */
	public Course()
	{
		CRN = "";
		classList = new  ArrayList<Student>(0);
		prof = new Prof();
	}
	
	/*
	 * makes a course with an id
	 */
	public Course(String CRN)
	{
		this.CRN = CRN;
		classList = new  ArrayList<Student>(0);
		prof = new Prof();
	}
	
	/*
	 * makes a course with an id and a prof
	 */
	public Course(String CRN,Prof prof)
	{
		this.CRN = CRN;
		this.prof = prof;
		classList = new ArrayList<Student>(0);
	}
	
	/*
	 * Create a course with an id,a prof and a list of students
	 */
	public Course(String CRN,Prof prof,ArrayList<Student> classList)
	{
		this.CRN = CRN;
		this.prof= prof;
		this.classList = classList;
	}
	
	/*
	 * Creates a course with all values initialized
	 */
	public Course(String CRN,Prof prof,ArrayList<Student> classList,Schedule schedule)
	{
		this.CRN = CRN;
		this.prof= prof;
		this.classList = classList;
		this.schedule = schedule;
	}
	
	/*
	 * Gets the id of this course
	 * @return The CRN of this course
	 */
	String getCRN()
	{
		return CRN;
	}
	
	/*
	 * Gets the professor who teaches the course
	 * @return the Professor
	 */
	Prof getProf()
	{
		return prof;
	}
	
	/*
	 * Gets the List of students who are enroled in this course
	 * @return The students taking the course
	 */
	ArrayList<Student> getClassList()
	{
		return classList;
	}
	
	/*
	 * Gets the schedule of the selected course
	 * @return The course schedule
	 */
	Schedule getSchedule()
	{
		return schedule;
	}
	
	/*
	 * Updates the CRN of this course
	 * @param CRN The new CRN value
	 */
	void setCRN(String CRN)
	{
		this.CRN=CRN;
	}
	
	/*
	 * Changes the professor in charge of the course
	 * @param prof The new Professor
	 */
	void setProf(Prof prof)
	{
		this.prof = prof;
	}
	
	/*
	 * Adds a student to this course
	 * @param student The student being added to the course
	 */
	void addStudent(Student student)
	{
		classList.add(student);
	}
	
	/*
	 * Removes a student to a course
	 * @param student The student being removed
	 */
	void removeStudent(Student student)
	{
		classList.remove(student);
	}
	
	/*
	 * Updates the class list with a new list of students
	 * @param classList The new class list
	 */
	void setClassList(ArrayList<Student> classList)
	{
		this.classList= classList;
	}
	
	/*
	 * Updates the schedule of the course
	 * @param schedule The new schedule
	 */
	void setSchedule(Schedule schedule)
	{
		this.schedule = schedule;
	}
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Shane
	
	/*
	 * Gets the size of the class
	 * @return The class size
	 */
	int size()
	{
		return classList.size();
	}
<<<<<<< HEAD
=======
>>>>>>> Shane
=======
>>>>>>> Shane
}
