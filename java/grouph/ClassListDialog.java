package grouph;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClassListDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ClassListDialog dialog = new ClassListDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ClassListDialog() {
		setTitle("Class Details");
		setBounds(100, 100, 319, 368);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblClasssizelabel = new JLabel("ClassSize");
		lblClasssizelabel.setBounds(10, 11, 46, 14);
		contentPanel.add(lblClasssizelabel);
		
		JLabel lblClassSize = new JLabel("{}");
		lblClassSize.setBounds(70, 11, 46, 14);
		contentPanel.add(lblClassSize);
		
		JLabel lblClasslist = new JLabel("ClassList");
		lblClasslist.setBounds(10, 44, 46, 14);
		contentPanel.add(lblClasslist);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 69, 283, 217);
		contentPanel.add(textArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
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
