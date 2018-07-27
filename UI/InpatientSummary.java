package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;


public class InpatientSummary {

	private JFrame frmInpatientsummary;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InpatientSummary window = new InpatientSummary();
					window.frmInpatientsummary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InpatientSummary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInpatientsummary = new JFrame();
		frmInpatientsummary.setResizable(false);
		frmInpatientsummary.setTitle("InpatientSummary");
		frmInpatientsummary.setBounds(100, 100, 484, 344);
		frmInpatientsummary.getContentPane().setLayout(null);
		
		JButton btnMypage = new JButton("MyPage");
		btnMypage.setBackground(Color.RED);
		btnMypage.setBounds(76, 85, 257, 73);
		frmInpatientsummary.getContentPane().add(btnMypage);
	}

}
