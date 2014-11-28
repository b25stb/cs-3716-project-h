/**
 * 
 */
package grouph;

/**
 * A class that sets the basic parameters of a professor
 * @author stb
 *
 */
public class Prof 
{
	String name,id;
	//ArrayList<Course>
	
	public Prof()
	{}
	
	public Prof(String name,String id)
	{
		this.name = name;
		this.id=id;
	}
	
	void setID(String id)
	{
		this.id=id;
	}
	
	String getID()
	{
		return id;
	}
	
	String getName()
	{
		return name;
	}
}
