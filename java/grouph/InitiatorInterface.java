package grouph;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class InitiatorInterface extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCourseID;
	private JTextField txtSize;
	private JTextField txtMonth;
	private JTextField txtDd;
	static ArrayList<String> skillList = new ArrayList<String>(0);
	static ArrayList<String> courseList = new ArrayList<String>(0);
	ArrayList<String> input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InitiatorInterface dialog = new InitiatorInterface();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InitiatorInterface() {
		setModal(true);
		setBounds(100, 100, 270, 230);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEnterClassId = new JLabel("Enter Class ID");
		lblEnterClassId.setBounds(10, 11, 80, 14);
		contentPanel.add(lblEnterClassId);
		
		txtCourseID = new JTextField();
		txtCourseID.setBounds(113, 8, 136, 20);
		contentPanel.add(txtCourseID);
		txtCourseID.setColumns(10);
		
		JLabel lblEnterDesiredGroup = new JLabel("Enter group Size");
		lblEnterDesiredGroup.setBounds(10, 42, 100, 14);
		contentPanel.add(lblEnterDesiredGroup);
		
		txtSize = new JTextField();
		txtSize.setBounds(110, 39, 139, 20);
		contentPanel.add(txtSize);
		txtSize.setColumns(10);
		
		JButton btnSkills = new JButton("Enter Skills");
		btnSkills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				SkillDialog skill = new SkillDialog();
				skill.setVisible(true);
				skillList = skill.getSkills();
				skill.dispose();
			}
		});
		btnSkills.setBounds(10, 66, 239, 23);
		contentPanel.add(btnSkills);
		
		JButton btnGrades = new JButton("EnterGrades");
		btnGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GradeDialog gd = new GradeDialog();
				gd.setVisible(true);
				courseList = gd.getCourses();
				gd.dispose();
			}
		});
		btnGrades.setBounds(10, 103, 239, 23);
		contentPanel.add(btnGrades);
		
		JLabel lblEnterDeadline = new JLabel("Enter DeadLine");
		lblEnterDeadline.setBounds(10, 137, 80, 14);
		contentPanel.add(lblEnterDeadline);
		
		txtDd = new JTextField();
		txtDd.setText("DD");
		txtDd.setBounds(164, 134, 31, 20);
		contentPanel.add(txtDd);
		txtDd.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setBounds(154, 137, 14, 14);
		contentPanel.add(label);
		
		txtMonth = new JTextField();
		txtMonth.setText("MM");
		txtMonth.setBounds(113, 134, 31, 20);
		contentPanel.add(txtMonth);
		txtMonth.setColumns(10);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
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
				//Day value is out of range
				else if((0>=Integer.parseInt(txtDd.getText()) || (31<=Integer.parseInt(txtDd.getText()))))
				{
					ErrorInitiatorDialog error = new ErrorInitiatorDialog();
					error.setErrorMessage("Date:Day","Value is not possible. Please enter a value between 1 and 31.");
					error.setVisible(true);
				}
				//Everything is ok
				else
				{
					Course course = Registry.getCourse(txtCourseID.getText());
					int size =  Integer.parseInt(txtSize.getText());
					//System.out.println(course.size()+" "+size);
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
						//while(ci.isActive()){}//Wait for input
						boolean correct = ci.isCorrect();
						ci.dispose();
						//Testing System.out.println(correct);
						//Makes an array list to be writen to a file
						if(correct)
						{
							input = new ArrayList<String>(0);
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
					
							//MakeFileProfReq.makeFile("files/profreqs.csv",input);
							setVisible(false);
						}
					}
				}
			}
		});
		btnContinue.setBounds(10, 162, 239, 23);
		contentPanel.add(btnContinue);
	}
}
