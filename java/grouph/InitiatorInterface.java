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

public class InitiatorInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtCourseID;
	private JTextField txtSize;
	private JTextField txtMonth;
	private JTextField txtDd;
	ArrayList<String> skillList = new ArrayList<String>(0);
	ArrayList<String> courseList = new ArrayList<String>(0);


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
				System.out.println(skillList.get(0)+"\n"+skillList.get(1));
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
				System.out.println(courseList.get(0)+"\n"+courseList.get(1));
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
				
				//Just for testing
				Course course = new Course("ID");
				int classSize = 20;
				//
				ConfirmInputDialog ci = new ConfirmInputDialog();
				ci.setValues(day, course, month, size,classSize);
				ci.setVisible(true);
				
			}
		});
		btnContinue.setBounds(37, 177, 242, 23);
		contentPane.add(btnContinue);
	}
}
