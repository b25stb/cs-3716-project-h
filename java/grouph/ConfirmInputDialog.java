package grouph;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Shane
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

	/**
	 * The class pop a window let user to confirm the Input infomation
	 */
	 
=======

>>>>>>> Shane
public class ConfirmInputDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	String month="";
<<<<<<< HEAD
<<<<<<< HEAD
	int day,size,classSize;
	Course course;
	//InitiatorInterface ui;
=======
	int day,size;
	Course course;
>>>>>>> Shane
=======
	int day,size,classSize;
	Course course;
	//InitiatorInterface ui;
>>>>>>> Shane

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfirmInputDialog dialog = new ConfirmInputDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	boolean correct=false;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Shane
	JTextArea txtConfirmArea = new JTextArea();
	
	boolean isCorrect()
	{
		return correct;
	}
	
	void update()
	{
		int gn = classSize/size;
		String output = "You have entered the following:\nClass:";
		output = output+ course.getCRN()+"\nGroup Size:"+size;
		output = output + "\nNumber of Groups:"+ gn+"\nDeadLine:";
		output = output + month+ " "+ day+"\n\nIs this Correct?";
		txtConfirmArea.setText(output);
	}
	
	void setValues(int d,Course c,String m,int s,int cS)
<<<<<<< HEAD
	{
		classSize=cS;
=======
	void setValues(int d,Course c,String m,int s)
	{
>>>>>>> Shane
=======
	{
		classSize=cS;
>>>>>>> Shane
		month=m;
		course=c;
		day=d;
		size=s;
	}
	
	public ConfirmInputDialog() {
<<<<<<< HEAD
<<<<<<< HEAD
		setTitle("Confirm Details");
		setModal(true);
		setBounds(100, 100, 328, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPleaseConfirmThe = new JLabel("Please confirm The details you have entered.");
			lblPleaseConfirmThe.setBounds(22, 11, 217, 14);
			contentPanel.add(lblPleaseConfirmThe);
		}
		{
			//JTextArea txtConfirmArea = new JTextArea();
			txtConfirmArea.setEditable(false);
			txtConfirmArea.setBounds(10, 30, 292, 162);
			contentPanel.add(txtConfirmArea);

		}
=======
=======
		setTitle("Confirm Details");
>>>>>>> Shane
		setModal(true);
		setBounds(100, 100, 328, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
<<<<<<< HEAD
>>>>>>> Shane
=======
		contentPanel.setLayout(null);
		{
			JLabel lblPleaseConfirmThe = new JLabel("Please confirm The details you have entered.");
			lblPleaseConfirmThe.setBounds(22, 11, 217, 14);
			contentPanel.add(lblPleaseConfirmThe);
		}
		{
			//JTextArea txtConfirmArea = new JTextArea();
			txtConfirmArea.setEditable(false);
			txtConfirmArea.setBounds(10, 30, 292, 162);
			contentPanel.add(txtConfirmArea);

		}
>>>>>>> Shane
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Shane
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						correct = true;
						setVisible(false);
					}
				});
<<<<<<< HEAD
=======
>>>>>>> Shane
=======
>>>>>>> Shane
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Shane
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						correct =false;
						dispose();
					}
				});
<<<<<<< HEAD
=======
>>>>>>> Shane
=======
>>>>>>> Shane
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
