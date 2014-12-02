/*
 * Error handler for gui's
 */
package grouph;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;

public class ErrorInitiatorDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	//Fist bit of error message 
	final String FIRST = "You have an incorrect input for the ";
	//Final bit of error message
	final String LAST = " input field. Please enter a correct value.\nERROR: ";
	//The error that has occured
	String error;
	//Area we will display error
	JTextArea txtError = new JTextArea();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ErrorInitiatorDialog dialog = new ErrorInitiatorDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Makes the error message to display
	 * @param error The error we are finding
	 */
	void setErrorMessage(String error,String errorMsg)
	{
		this.error = FIRST + error + LAST+ errorMsg;
		txtError.setText(this.error);
		
	}
	
	
	/**
	 * Create the dialog.
	 */
	public ErrorInitiatorDialog() {
		setModal(true);
		setBounds(100, 100, 450, 242);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		txtError.setBounds(10, 10, 414, 150);
		txtError.setLineWrap(true);
		txtError.setColumns(40);
		txtError.setWrapStyleWord(true);
		
		
		txtError.setEditable(false);
		txtError.setBackground(SystemColor.control);
		contentPanel.add(txtError);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					//Will close the window
					public void actionPerformed(ActionEvent arg0) 
					{
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
