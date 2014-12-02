package grouph;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditGroupUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	DefaultListModel<Student> groupAModel;
	DefaultListModel<Student> groupBModel;
	final JList<Student> lstGroupA;
	final JList<Student> lstGroupB;
	Group groupA;
	Group groupB;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditGroupUI dialog = new EditGroupUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Error handler for not making a selection in either student list
	 * @return Are valid selections made
	 */
	boolean isAllowed()
	{
		if(lstGroupA.getSelectedValue()==null)
		{
			ErrorInitiatorDialog error = new ErrorInitiatorDialog();
			error.setErrorMessage("First student selection","No student selected.");
			error.setVisible(true);
			return false;
		}
		if(lstGroupB.getSelectedValue()==null)
		{
			ErrorInitiatorDialog error = new ErrorInitiatorDialog();
			error.setErrorMessage("Second student selection","No student selected.");
			error.setVisible(true);
			return false;
		}
		return true;
	}
	
	/*
	 * Adds students from groups into the list so they can be swaped
	 * @param gA A group to be edited
	 * @param gB Another group to be edited
	 */
	void setLists(Group gA,Group gB)
	{
		groupA=gA;
		groupB=gB;
		for(Student s:gA.groupMems)
		{
			groupAModel.addElement(s);
		}
		for(Student s:gB.groupMems)
		{
			groupBModel.addElement(s);
		}
	}
	
	/*
	 * Method to get group value
	 * @param index Chooses which one we want to select
	 * @return an updated group
	 */
	Group getGroup(String index)
	{
		if(index.equalsIgnoreCase("a"))
		{
			return groupA;
		}
		return groupB;
	}

	/*
	 * Swaps students between groups
	 */
	void swap()
	{
		Student stuA =lstGroupA.getSelectedValue();
		Student stuB = lstGroupB.getSelectedValue();
		int indexA = lstGroupA.getSelectedIndex();
		int indexB = lstGroupB.getSelectedIndex();
		//Swaps members in groups
		Overview.swap(groupA,groupB,stuA,stuB);
		//Removes them from the lists
		groupAModel.remove(indexA);
		groupBModel.remove(indexB);
		//Appends them to end of list
		groupAModel.addElement(stuB);
		groupBModel.addElement(stuA);	
	}

	/**
	 * Create the dialog.
	 */
	public EditGroupUI() {
		setTitle("Swap members between groups");
		setModal(true);
		groupAModel = new DefaultListModel<Student>();
		groupBModel = new DefaultListModel<Student>();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 414, 207);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 11, 180, 185);
				panel.add(scrollPane);
				{
					lstGroupA = new JList<Student>(groupAModel);
					scrollPane.setViewportView(lstGroupA);
				}
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(224, 11, 180, 185);
				panel.add(scrollPane);
				{
					lstGroupB = new JList<Student>(groupBModel);
					scrollPane.setViewportView(lstGroupB);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSwap = new JButton("Swap");
				btnSwap.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						boolean bool = isAllowed();
						if(bool)
						{
							swap();
						}
					}
				});
				btnSwap.setActionCommand("OK");
				buttonPane.add(btnSwap);
				getRootPane().setDefaultButton(btnSwap);
			}
			{
				JButton btnDone = new JButton("Done");
				btnDone.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						/*
						 //Testing
						for(Student s:groupA.groupMems)
						{
							System.out.println(s.toString());
						}
						for(Student s:groupB.groupMems)
						{
							System.out.println(s.toString());
						}
						*/
						setVisible(false);
					}
				});
				btnDone.setActionCommand("Done");
				buttonPane.add(btnDone);
			}
		}
	}

}
