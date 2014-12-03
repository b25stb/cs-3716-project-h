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

public class ConfirmInputDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	String month="";
	int day,size,classSize;
	Course course;
	//InitiatorInterface ui;

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
	{
		classSize=cS;
		month=m;
		course=c;
		day=d;
		size=s;
	}
	
	public ConfirmInputDialog() {
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
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						correct = true;
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						correct =false;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
