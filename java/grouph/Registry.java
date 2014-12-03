package grouph;
//Makes a
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Simulates a small class list so we can load a course
 */

public class Registry 
{
	static Course course;

	static Course getCourse(String CRN)
	{
		course = new Course();
		char ch = 65;
		int id = 1;
		Student stu;
		ArrayList<Student> students = new ArrayList<Student>(0);
			for(int i=0;i<20;i++)
			{
				stu=new Student();
				stu.name="Student "+String.valueOf(ch);
				stu.id = "id#"+id;
				students.add(stu);
<<<<<<< HEAD
=======
				id++;
				ch++;
>>>>>>> Shane
			}
			course.classList.addAll(students);
			course.CRN=CRN;
			return course;
	}
}