package UI;

import base.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Visit implements ActionListener {
	private JTabbedPane tabbedPane;

	Visit( JTabbedPane tabbedPaneInput ) {
		this.tabbedPane = tabbedPaneInput;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JPanel panel_1 = new JPanel();

		panel_1 = new JPanel();
		tabbedPane.addTab("Visit", panel_1);
		panel_1.setLayout(null);

		JLabel patientNum = new JLabel("Patient Num");
		patientNum.setBounds(10, 7, 100, 16);
		panel_1.add(patientNum);

		JTextField patientNumText = new JTextField();
		patientNumText.setBounds(150, 7, 130, 20);
		panel_1.add(patientNumText);
		patientNumText.setColumns(10);

		JLabel date = new JLabel("Date");
		date.setBounds(10, 32, 100, 16);
		panel_1.add(date);

		JTextField dateText = new JTextField();
		dateText.setBounds(150, 32, 130, 20);
		panel_1.add(dateText);
		dateText.setColumns(10);

		JLabel time = new JLabel("Time");
		time.setBounds(10, 58, 100, 16);
		panel_1.add(time);

		JTextField timeText = new JTextField();
		timeText.setBounds(150, 58, 130, 20);
		panel_1.add(timeText);
		timeText.setColumns(10);

		JLabel dob = new JLabel("DOB");
		dob.setBounds(10, 83, 100, 16);
		panel_1.add(dob);

		JTextField dobText = new JTextField();
		dobText.setBounds(150, 83, 130, 20);
		panel_1.add(dobText);
		dobText.setColumns(10);

		JLabel medRecNum = new JLabel("Medical Record");
		medRecNum.setBounds(10, 108, 120, 20);
		panel_1.add(medRecNum);

		JTextField medRecNumText = new JTextField();
		medRecNumText.setBounds(150, 108, 130, 20);
		panel_1.add(medRecNumText);
		medRecNumText.setColumns(10);

		JLabel financeNum = new JLabel("Financial Num");
		financeNum.setBounds(10, 133, 120, 20);
		panel_1.add(financeNum);

		JTextField financeNumText = new JTextField();
		financeNumText.setBounds(150, 133, 130, 20);
		panel_1.add(financeNumText);
		financeNumText.setColumns(10);

		JLabel diagnoses = new JLabel("Diagnoses");
		diagnoses.setBounds(10, 158, 120, 20);
		panel_1.add(diagnoses);

		JTextField diagnosesText = new JTextField();
		diagnosesText.setBounds(150, 158, 200, 80);
		panel_1.add(diagnosesText);
		diagnosesText.setColumns(10);

		JLabel prescription = new JLabel("Prescriptions");
		prescription.setBounds(10, 245, 120, 20);
		panel_1.add(prescription);

		JTextField prescriptionText = new JTextField();
		prescriptionText.setBounds(150, 245, 200, 80);
		panel_1.add(prescriptionText);
		prescriptionText.setColumns(10);

		JLabel reason = new JLabel("Visit Reason");
		reason.setBounds(10, 335, 120, 20);
		panel_1.add(reason);

		JTextField reasonText = new JTextField();
		reasonText.setBounds(150, 335, 300, 100);
		panel_1.add(reasonText);
		reasonText.setColumns(10);

		JLabel comments = new JLabel("Visit Reason");
		comments.setBounds(10, 440, 120, 20);
		panel_1.add(reason);

		JTextField commentsText = new JTextField();
		commentsText.setBounds(150, 440, 300, 100);
		panel_1.add(reasonText);
		commentsText.setColumns(10);

		JButton submit = new JButton("Submit");
		submit.setBounds(10, 520, 130, 30);
		panel_1.add(submit);
	}
}

class InsertVisit implements ActionListener {

	private JTextField patientNum;
	private JTextField date;
	private JTextField time;
	private JTextField dob;
	private JTextField medRecNum;
	private JTextField financeNum;
	private JTextField diagnoses;
	private JTextField prescription;
	private JTextField reason;
	private JTextField comments;

	InsertVisit( JTextField patientNumIn,
			     JTextField dateIn,
			     JTextField timeIn,
			     JTextField dobIn,
			     JTextField medRecNumIn,
			     JTextField financeNumIn,
			     JTextField diagnosesIn,
			     JTextField prescriptionIn,
			     JTextField reasonIn,
			     JTextField commentsIn ) {

		patientNum = patientNumIn;
		date = dateIn;
		time = timeIn;
		dob = dobIn;
		medRecNum = medRecNumIn;
		financeNum = financeNumIn;
		diagnoses = diagnosesIn;
		prescription = prescriptionIn;
		reason = reasonIn;
		comments = commentsIn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();

		con.initialise("root", "offspring1");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("update_time", data.getCurrentTimeStamp());
		map.put("patient_id", patientNum.getText());
		map.put("visit_date", date.getText());
		map.put("visit_time", time.getText());
		map.put("reason", reason.getText());
		map.put("date_of_birth", dob.getText());
		map.put("med_rec_ref", medRecNum.getText());
		map.put("finance_ref", financeNum.getText());
		map.put("prescriptions", prescription.getText());
		map.put("diagnoses", diagnoses.getText());
		map.put("comments", comments.getText());
		
		data.insert(con.getConnection(), "visit", map);
	}
	
}