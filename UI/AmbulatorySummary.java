package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class AmbulatorySummary {

	private JFrame frmAmbulatorysummary;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AmbulatorySummary window = new AmbulatorySummary();
					window.frmAmbulatorysummary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AmbulatorySummary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmbulatorysummary = new JFrame();
		frmAmbulatorysummary.setTitle("AmbulatorySummary");
		frmAmbulatorysummary.setResizable(false);
		frmAmbulatorysummary.setBounds(100, 100, 450, 300);
		frmAmbulatorysummary.getContentPane().setLayout(null);
		
		JLabel lblMyclinicPage = new JLabel("MyClinic Page");
		lblMyclinicPage.setBounds(138, 90, 175, 64);
		frmAmbulatorysummary.getContentPane().add(lblMyclinicPage);
	}
}
