/*
 * Forces people to work together or apart
 */
package grouph;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

import java.awt.Color;

public class ForceGroups extends JDialog {

	private final JPanel contentPanel = new JPanel();
	//Lists of students one can pair
	DefaultListModel<Student> listModel;
	final JList<Student> lstStuA;
	final JList<Student> lstStuB;
	//List of forced matched students
	DefaultListModel<String> matchModel;
	final JList<String> lstForced;
	//List of students to keep apart
	DefaultListModel<String> apartModel;
	final JList<String> lstForceApart;
	//List of student ids of students to be matched
	ArrayList<String[]> matchList=new ArrayList<String[]>(0);
	//List of student ids of students to be separated
	ArrayList<String[]> apartList=new ArrayList<String[]>(0);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ForceGroups dialog = new ForceGroups();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Gets the list of ids of forced matches
	 * @return IDs of forced matches
	 */
	ArrayList<String[]> getForceMatches()
	{
		return matchList;
	}
	
	/*
	 * List of IDs of students that will be kept apart
	 * @return IDs of students that cannot work together
	 */
	ArrayList<String[]> getForcedSeperations()
	{
		return apartList;
	}
	
	/*
	 * Error handler in case force Match/Apart button is clicked with no selection
	 * @return Can force match/Apart
	 */
	boolean isAllowed()
	{
		if(lstStuA.getSelectedValue()==null)
		{
			ErrorInitiatorDialog error = new ErrorInitiatorDialog();
			error.setErrorMessage("First student selection","No student selected.");
			error.setVisible(true);
			return false;
		}
		if(lstStuB.getSelectedValue()==null)
		{
			ErrorInitiatorDialog error = new ErrorInitiatorDialog();
			error.setErrorMessage("Second student selection","No student selected.");
			error.setVisible(true);
			return false;
		}
		return true;
	}
	
	/*
	 * error handler if no selection made to be removed
	 * @return Is removal possible
	 */
	boolean canRemove(String s)
	{
		if(s.equals("fm")&&lstForced.getSelectedValue()==null)
		{
			ErrorInitiatorDialog error = new ErrorInitiatorDialog();
			error.setErrorMessage("List of forced matches","No pair of students selected.");
			error.setVisible(true);
			return false;
		}
		else if(s.equals("fa")&&lstForceApart.getSelectedValue()==null)
		{
			ErrorInitiatorDialog error = new ErrorInitiatorDialog();
			error.setErrorMessage("List of forced apart students","No pair of students selected.");
			error.setVisible(true);
			return false;
		}
		return true;
	}
	
	/*
	 * Adds list of students from a Course to the list model
	 * @param course The course we are fetching class list from
	 */
	void addStudents(Course course)
	{
		listModel.clear();
		for(Student stu: course.classList)
		{
			listModel.addElement(stu);
		}
	}

	/**
	 * Create the dialog.
	 */
	public ForceGroups() {
		setTitle("Select students to force together or apart");
		setModal(true);
		setBounds(100, 100, 525, 561);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(38, 30, 440, 197);
		contentPanel.add(panel);
		
		//Crates the listmodel we will be using 
		listModel = new DefaultListModel<Student>();
		//Creates the list of matched students
		matchModel = new DefaultListModel<String>();
		//Creates the list of forced apart students
		apartModel = new DefaultListModel<String>();
		
		panel.setLayout(null);
		
		JLabel lblSelectTwoStudents = new JLabel("Select two students");
		lblSelectTwoStudents.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectTwoStudents.setBounds(10, 11, 347, 14);
		panel.add(lblSelectTwoStudents);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 36, 298, 42);
		panel.add(scrollPane);
		
		lstStuA = new JList<Student>(listModel);
		scrollPane.setViewportView(lstStuA);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(35, 89, 298, 45);
		panel.add(scrollPane_1);
		
		lstStuB = new JList<Student>(listModel);
		scrollPane_1.setViewportView(lstStuB);
		
		JButton btnForceMatch = new JButton("Force Match");
		btnForceMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				boolean bool = isAllowed();
				if(bool)
				{
					String output = lstStuA.getSelectedValue().toString()+", "+lstStuB.getSelectedValue().toString();
					String[] s={lstStuA.getSelectedValue().getId(),lstStuB.getSelectedValue().getId()};
					matchModel.addElement(output);
					matchList.add(s);
				}
			}
		});
		btnForceMatch.setBounds(35, 145, 144, 42);
		panel.add(btnForceMatch);
		
		JButton btnForceApart = new JButton("Force Apart");
		btnForceApart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				boolean bool = isAllowed();
				if(bool)
				{
					String output = lstStuA.getSelectedValue().toString()+", "+lstStuB.getSelectedValue().toString();
					String[] s={lstStuA.getSelectedValue().getId(),lstStuB.getSelectedValue().getId()};
					apartModel.addElement(output);
					apartList.add(s);
				}
			}
		});
		btnForceApart.setBounds(189, 146, 144, 41);
		panel.add(btnForceApart);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(38, 238, 440, 115);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(33, 41, 293, 63);
		panel_1.add(scrollPane_2);
		
		lstForced = new JList<String>(matchModel);
		scrollPane_2.setViewportView(lstForced);
		
		JButton btnRemoveForceMatch = new JButton("Remove");
		btnRemoveForceMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				boolean bool = canRemove("fm");
				if(bool)
				{
					matchList.remove(lstForced.getSelectedIndex());
					matchModel.remove(lstForced.getSelectedIndex());
				}
			}
		});
		btnRemoveForceMatch.setBounds(336, 41, 84, 65);
		panel_1.add(btnRemoveForceMatch);
		
		JLabel lblThisIsA = new JLabel("This is a list of forced matched students. You can remove them by");
		lblThisIsA.setBounds(33, 0, 410, 14);
		panel_1.add(lblThisIsA);
		
		JLabel lblAndClickingRemove = new JLabel("selecting them and Clicking Remove.");
		lblAndClickingRemove.setBounds(33, 16, 338, 14);
		panel_1.add(lblAndClickingRemove);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(38, 364, 440, 115);
		contentPanel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(27, 41, 298, 63);
		panel_3.add(scrollPane_5);
		
		lstForceApart = new JList<String>(apartModel);
		scrollPane_5.setViewportView(lstForceApart);
		
		JLabel lblThisIsA_1 = new JLabel("This is a list of students bring forced apart. You can remove them by");
		lblThisIsA_1.setBounds(24, 0, 396, 14);
		panel_3.add(lblThisIsA_1);
		
		JLabel lblSelectingThemAnd = new JLabel("selecting them and Clicking remove");
		lblSelectingThemAnd.setBounds(27, 16, 326, 14);
		panel_3.add(lblSelectingThemAnd);
		
		JButton btnRemoveForceApart = new JButton("Remove");
		btnRemoveForceApart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				boolean bool = canRemove("fa");
				if(bool)
				{
					apartList.remove(lstForceApart.getSelectedIndex());
					apartModel.remove(lstForceApart.getSelectedIndex());
				}
			}
		});
		btnRemoveForceApart.setBounds(336, 41, 84, 65);
		panel_3.add(btnRemoveForceApart);
		
		JLabel lblForceMatchStudents = new JLabel("Force match Students");
		lblForceMatchStudents.setBounds(38, 11, 272, 14);
		contentPanel.add(lblForceMatchStudents);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		//Tests addStudents(Registry.getCourse("TEST"));
	}
}
