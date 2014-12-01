package grouph;

import java.util.ArrayList;

/**
 * The groups that members will be added to
 * @author stb
 *
 */
public class Group 
{
	//Max size of a group
	private Controller controller = new Controller();
	int size = controller.groupSize;
	//The group that will hold students
	public ArrayList<Student> groupMems;
	//The id for the group
	String id;
	
	public Group()
	{
		groupMems = new ArrayList<Student>( 0 );
	}
	/*
	 * Makes a group that cannot exceed a certain size
	 * @param size the max size of a group
	 * @param id The id to describe this group
	 */
	public Group( int size, String id )
	{
		this.size=size;
		this.id=id;
		groupMems = new ArrayList<Student>( 0 );
	}
	
	/*
	 * Returns if a group is at max capacity or not
	 * @return is the group is full
	 */
	public boolean isFull()
	{
		return ( this.size == groupMems.size() );
	}
	
	/* 
	 * Returns the number of members in a group
	 * @return The number of members in the group
	 */
	public int numOfStudents()
	{
		return groupMems.size();
	}
	
	/*
	 * Finds if a student is in a group
	 * @return Is student in group
	 */
	public boolean isInGroup( Student stu )
	{
		return groupMems.contains( stu );
	}
	
	/*
	 * Adds a student to a group if there is room
	 * @param stu The student we attempt to add to add to a group
	 */
	public void add( Student stu ) {
		if( !this.isFull() ) {
			groupMems.add( stu );
		}
	}
	
	/*
	 * Removes a student from a group if they are in it
	 * @param The student to be removed
	 */
	public void remove( Student stu ) {
		if( this.isInGroup( stu ) ) {
			groupMems.remove( stu );
		}
	}
	
	/*
	 * This Will return an arraylist of the members in a group
	 * @return The group
	 */
	public Group getGroup( String id ) {
		for( int x = controller.groupList.size(); x == 0; x-- ){
			Group grp = (controller.groupList.get(x));
			
			if( grp.id == id ) {
				return grp;
			}
		}
		
		return null;
	}
	/*
	 * Sets the id of a group
	 * @param id The new id for the group
	 */
	public void setId( String id ) {
		this.id = id;
	}
	
	/*
	 * Gets the id of a group
	 * @return The group id
	 */
	public String getId() {
		return this.id;
	}
	
	/*
	 * Returns a string implementation of the members in a group
	 * @return List of members in a group
	 */
	public String groupToString() {
		String out="";
		
		for( Student student: this.groupMems ) {
			out = out + student.getName() + ", ";
		}
		
		return out;
	}
	
	/*
	 * Sets the max size of the groups
	 * @param size the size of the groups
	 */
	public void setSize( int size ) {
		this.size=size;
	}
	
}
