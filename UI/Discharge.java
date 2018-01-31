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

public class Discharge implements ActionListener {
	private JTabbedPane tabbedPane;
	private String dbName;

	Discharge( JTabbedPane tabbedPaneIn ) {
		this.tabbedPane = tabbedPaneIn;
	}

	Discharge( JTabbedPane tabbedPaneIn, String dbNameIn, DBConnect con, DBBase database ) {
		this.tabbedPane = tabbedPaneIn;
		dbName = dbNameIn;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JPanel panel_1 = new JPanel();

		panel_1 = new JPanel();
		tabbedPane.addTab("Discharge Summary", panel_1);
		panel_1.setLayout(null);

		JLabel medRecNumLbl = new JLabel("Med Record #");
		medRecNumLbl.setBounds(10, 10, 100, 20);
		panel_1.add(medRecNumLbl);

		JTextField medRecNumText = new JTextField();
		medRecNumText.setBounds(150, 10, 130, 20);
		panel_1.add(medRecNumText);
		medRecNumText.setColumns(10);

		JLabel dischargeLbl = new JLabel("Discharge");
		dischargeLbl.setBounds(10, 35, 100, 20);
		panel_1.add(dischargeLbl);

		JTextField dischargeText = new JTextField();
		dischargeText.setBounds(150, 35, 130, 20);
		panel_1.add(dischargeText);
		dischargeText.setColumns(10);

		JLabel summaryLbl = new JLabel("Summary");
		summaryLbl.setBounds(10, 60, 100, 20);
		panel_1.add(summaryLbl);

		JTextField summaryText = new JTextField();
		summaryText.setBounds(150, 60, 300, 80);
		panel_1.add(summaryText);
		summaryText.setColumns(10);

		JButton createDischarge = new JButton("Create");
		createDischarge.setBounds(10, 420, 100, 30);
		panel_1.add(createDischarge);
		createDischarge.addActionListener(new InsertDischarge(medRecNumText, dischargeText, summaryText));
		
		JButton updateDischarge = new JButton("Update");
		updateDischarge.setBounds(120, 420, 100, 30);
		panel_1.add(updateDischarge);
		updateDischarge.addActionListener(new UpdateDischarge(medRecNumText, dischargeText, summaryText));

		JButton deleteDischarge = new JButton("Delete");
		deleteDischarge.setBounds(230, 420, 100, 30);
		panel_1.add(deleteDischarge);
		deleteDischarge.addActionListener(new DeleteDischarge(medRecNumText));		

		JButton searchDischarge = new JButton("Search");
		searchDischarge.setBounds(340, 420, 100, 30);
		panel_1.add(searchDischarge);
		searchDischarge.addActionListener(new SearchDischarge(medRecNumText, dischargeText, summaryText));
	}
}

class InsertDischarge implements ActionListener {
	
	private JTextField medRecNum;
	private JTextField discharge;
	private JTextField summary;

	public InsertDischarge( 
			     JTextField medRecNumIn,
			     JTextField dischargeIn,
			     JTextField summaryIn
	) {
		medRecNum = medRecNumIn;
		discharge = dischargeIn;
		summary = summaryIn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();

		System.out.println("Inside Insert Discharge record");
		con.initialise("root", "p123");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mrn", medRecNum.getText());
		map.put("discharge", discharge.getText());
		map.put("summary", summary.getText());
		data.insert(con.getConnection(), "Discharge", map);
	}
}

class UpdateDischarge implements ActionListener {
	
	private JTextField medRecNum;
	private JTextField discharge;
	private JTextField summary;

	public UpdateDischarge( 
			     JTextField medRecNumIn,
			     JTextField dischargeIn,
			     JTextField summaryIn
	) {
		medRecNum = medRecNumIn;
		discharge = dischargeIn;
		summary = summaryIn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();

		System.out.println("Inside Update Discharge record");
		con.initialise("root", "p123");		

		Map<String, Object> keyMap = new HashMap<String, Object>();
		keyMap.put("mrn", medRecNum.getText());

		Map<String, Object> updateFields = new HashMap<String, Object>();
		if (!discharge.getText().isEmpty())
			updateFields.put("discharge", discharge.getText());
		if (!summary.getText().isEmpty())
			updateFields.put("summary", summary.getText());

		data.update(con.getConnection(), "Discharge", keyMap, updateFields);
	}	
}

// Just the primary key MRN is required to delete
class DeleteDischarge implements ActionListener {

	private JTextField medRecNum;

	public DeleteDischarge( 
			     JTextField medRecNumIn
	) {

		medRecNum = medRecNumIn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();

		System.out.println("Inside Delete Discharge record");
		con.initialise("root", "p123");

		Map<String, Object> delMap = new HashMap<String, Object>();
		delMap.put("mrn", medRecNum.getText());
		data.delete(con.getConnection(), "discharge", delMap);		
	}	
}

class SearchDischarge implements ActionListener {
	
	private JTextField medRecNum;
	private JTextField discharge;
	private JTextField summary;

	public SearchDischarge( 
			     JTextField medRecNumIn,
			     JTextField dischargeIn,
			     JTextField summaryIn
	) {
		medRecNum = medRecNumIn;
		discharge = dischargeIn;
		summary = summaryIn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();

		System.out.println("Inside Search Discharge");
		con.initialise("root", "p123");

		Map<String, Object> keyMap = new HashMap<String, Object>();
		keyMap.put("mrn", medRecNum.getText());

		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		rows = data.retrieve(con.getConnection(), "discharge", keyMap);
		for(int i = 0; i < rows.size(); i++)
		{
			for( Map.Entry<String, Object> entry : rows.get(i).entrySet() )
			{				
				String key = entry.getKey();
				String value = entry.getValue().toString();
				
				System.out.println("Column: " + key + " Value: " + value);
				if (key.equals("DISCHARGE")) {
					discharge.setText(value);
				}
				if (key.equals("SUMMARY")) {
					summary.setText(value);
				}
			}
		}
	}
}
