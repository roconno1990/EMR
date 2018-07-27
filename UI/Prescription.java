package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;


public class Prescription {

	private JFrame frmPrescription;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prescription window = new Prescription();
					window.frmPrescription.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prescription() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrescription = new JFrame();
		frmPrescription.setResizable(false);
		frmPrescription.setTitle("Prescription");
		frmPrescription.setBounds(100, 100, 450, 300);
		frmPrescription.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Medication");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setBounds(130, 81, 182, 79);
		frmPrescription.getContentPane().add(btnNewButton);
	}
}
