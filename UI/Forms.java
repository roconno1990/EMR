package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;


public class Forms {

	private JFrame frmForms;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forms window = new Forms();
					window.frmForms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Forms() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmForms = new JFrame();
		frmForms.setTitle("Forms");
		frmForms.setBounds(100, 100, 450, 300);
		frmForms.getContentPane().setLayout(null);
		
		JButton btnForms = new JButton("Forms");
		btnForms.setBounds(85, 66, 235, 85);
		frmForms.getContentPane().add(btnForms);
		
	}

}
