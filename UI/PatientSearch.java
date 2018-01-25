package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import base.DBBase;
import base.DBConnect;

class PatientSearch implements ActionListener {

	private JTabbedPane tabbedPane;
	private JTextField  patientSearchText = new JTextField();

	PatientSearch( JTabbedPane tabbedPaneInput ) {
		this.tabbedPane = tabbedPaneInput;
	}

	public String getPatientId() {
		return patientSearchText.getText();
	}

	public void setPatientId(String t) {
		patientSearchText.setText(t);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel panel_1 = new JPanel();

		panel_1 = new JPanel();
		tabbedPane.addTab("Patient Search", panel_1);
		panel_1.setLayout(null);

		JLabel firstName = new JLabel("Enter ID: ");
		firstName.setBounds(10, 7, 100, 16);
		panel_1.add(firstName);
		
		patientSearchText.setBounds(150, 7, 200, 20);
		panel_1.add(patientSearchText);
		patientSearchText.setColumns(10);

		JButton submit = new JButton("Search");
		submit.setBounds(10, 32, 130, 30);
		panel_1.add(submit);

		GoGetPatient goGet = new GoGetPatient( tabbedPane, getPatientId() );
		submit.addActionListener( goGet );
		
	}
}

class GoGetPatient implements ActionListener {

	private JTabbedPane tabbedPane;
	private String      patientNumber;

	GoGetPatient ( JTabbedPane tabbedPaneInput,
			       String      patientNumIn ) {
		tabbedPane = tabbedPaneInput;
		patientNumber = patientNumIn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();
		JPanel panel_1 = new JPanel();

		panel_1 = new JPanel();

		

		
	}
}