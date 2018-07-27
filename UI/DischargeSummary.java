package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class DischargeSummary {

	private JFrame frmDischargesummary;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DischargeSummary window = new DischargeSummary();
					window.frmDischargesummary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DischargeSummary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDischargesummary = new JFrame();
		frmDischargesummary.setTitle("DischargeSummary");
		frmDischargesummary.setResizable(false);
		frmDischargesummary.setBounds(100, 100, 450, 300);
		frmDischargesummary.getContentPane().setLayout(null);
		
		JLabel lblYouAreGoing = new JLabel("You are going home");
		lblYouAreGoing.setBounds(48, 62, 338, 115);
		frmDischargesummary.getContentPane().add(lblYouAreGoing);
	}

}
