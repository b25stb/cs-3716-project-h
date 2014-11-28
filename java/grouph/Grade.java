package grouph;

/*
 * Grade is comtbprised of a course and a mark.
 */
public class Grade 
{
	//Id is the course
	String id;
	//Mark is a number representation of the letter grade
	int mark;
	//private Controller controller = new Controller();
	//Empty Constructor
	public Grade()
	{}
	
	/*
	 * Make a grade with a course id and a grade
	 * @param id The id to represent the course
	 * @param grade The mark achieved in the course
	 */
	public Grade(String id,int mark)
	{
		this.id=id;
		this.mark=mark;
	}
	
	/*
	 * Gets the id of a course
	 * @return The id of the course from this grade
	 */
	String getCourseID()
	{
		return id;
	}
	
	/*
	 * Gets the Mark Achieved in the course
	 * @return The Mark acheived in this Course
	 */
	int getMark()
	{
		return mark;
	}
	
	/*
	 * Set the course id
	 * @param id the ID of the new course
	 */
	void setCourse(String id)
	{
		this.id=id;
	}
	
	/*
	 * Sets the new mark for the course
	 * @param mark The new mark for the course
	 */
	void setGrade(int mark)
	{
		this.mark=mark;
	}
	
	/*
	 * Gets the letter grade associated with the Mark
	 * @return The Letter grade for the course
	 */
	String markToString()
	{
		switch(this.mark)
		{
		case 1: return "F";
		case 2: return "D";
		case 3: return "C";
		case 4: return "B";
		case 5: return "A";
		}
		return"ERROR GRADE OUT OF RANGE";
	}
	
}
