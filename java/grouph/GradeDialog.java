package grouph;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class GradeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GradeDialog dialog = new GradeDialog();
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
	final JTextArea txtCourse = new JTextArea();
	final ArrayList<String> cl = new ArrayList<String>(0);
	public GradeDialog() {
		setModal(true);
		setBounds(100, 100, 353, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 314, 27);
		contentPanel.add(panel);
		
		JLabel lblPleaseEnterEach = new JLabel("Please Enter each Course on a line below");
		panel.add(lblPleaseEnterEach);
		
		//final JTextArea txtCourse = new JTextArea();
		txtCourse.setBounds(10, 44, 314, 185);
		contentPanel.add(txtCourse);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				//JButton okButton = new JButton("Confirm");
				okButton.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						Scanner in = new Scanner(txtCourse.getText());
<<<<<<< HEAD
=======
						if(!in.hasNextLine())
						{
							while(cl.size()>0)
							{
								cl.remove(0);
							}
						}
>>>>>>> Shane
						while(in.hasNext())
						{
							cl.add(in.nextLine());
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
	ArrayList<String> getCourses()
	{
		return cl;
	}
}
