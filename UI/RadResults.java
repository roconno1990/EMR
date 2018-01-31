package UI;

import base.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class RadResults implements ActionListener {
	private JTabbedPane tabbedPane;
	private String dbName;

	RadResults( JTabbedPane tabbedPaneIn ) {
		this.tabbedPane = tabbedPaneIn;
	}

	RadResults( JTabbedPane tabbedPaneIn, String dbNameIn, DBConnect con, DBBase database ) {
		this.tabbedPane = tabbedPaneIn;
		dbName = dbNameIn;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JPanel panel_1 = new JPanel();

		panel_1 = new JPanel();
		tabbedPane.addTab("Radiology Results", panel_1);
		panel_1.setLayout(null);

		JLabel medRecNumLbl = new JLabel("Med Record #");
		medRecNumLbl.setBounds(10, 10, 100, 20);
		panel_1.add(medRecNumLbl);

		JTextField medRecNumText = new JTextField();
		medRecNumText.setBounds(150, 10, 130, 20);
		panel_1.add(medRecNumText);
		medRecNumText.setColumns(10);

		JLabel dateSchedLbl = new JLabel("Date Scheduled");
		dateSchedLbl.setBounds(10, 35, 100, 20);
		panel_1.add(dateSchedLbl);

		JTextField dateSchedText = new JTextField();
		dateSchedText.setBounds(150, 35, 130, 20);
		panel_1.add(dateSchedText);
		dateSchedText.setColumns(10);

		JLabel xrayLbl = new JLabel("XRAY report");
		xrayLbl.setBounds(10, 60, 100, 20);
		panel_1.add(xrayLbl);

		JTextField xrayText = new JTextField();
		xrayText.setBounds(150, 60, 130, 20);
		panel_1.add(xrayText);
		xrayText.setColumns(10);

		JLabel mriLbl = new JLabel("MRI report");
		mriLbl.setBounds(10, 85, 100, 20);
		panel_1.add(mriLbl);

		JTextField mriText = new JTextField();
		mriText.setBounds(150, 85, 130, 20);
		panel_1.add(mriText);
		mriText.setColumns(10);

		JLabel diagnosesLbl = new JLabel("Diagnoses");
		diagnosesLbl.setBounds(10, 110, 100, 20);
		panel_1.add(diagnosesLbl);

		JTextField diagnosesText = new JTextField();
		diagnosesText.setBounds(150, 110, 300, 80);
		panel_1.add(diagnosesText);
		diagnosesText.setColumns(10);

		JLabel reasonLbl = new JLabel("Reason for scan");
		reasonLbl.setBounds(10, 195, 100, 20);
		panel_1.add(reasonLbl);

		JTextField reasonText = new JTextField();
		reasonText.setBounds(150, 195, 300, 80);
		panel_1.add(reasonText);
		reasonText.setColumns(10);

		JButton createRadRes = new JButton("Create");
		createRadRes.setBounds(10, 420, 100, 30);
		panel_1.add(createRadRes);
		createRadRes.addActionListener(new InsertRadResults(medRecNumText, dateSchedText, xrayText, mriText, diagnosesText, reasonText));
		
		JButton updateRadRes = new JButton("Update");
		updateRadRes.setBounds(120, 420, 100, 30);
		panel_1.add(updateRadRes);
		updateRadRes.addActionListener(new UpdateRadResults(medRecNumText, dateSchedText, xrayText, mriText, diagnosesText, reasonText));

		JButton deleteRadRes = new JButton("Delete");
		deleteRadRes.setBounds(230, 420, 100, 30);
		panel_1.add(deleteRadRes);
		deleteRadRes.addActionListener(new DeleteRadResults(medRecNumText));		

		JButton searchRadRes = new JButton("Search");
		searchRadRes.setBounds(340, 420, 100, 30);
		panel_1.add(searchRadRes);
		searchRadRes.addActionListener(new SearchRadResults(medRecNumText, dateSchedText, xrayText, mriText, diagnosesText, reasonText));	
	}
}

class InsertRadResults implements ActionListener {
	
	private JTextField medRecNum;
	private JTextField dateSched;
	private JTextField xray;
	private JTextField mri;
	private JTextField diagnoses;
	private JTextField reason;

	public InsertRadResults( 
			     JTextField medRecNumIn,
			     JTextField dateSchedIn,
			     JTextField xrayIn,
			     JTextField mriIn,
			     JTextField diagnosesIn,
			     JTextField reasonIn
	) {
		medRecNum = medRecNumIn;
		dateSched = dateSchedIn;
		xray = xrayIn;
		mri = mriIn;
		diagnoses = diagnosesIn;
		reason = reasonIn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();

		System.out.println("Inside Insert Radiology Results");
		con.initialise("root", "p123");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mrn", medRecNum.getText());
		map.put("date_sched", dateSched.getText());
		map.put("xray", xray.getText());
		map.put("mri", mri.getText());
		map.put("diagnoses", diagnoses.getText());
		map.put("reason", reason.getText());
		
		data.insert(con.getConnection(), "RadResults", map);
	}
}

class UpdateRadResults implements ActionListener {

	private JTextField medRecNum;
	private JTextField dateSched;
	private JTextField xray;
	private JTextField mri;
	private JTextField diagnoses;
	private JTextField reason;

	public UpdateRadResults( 
		     JTextField medRecNumIn,
		     JTextField dateSchedIn,
		     JTextField xrayIn,
		     JTextField mriIn,
		     JTextField diagnosesIn,
		     JTextField reasonIn
	) {
		medRecNum = medRecNumIn;
		dateSched = dateSchedIn;
		xray = xrayIn;
		mri = mriIn;
		diagnoses = diagnosesIn;
		reason = reasonIn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();

		System.out.println("Inside Update Radiology Results");
		con.initialise("root", "p123");		

		Map<String, Object> keyMap = new HashMap<String, Object>();
		keyMap.put("mrn", medRecNum.getText());

		Map<String, Object> updateFields = new HashMap<String, Object>();
		if (!dateSched.getText().isEmpty())
			updateFields.put("date_sched", dateSched.getText());
		if (!xray.getText().isEmpty())
			updateFields.put("xray", xray.getText());
		if (!mri.getText().isEmpty())
			updateFields.put("mri", mri.getText());
		if (!diagnoses.getText().isEmpty())
			updateFields.put("diagnoses", diagnoses.getText());
		if (!reason.getText().isEmpty())
			updateFields.put("reason", reason.getText());

		data.update(con.getConnection(), "RadResults", keyMap, updateFields);
	}	
}

class DeleteRadResults implements ActionListener {

	private JTextField medRecNum;

	public DeleteRadResults( 
			     JTextField medRecNumIn
	) {

		medRecNum = medRecNumIn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();

		System.out.println("Inside Delete Radiology Results");
		con.initialise("root", "p123");

		Map<String, Object> delMap = new HashMap<String, Object>();
		delMap.put("mrn", medRecNum.getText());
		data.delete(con.getConnection(), "radresults", delMap);		
	}	
}

class SearchRadResults implements ActionListener {
	private JTextField medRecNum;
	private JTextField dateSched;
	private JTextField xray;
	private JTextField mri;
	private JTextField diagnoses;
	private JTextField reason;

	public SearchRadResults(
		     JTextField medRecNumIn,
		     JTextField dateSchedIn,
		     JTextField xrayIn,
		     JTextField mriIn,
		     JTextField diagnosesIn,
		     JTextField reasonIn
	) {

		medRecNum = medRecNumIn;
		dateSched = dateSchedIn;
		xray = xrayIn;
		mri = mriIn;
		diagnoses = diagnosesIn;
		reason = reasonIn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();

		System.out.println("Inside Search Radiology Results");
		con.initialise("root", "p123");

		Map<String, Object> keyMap = new HashMap<String, Object>();
		keyMap.put("mrn", medRecNum.getText());

		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		rows = data.retrieve(con.getConnection(), "radresults", keyMap);
		for(int i = 0; i < rows.size(); i++)
		{
			for( Map.Entry<String, Object> entry : rows.get(i).entrySet() )
			{				
				String key = entry.getKey();
				String value = entry.getValue().toString();
				
				System.out.println("Column: " + key + " Value: " + value);
				if (key.equals("DATE_SCHED")) {
					dateSched.setText(value);
				}
				if (key.equals("XRAY")) {
					xray.setText(value);
				}
				if (key.equals("MRI")) {
					mri.setText(value);
				}
				if (key.equals("DIAGNOSES")) {
					diagnoses.setText(value);
				}
				if (key.equals("REASON")) {
					reason.setText(value);
				}
			}
		}
	}
}
