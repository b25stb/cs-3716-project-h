package grouph;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OverViewInterface extends JDialog {

	private final JPanel contentPanel = new JPanel();
	//List of groups made after matching
		ArrayList<Group> groupList;
		//Lists to display list of groups so they can be edited
		DefaultListModel<Group> groupModel;
		final JList<Group> lstStuA;
		final JList<Group> lstStuB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OverViewInterface dialog = new OverViewInterface();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Error handler that will determine if a group has been selected from each list
	 * @return Are selections valid
	 */
	boolean isAllowed()
	{
		if(lstStuA.getSelectedValue()==null)
		{
			ErrorInitiatorDialog error = new ErrorInitiatorDialog();
			error.setErrorMessage("First group selection","No group selected.");
			error.setVisible(true);
			return false;
		}
		if(lstStuB.getSelectedValue()==null)
		{
			ErrorInitiatorDialog error = new ErrorInitiatorDialog();
			error.setErrorMessage("Second group selection","No group selected.");
			error.setVisible(true);
			return false;
		}
		if(lstStuA==lstStuB)
		{
			ErrorInitiatorDialog error = new ErrorInitiatorDialog();
			error.setErrorMessage("Group selection","Same group Selected.");
			error.setVisible(true);
			return false;
		}
		return true;
	}
	
	/*
	 * Makes the List from a list of groups
	 */
	void makeList(ArrayList<Group> groups)
	{
		groupModel.clear();
		groupList=groups;
		for(Group g : groupList)
		{
			groupModel.addElement(g);
		}
	}

	/**
	 * Create the dialog.
	 */
	public OverViewInterface() {
		setBounds(100, 100, 602, 300);
		setModal(true);
		groupModel= new DefaultListModel<Group>();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 550, 207);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 45, 262, 130);
				panel.add(scrollPane);
				{
					lstStuA = new JList<Group>(groupModel);
					scrollPane.setViewportView(lstStuA);
				}
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(278, 45, 262, 130);
				panel.add(scrollPane);
				{
					lstStuB = new JList<Group>(groupModel);
					scrollPane.setViewportView(lstStuB);
				}
			}
			{
				JLabel lblSelectFirstGroup = new JLabel("Select first group to edit");
				lblSelectFirstGroup.setBounds(10, 20, 262, 14);
				panel.add(lblSelectFirstGroup);
			}
			{
				JLabel lblSelectSecondGroup = new JLabel("Select second group to edit");
				lblSelectSecondGroup.setBounds(278, 20, 178, 14);
				panel.add(lblSelectSecondGroup);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnEdit = new JButton("Edit");
				btnEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						boolean bool = isAllowed();
						if(bool)
						{
							EditGroupUI edit = new EditGroupUI();
							int indexA = lstStuA.getSelectedIndex();
							int indexB = lstStuB.getSelectedIndex();
							edit.setLists(lstStuA.getSelectedValue(),lstStuB.getSelectedValue());
							edit.setVisible(true);
							if(indexA<indexB)
							{
								groupList.remove(indexB);
								groupModel.remove(indexB);
								groupList.remove(indexA);
								groupModel.remove(indexA);
							}
							else
							{
								groupList.remove(indexA);
								groupModel.remove(indexB);
								groupList.remove(indexB);
								groupModel.remove(indexB);
							}
							groupList.add(edit.getGroup("A"));
							groupModel.addElement(edit.getGroup("A"));
							groupList.add(edit.getGroup("B"));
							groupModel.addElement(edit.getGroup("B"));
							edit.dispose();
							
							
						}
					}
				});
				btnEdit.setActionCommand("OK");
				buttonPane.add(btnEdit);
				getRootPane().setDefaultButton(btnEdit);
			}
			{
				JButton btnFinish = new JButton("Finish");
				btnFinish.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false);
					}
				});
				btnFinish.setActionCommand("Cancel");
				buttonPane.add(btnFinish);
			}
		}
		/*
		//Testing
		Course c = Registry.getCourse("TEST");
		Group g1 = new Group(2,"1");
		Group g2 = new Group(2,"2");
		ArrayList<Student>  l = c.getClassList();
		for(int i=0;i<2;i++)
		{
			g1.add(l.remove(0));
			g2.add(l.remove(0));
		}
		ArrayList<Group> gps = new ArrayList<Group>(0);
		gps.add(g1);
		gps.add(g2);
		makeList(gps);
		*/
	}

}
