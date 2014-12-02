package grouph;


import java.awt.*;

import javax.swing.*;
import javax.swing.filechooser.*;

import java.io.*;
import java.util.*;


/**
 * Controller receives information in terms of Groups,
 * Students, Grades, Schedules and creates groups.
 * 
 */

public class Controller {
    
	//private GInterface gInterface;
	ArrayList<Group> groupList;	// The list that holds groups
	private Group group;
	private Student student;
    //private Match match;
	//private Project project;
	ArrayList<Student> StuList = new ArrayList<Student>(); // The list that holds students
	int groupSize;
	private String selectedFile;
	String str=""; String gStr = "";
	private JFileChooser chooser = new JFileChooser();
    private final String NEWLINE =  "\n";
	
   // public Controller()
    //{
    	//groupList = new ArrayList<Group>(0);
    	//StuList= new ArrayList<Student>(0);
    //}
	// parse string from csv file
	public void parseFile ( ) {
		StuList = new ArrayList<Student>();
		String line = "";
		final String DELIMITER = ",";
		
		
			FileNameExtensionFilter filter = new 						FileNameExtensionFilter(
            		"txt", "csv");
           		chooser.setFileFilter(filter);
            
           		int returnVal = chooser.showOpenDialog(null);
                
            		if(returnVal == JFileChooser.APPROVE_OPTION) {
            			System.out.println("You chose to open this file: " +
                		chooser.getSelectedFile().getName());
                        
            		}
            
                
			    try {
	        	    BufferedReader br = new BufferedReader(
	        		    new FileReader(chooser.getSelectedFile()));
                
	           
	        	    while ((line = br.readLine()) != null) {
	        	
		        	// use comma as separator
	        		    student = new Student();
				        String[] info = new String[3];
				        info = line.split(DELIMITER);
	        		    student.name = info[0];
	        		    student.id = info[1];
	        		   // student.gpa = Double.parseDouble(info[2]);
	        	        str = str +" "+ (info[0] +" "+ info[1] + " " + info[2] + NEWLINE);
	        		    StuList.add(student);
	        	    }
                
                }
                 catch (IOException ex) {
	       		JOptionPane.showMessageDialog(null,
	        		ex.getMessage());
	        	    
	   	        }
		
	  	}
	
	// receives the size of group 
	public void setGroupSize ( int size ) {
		groupSize = size;
	}
	
	// receives the Student list and make a group
	public void makeGroup ( ArrayList<Student> StudentList,int size) {
		//System.out.println(StudentList.get(1).getName());
		groupList = Match.makeGroups(StudentList,size);
        for(Group grp : this.groupList){
            gStr = gStr + grp.id +": " ;
            for(Student s: grp.groupMems)
            	{
            	gStr = gStr+s.getName()+", ";
            	}
            gStr= gStr.substring(0 , gStr.length()-2);
            gStr = gStr+ NEWLINE;
        }
	}
	
	public void makeGroupList ( Group group ) {
		groupList = new ArrayList<Group>();
		groupList.add(group);
	}
	
	/**
	public void load( String file ) {
		try {
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
            		"JPG & GIF Images", "jpg", "gif");
            chooser.setFileFilter(filter);
            
            int returnVal = chooser.showOpenDialog(parent);
            
            if(returnVal == JFileChooser.APPROVE_OPTION) {
            	System.out.println("You chose to open this file: " +
                chooser.getSelectedFile().getName());
            }
       	}
       	catch( Exception ex ) {
       		JOptionPane.showMessageDialog(null, ex.getMessage());
        }
	}

	public void save( String file ) {
		try {
            File fpw = new File( file );
            PrintWriter pw = new PrintWriter(fpw);
            pw.write( editArea.getText() );
            pw.close();
        }
        catch( Exception ex ) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
	}
	
	public Controller(){
		super();
	}
	
	**/


}

