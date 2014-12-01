package grouph;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

<<<<<<< HEAD
	/**
	 * Entrance GUI for instructor, to decide course ID and group size
	 * Call the skill and courses to consider input interface
	 * @arg course ID
	 * @arg group size
	 */
	 
=======
>>>>>>> Shane
public class InitiatorInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtCourseID;
	private JTextField txtSize;
	private JTextField txtMonth;
	private JTextField txtDd;
	ArrayList<String> skillList = new ArrayList<String>(0);
	ArrayList<String> courseList = new ArrayList<String>(0);
<<<<<<< HEAD
	//SkillDialog skill = new SkillDialog();
=======
>>>>>>> Shane


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitiatorInterface frame = new InitiatorInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InitiatorInterface() {
		setTitle("Let's make some Groups");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 318, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterCourseId = new JLabel("Enter Course ID");
		lblEnterCourseId.setBounds(37, 11, 135, 36);
		contentPane.add(lblEnterCourseId);
		
		txtCourseID = new JTextField();
		txtCourseID.setBounds(153, 19, 126, 20);
		contentPane.add(txtCourseID);
		txtCourseID.setColumns(10);
		
		JLabel lblEnterGroupsize = new JLabel("Enter GroupSize");
		lblEnterGroupsize.setBounds(37, 53, 135, 14);
		contentPane.add(lblEnterGroupsize);
		
		txtSize = new JTextField();
		txtSize.setBounds(153, 50, 126, 20);
		contentPane.add(txtSize);
		txtSize.setColumns(10);
		
		JButton btnSkills = new JButton("Enter Skills");
		btnSkills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SkillDialog skill = new SkillDialog();
				skill.setVisible(true);
				skillList = skill.getSkills();
				skill.dispose();
<<<<<<< HEAD
				//System.out.println(skillList.get(0)+"\n"+skillList.get(1));
=======
				System.out.println(skillList.get(0)+"\n"+skillList.get(1));
>>>>>>> Shane
			}
		});
		btnSkills.setBounds(33, 78, 246, 23);
		contentPane.add(btnSkills);
		
		JButton btnGrades = new JButton("Enter Courses to consider");
		btnGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GradeDialog gd = new GradeDialog();
				gd.setVisible(true);
				courseList = gd.getCourses();
				gd.dispose();
<<<<<<< HEAD
				//TestingSystem.out.println(courseList.get(0)+"\n"+courseList.get(1));
=======
				System.out.println(courseList.get(0)+"\n"+courseList.get(1));
>>>>>>> Shane
			}
		});
		btnGrades.setBounds(33, 112, 246, 23);
		contentPane.add(btnGrades);
		
		JLabel lblEnterDeadline = new JLabel("Enter Deadline");
		lblEnterDeadline.setBounds(37, 149, 93, 14);
		contentPane.add(lblEnterDeadline);
		
		txtMonth = new JTextField();
		txtMonth.setText("MM");
		txtMonth.setBounds(192, 146, 33, 20);
		contentPane.add(txtMonth);
		txtMonth.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setBounds(235, 149, 9, 14);
		contentPane.add(label);
		
		txtDd = new JTextField();
		txtDd.setText("DD");
		txtDd.setBounds(254, 146, 25, 20);
		contentPane.add(txtDd);
		txtDd.setColumns(10);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
<<<<<<< HEAD
				//No class id input
				if(txtCourseID.getText().equals(""))
				{
					ErrorInitiatorDialog error = new ErrorInitiatorDialog();
					error.setErrorMessage("Class ID","Field is blank.");
					error.setVisible(true);
				}
				//Group size value is not an integer or is empty
			    else if(!ValueChecker.isInteger(txtSize.getText()))
				{
					ErrorInitiatorDialog error = new ErrorInitiatorDialog();
					error.setErrorMessage("Class Size","Value is not an Integer.");
					error.setVisible(true);
				}
				//Day value is not an integer or is empty
				else if(!ValueChecker.isInteger(txtDd.getText()))
				{
					ErrorInitiatorDialog error = new ErrorInitiatorDialog();
					error.setErrorMessage("Date:Days","Value is not an Integer.");
					error.setVisible(true);
				}
				//Month value is not an integer or is empty
				else if(!ValueChecker.isInteger(txtMonth.getText()))
				{
					ErrorInitiatorDialog error = new ErrorInitiatorDialog();
					error.setErrorMessage("Date:Month","Value is not an Integer.");
					error.setVisible(true);
				}
				//Month value is outside range
				else if((0>=Integer.parseInt(txtMonth.getText()) || (13<=Integer.parseInt(txtMonth.getText()))))
				{
					ErrorInitiatorDialog error = new ErrorInitiatorDialog();
					error.setErrorMessage("Date:Month","Value is not possible. Please enter a value between 1 and 12.");
					error.setVisible(true);
				}
				//Everything is ok
				else
				{
					Course course = Registry.getCourse(txtCourseID.getText());
					int size =  Integer.parseInt(txtSize.getText());
					System.out.println(course.size()+" "+size);
					if(course.size()<size)
					{
						ErrorInitiatorDialog error = new ErrorInitiatorDialog();
						error.setErrorMessage("Group Size","Group Size is larger than class size.");
						error.setVisible(true);
					}
					else
					{
						String cid = course.getCRN();
						int classSize = course.size();
						int day = Integer.parseInt(txtDd.getText());
						String month="Error";
						//Sets month value
						switch( Integer.parseInt(txtMonth.getText() ) )
						{
							case 1 :month = "January";
							break;
							case 2 :month = "Febuary";
							break;
							case 3 :month = "March";
							break;
							case 4 :month = "April";
							break;
							case 5 :month = "May";
							break;
							case 6 :month = "June";
							break;
							case 7 :month = "July";
							break;
							case 8 :month = "August";
							break;
							case 9 :month = "September";
							break;
							case 10:month = "October";
							break;
							case 11:month = "November";
							break;
							case 12:month = "December";
							break;
						}
						//Asks if data is correct
						ConfirmInputDialog ci = new ConfirmInputDialog();
						ci.setValues(day, course, month, size,classSize);
						ci.update();
						ci.setVisible(true);
						boolean correct = ci.isCorrect();
						ci.dispose();
						//Testing System.out.println(correct);
						//Makes an array list to be writen to a file
						if(correct)
						{
							ArrayList<String> input = new ArrayList<String>(0);
							input.add(cid);
							input.add(""+size);
							input.add(month);
							input.add(""+day);
							input.add(":");
							for(String s : skillList)
							{
								if(!s.equals(""))
								{
									input.add(s);
								}
							}
							input.add(":");
							for(String s:courseList)
							{
								if(!s.equals(""))
								{
									input.add(s);
								}
							}
					
							MakeFileProfReq.makeFile("files/profreqs.csv",input);
							dispose();
						}
					}
				}
=======
				int size =  Integer.parseInt(txtSize.getText());
				String cid = txtCourseID.getText();
				int day = Integer.parseInt(txtDd.getText());
				String month="Error";
				switch(Integer.parseInt(txtMonth.getText()))
				{
				case 1 :month = "January";
				case 2 :month = "Febuary";
				case 3 :month = "March";
				case 4 :month = "April";
				case 5 :month = "May";
				case 6 :month = "June";
				case 7 :month = "July";
				case 8 :month = "August";
				case 9 :month = "September";
				case 10:month = "October";
				case 11:month = "November";
				case 12:month = "December";
				}
				
				//ConfirmInputDialog ci = new ConfirmInputDialog();
				//ci.setValues(day, course, month, size);
				
>>>>>>> Shane
			}
		});
		btnContinue.setBounds(37, 177, 242, 23);
		contentPane.add(btnContinue);
	}
}
