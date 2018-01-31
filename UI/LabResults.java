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

public class LabResults implements ActionListener {
	private JTabbedPane tabbedPane;
	private String dbName;

	LabResults( JTabbedPane tabbedPaneIn ) {
		this.tabbedPane = tabbedPaneIn;
	}

	LabResults( JTabbedPane tabbedPaneIn, String dbNameIn, DBConnect con, DBBase database ) {
		this.tabbedPane = tabbedPaneIn;
		dbName = dbNameIn;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JPanel panel_1 = new JPanel();

		panel_1 = new JPanel();
		tabbedPane.addTab("Lab Results", panel_1);
		panel_1.setLayout(null);

		JLabel medRecNumLbl = new JLabel("Med Record #");
		medRecNumLbl.setBounds(10, 10, 100, 20);
		panel_1.add(medRecNumLbl);

		JTextField medRecNumText = new JTextField();
		medRecNumText.setBounds(150, 10, 130, 20);
		panel_1.add(medRecNumText);
		medRecNumText.setColumns(10);

		JLabel dateCollectedLbl = new JLabel("Date Collected");
		dateCollectedLbl.setBounds(10, 35, 100, 20);
		panel_1.add(dateCollectedLbl);

		JTextField dateCollText = new JTextField();
		dateCollText.setBounds(150, 35, 130, 20);
		panel_1.add(dateCollText);
		dateCollText.setColumns(10);

		JLabel cholesterolLbl = new JLabel("Cholesterol");
		cholesterolLbl.setBounds(10, 60, 100, 20);
		panel_1.add(cholesterolLbl);

		JTextField cholesterolText = new JTextField();
		cholesterolText.setBounds(150, 60, 130, 20);
		panel_1.add(cholesterolText);
		cholesterolText.setColumns(10);

		JLabel fastingSugarLbl = new JLabel("Fasting Sugar");
		fastingSugarLbl.setBounds(10, 85, 100, 20);
		panel_1.add(fastingSugarLbl);

		JTextField fastingSugarText = new JTextField();
		fastingSugarText.setBounds(150, 85, 130, 20);
		panel_1.add(fastingSugarText);
		fastingSugarText.setColumns(10);

		JLabel diagnosesLbl = new JLabel("Diagnoses");
		diagnosesLbl.setBounds(10, 110, 100, 20);
		panel_1.add(diagnosesLbl);

		JTextField diagnosesText = new JTextField();
		diagnosesText.setBounds(150, 110, 300, 80);
		panel_1.add(diagnosesText);
		diagnosesText.setColumns(10);

		JLabel reasonLbl = new JLabel("Visit Reason");
		reasonLbl.setBounds(10, 195, 100, 20);
		panel_1.add(reasonLbl);

		JTextField reasonText = new JTextField();
		reasonText.setBounds(150, 195, 300, 80);
		panel_1.add(reasonText);
		reasonText.setColumns(10);

		JButton createLabRes = new JButton("Create");
		createLabRes.setBounds(10, 420, 100, 30);
		panel_1.add(createLabRes);
		createLabRes.addActionListener(new InsertLabResults(medRecNumText, dateCollText, cholesterolText, fastingSugarText, diagnosesText, reasonText));
		
		JButton updateLabRes = new JButton("Update");
		updateLabRes.setBounds(120, 420, 100, 30);
		panel_1.add(updateLabRes);
		updateLabRes.addActionListener(new UpdateLabResults(medRecNumText, dateCollText, cholesterolText, fastingSugarText, diagnosesText, reasonText));

		JButton deleteLabRes = new JButton("Delete");
		deleteLabRes.setBounds(230, 420, 100, 30);
		panel_1.add(deleteLabRes);
		deleteLabRes.addActionListener(new DeleteLabResults(medRecNumText));		

		JButton searchLabRes = new JButton("Search");
		searchLabRes.setBounds(340, 420, 100, 30);
		panel_1.add(searchLabRes);
		searchLabRes.addActionListener(new SearchLabResults(medRecNumText, dateCollText, cholesterolText, fastingSugarText, diagnosesText, reasonText));	
	}
}

class InsertLabResults implements ActionListener {
	
	private JTextField medRecNum;
	private JTextField dateCollected;
	private JTextField cholesterol;
	private JTextField fastingSugar;
	private JTextField diagnoses;
	private JTextField reason;

	public InsertLabResults( 
			     JTextField medRecNumIn,
			     JTextField dateCollectedIn,
			     JTextField cholesterolIn,
			     JTextField fastingSugarIn,
			     JTextField diagnosesIn,
			     JTextField reasonIn
	) {
		medRecNum = medRecNumIn;
		dateCollected = dateCollectedIn;
		cholesterol = cholesterolIn;
		fastingSugar = fastingSugarIn;
		diagnoses = diagnosesIn;
		reason = reasonIn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();

		System.out.println("Inside Insert Lab Results");
		con.initialise("root", "p123");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mrn", medRecNum.getText());
		map.put("date_collected", dateCollected.getText());
		map.put("cholesterol", cholesterol.getText());
		map.put("fasting_sugar", fastingSugar.getText());
		map.put("diagnoses", diagnoses.getText());
		map.put("reason", reason.getText());
		
		data.insert(con.getConnection(), "LabResults", map);
	}
}

class UpdateLabResults implements ActionListener {

	private JTextField medRecNum;
	private JTextField dateCollected;
	private JTextField cholesterol;
	private JTextField fastingSugar;
	private JTextField diagnoses;
	private JTextField reason;

	public UpdateLabResults( 
		     JTextField medRecNumIn,
		     JTextField dateCollectedIn,
		     JTextField cholesterolIn,
		     JTextField fastingSugarIn,
		     JTextField diagnosesIn,
		     JTextField reasonIn
	) {
		medRecNum = medRecNumIn;
		dateCollected = dateCollectedIn;
		cholesterol = cholesterolIn;
		fastingSugar = fastingSugarIn;
		diagnoses = diagnosesIn;
		reason = reasonIn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();

		System.out.println("Inside Update Lab Results");
		con.initialise("root", "p123");		

		Map<String, Object> keyMap = new HashMap<String, Object>();
		keyMap.put("mrn", medRecNum.getText());

		Map<String, Object> updateFields = new HashMap<String, Object>();
		if (!dateCollected.getText().isEmpty())
			updateFields.put("date_collected", dateCollected.getText());
		if (!cholesterol.getText().isEmpty())
			updateFields.put("cholesterol", cholesterol.getText());
		if (!fastingSugar.getText().isEmpty())
			updateFields.put("fasting_sugar", fastingSugar.getText());
		if (!diagnoses.getText().isEmpty())
			updateFields.put("diagnoses", diagnoses.getText());
		if (!reason.getText().isEmpty())
			updateFields.put("reason", reason.getText());

		data.update(con.getConnection(), "LabResults", keyMap, updateFields);
	}	
}

class DeleteLabResults implements ActionListener {

	private JTextField medRecNum;

	public DeleteLabResults( 
			     JTextField medRecNumIn
	) {

		medRecNum = medRecNumIn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();

		System.out.println("Inside Delete Lab Results");
		con.initialise("root", "p123");

		Map<String, Object> delMap = new HashMap<String, Object>();
		delMap.put("mrn", medRecNum.getText());
		data.delete(con.getConnection(), "labresults", delMap);		
	}	
}

class SearchLabResults implements ActionListener {
	private JTextField medRecNum;
	private JTextField dateCollected;
	private JTextField cholesterol;
	private JTextField fastingSugar;
	private JTextField diagnoses;
	private JTextField reason;

	public SearchLabResults(
		     JTextField medRecNumIn,
		     JTextField dateCollectedIn,
		     JTextField cholesterolIn,
		     JTextField fastingSugarIn,
		     JTextField diagnosesIn,
		     JTextField reasonIn
	) {

		medRecNum = medRecNumIn;
		dateCollected = dateCollectedIn;
		cholesterol = cholesterolIn;
		fastingSugar = fastingSugarIn;
		diagnoses = diagnosesIn;
		reason = reasonIn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();

		System.out.println("Inside Search Lab Results");
		con.initialise("root", "p123");

		Map<String, Object> keyMap = new HashMap<String, Object>();
		keyMap.put("mrn", medRecNum.getText());

		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		rows = data.retrieve(con.getConnection(), "labresults", keyMap);
		for(int i = 0; i < rows.size(); i++)
		{
			for( Map.Entry<String, Object> entry : rows.get(i).entrySet() )
			{				
				String key = entry.getKey();
				String value = entry.getValue().toString();
				
				System.out.println("Column: " + key + " Value: " + value);
				if (key.equals("DATE_COLLECTED")) {
					dateCollected.setText(value);
				}
				if (key.equals("CHOLESTEROL")) {
					cholesterol.setText(value);
				}
				if (key.equals("FASTING_SUGAR")) {
					fastingSugar.setText(value);
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
