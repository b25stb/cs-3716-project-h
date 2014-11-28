package grouph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Simulates a small class list so we can load a course
 */

public class Registry 
{
	Map<String,Course> listOfClasses = new HashMap<String,Course>();

	char ch = 65;
	int id = 1;
	Student stu;
	ArrayList<Student> students = new ArrayList<Student>(0);
	{
	for(int i=0;i<20;i++)
	{
		stu=new Student();
		stu.name="Student "+String.valueOf(ch);
		stu.id = "id#"+id;
		students.add(stu);
	}
	Course cs3715 = new Course();
	cs3715.setCRN("3715");
	cs3715.classList.addAll(students);
	
	Course cs3716 = new Course();
	cs3716.setCRN("3716");
	cs3716.classList.addAll(students);
	
	Course cs7969 = new Course();
	cs7969.setCRN("7969");
	cs7969.classList.addAll(students);
	
	listOfClasses.put("3715", cs3715);
	listOfClasses.put("3716", cs3716);
	listOfClasses.put("7969", cs7969);
	
}
}