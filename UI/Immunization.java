package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Immunization {

	private JFrame frmImmunization;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Immunization window = new Immunization();
					window.frmImmunization.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Immunization() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImmunization = new JFrame();
		frmImmunization.setTitle("Immunization");
		frmImmunization.setBounds(100, 100, 450, 300);
		frmImmunization.getContentPane().setLayout(null);
		
		JLabel lblVaccines = new JLabel("Vaccines");
		lblVaccines.setBounds(111, 67, 259, 91);
		frmImmunization.getContentPane().add(lblVaccines);
		
	}

}
