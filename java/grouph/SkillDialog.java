package grouph;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class SkillDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SkillDialog dialog = new SkillDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	JButton okButton = new JButton("Confirm");
	final JTextArea txtSkills = new JTextArea();
	final ArrayList<String> sk = new ArrayList<String>(0);
	public SkillDialog() 
	{
		setModal(true);
		setTitle("Enter Skills needed.");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblPleaseEnterEach = new JLabel("Please enter each skill below \n on separate lines.");
		lblPleaseEnterEach.setVerticalAlignment(SwingConstants.TOP);
		lblPleaseEnterEach.setBounds(73, 13, 306, 23);
		contentPanel.add(lblPleaseEnterEach);
		
		
		txtSkills.setBounds(10, 47, 414, 171);
		contentPanel.add(txtSkills);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				okButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						Scanner in = new Scanner(txtSkills.getText());
						while(in.hasNext())
						{
							sk.add(in.nextLine());
						}
						in.close();
						setVisible(false);
						 
					}
				}
				);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0)
					{
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	ArrayList<String> getSkills()
	{
		return sk;
	}
}
