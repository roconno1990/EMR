package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		GoGetPatient goGet = new GoGetPatient( tabbedPane, panel_1, patientSearchText );
		submit.addActionListener( goGet );
		
	}
}

class GoGetPatient implements ActionListener {

	private JTabbedPane tabbedPane;
	private JTextField  patientNumber;
	private JPanel      panel;

	GoGetPatient ( JTabbedPane tabbedPaneInput,
			       JPanel      panelIn,
			       JTextField  patientNumIn ) {
		tabbedPane = tabbedPaneInput;
		panel = panelIn;
		patientNumber = patientNumIn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();

		con.initialise("root", "offspring1");

		Map<String, Object> keyMap = new HashMap<String, Object>();
		keyMap.put("patient_id", patientNumber.getText());

		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		rows = data.retrieve(con.getConnection(), "patient", keyMap);
        if( rows.size() > 0 ) {
        	
        	JButton view = new JButton("View Result");
    		view.setBounds(150, 32, 130, 30);
    		panel.add(view);

    		PatientInfo patInfAct =
    		    new PatientInfo( tabbedPane,
    		    		         (String)rows.get(0).get("first_name"),
    		    		         (String)rows.get(0).get("middle_name"),
    		    		         (String)rows.get(0).get("last_name"),
    		    		         (String)rows.get(0).get("med_rec_ref"),
    		    		         (String)rows.get(0).get("finance_ref"),
    		    		         (String)rows.get(0).get("social_Security"),
    		    		         (String)rows.get(0).get("address"),
    		    		         (String)rows.get(0).get("attending_physician"),
    		    		         (String)rows.get(0).get("caring_nurse"),
    		    		         (String)rows.get(0).get("room_num"),
    		    		         (String)rows.get(0).get("location"),
    		    		         (String)rows.get(0).get("patient_id") );
    		view.addActionListener(patInfAct);
        }
		
	}
}