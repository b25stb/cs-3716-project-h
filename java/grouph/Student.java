/**
 * 
 */
package grouph;

/**
 * Creates a student that will be added to a group
 * @author stb
 *
 */
public class Student
{
	//private Controller controller = new Controller();
	String name;
	String id;
	StuProp params;
	//Moved to StuProps double gpa;
	/*
	 * Empty Constructor
	 */
	public Student()
	{
		params = new StuProp();
	}
	
	/*
	 * Makes a student object with a name and an id
	 * @param name
	 * @param id The unique id
	 */
	public Student(String name,String id, double gpa) {
		this.name = name;
		this.id = id;
		params = new StuProp();
		//this.gpa = gpa;
	}
	
	/*
	 * makes a student with a name,an id and a set of parameters
	 * @param name 
	 * @param id
	 * @param params The parameters we will be using to match students
	 */
	public Student(String name,String id,StuProp params)
	{
		this.name=name;
		this.id=id;
		this.params=params;
	}
	/*
	 * Gets the students name
	 * @return The given name
	 */
	String getName()
	{
		return name;
	}
	
	/*
	 * Gets the students id
	 * @return The id of the student
	 */
	String getId()
	{
		return id;
	}
	
	/*
	 * Returns the parameters used for matching 
	 * @return the properties of this student used in matching
	 */
	StuProp getProperties()
	{
		return params;
	}
	
	/*
	 * Updates the parameters this student holds
	 * @param params The new set of properties to match student
	 */
	void setProperties(StuProp params)
	{
		this.params = params;
	}
}
