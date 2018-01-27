package UI;

import base.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

class PatientInfo implements ActionListener {

	private JTabbedPane tabbedPane;

	private JTextField firstNameText = new JTextField();
	private JTextField middleNameText = new JTextField();
	private JTextField lastNameText = new JTextField();
	private JTextField medRecNumText = new JTextField();
	private JTextField financeNumText = new JTextField();
	private JTextField socialSecNumText = new JTextField();
	private JTextField addressText = new JTextField();
	private JTextField attendingPhysText = new JTextField();
	private JTextField caringNurseText = new JTextField();
	private JTextField roomNumText = new JTextField();
	private JTextField locationText = new JTextField();
	private JTextField patientNumText = new JTextField();

	PatientInfo( JTabbedPane tabbedPaneInput,
			     String      firstNameIn,
			     String      middleNameIn,
			     String      lastNameIn,
			     String      medRecIn,
			     String      financeNumIn,
			     String      socialSecIn,
			     String      addressIn,
			     String      attendingPhysIn,
			     String      caringNurseIn,
			     String      roomNumIn,
			     String      locationIn,
			     String      patientNumIn ) {
		this.tabbedPane = tabbedPaneInput;

		setFirstName(firstNameIn);
		setMiddleName(middleNameIn);
		setLastName(lastNameIn);
		setMedRec(medRecIn);
		setFinanceNum(financeNumIn);
		setSocialSec(socialSecIn);
		setAddress(addressIn);
		setAttendingPhys(attendingPhysIn);
		setCaringNurse(caringNurseIn);
		setRoomNum(roomNumIn);
		setLocation(locationIn);
		setPatientNum(patientNumIn);
	}

	public String getFirstName() {
		return firstNameText.getText();
	}

	public void setFirstName(String t) {
		firstNameText.setText(t);
	}

	public String getMiddleName() {
		return middleNameText.getText();
	}

	public void setMiddleName(String t) {
		middleNameText.setText(t);
	}

	public String getLastName() {
		return lastNameText.getText();
	}

	public void setLastName(String t) {
		lastNameText.setText(t);
	}

	public String getMedRec() {
		return medRecNumText.getText();
	}

	public void setMedRec(String t) {
		medRecNumText.setText(t);
	}

	public String getFinanceNum() {
		return financeNumText.getText();
	}

	public void setFinanceNum(String t) {
		financeNumText.setText(t);
	}

	public String getSocialSec() {
		return socialSecNumText.getText();
	}

	public void setSocialSec(String t) {
		socialSecNumText.setText(t);
	}

	public String getAddress() {
		return addressText.getText();
	}

	public void setAddress(String t) {
		addressText.setText(t);
	}

	public String getAttendingPhys() {
		return attendingPhysText.getText();
	}

	public void setAttendingPhys(String t) {
		attendingPhysText.setText(t);
	}

	public String getCaringNurse() {
		return caringNurseText.getText();
	}

	public void setCaringNurse(String t) {
		caringNurseText.setText(t);
	}

	public String getRoomNum() {
		return roomNumText.getText();
	}

	public void setRoomNum(String t) {
		roomNumText.setText(t);
	}

	public String getLocation() {
		return locationText.getText();
	}

	public void setLocation( String t ) {
		locationText.setText(t);
	}

	public String getPatientNum() {
		return patientNumText.getText();
	}

	public void setPatientNum(String t) {
		patientNumText.setText(t);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel panel_1 = new JPanel();

		panel_1 = new JPanel();
		tabbedPane.addTab("Patient Information", panel_1);
		panel_1.setLayout(null);
		
		JLabel firstName = new JLabel("First Name");
		firstName.setBounds(10, 7, 100, 16);
		panel_1.add(firstName);
		
		firstNameText.setBounds(150, 7, 130, 20);
		panel_1.add(firstNameText);
		firstNameText.setColumns(10);

		JLabel middleName = new JLabel("Middle Name");
		middleName.setBounds(10, 32, 100, 16);
		panel_1.add(middleName);
		
		middleNameText.setBounds(150, 32, 130, 20);
		panel_1.add(middleNameText);
		middleNameText.setColumns(10);

		JLabel lastName = new JLabel("Last Name");
		lastName.setBounds(10, 57, 100, 16);
		panel_1.add(lastName);
		
		lastNameText.setBounds(150, 57, 130, 20);
		panel_1.add(lastNameText);
		lastNameText.setColumns(10);
		
		JLabel medRecNum = new JLabel("Medical Record");
		medRecNum.setBounds(10, 83, 120, 20);
		panel_1.add(medRecNum);
		
		medRecNumText.setBounds(150, 85, 130, 20);
		panel_1.add(medRecNumText);
		medRecNumText.setColumns(10);

		JLabel financeNum = new JLabel("Financial Num");
		financeNum.setBounds(10, 110, 120, 20);
		panel_1.add(financeNum);
		
		financeNumText.setBounds(150, 110, 130, 20);
		panel_1.add(financeNumText);
		financeNumText.setColumns(10);

		JLabel socialSecNum = new JLabel("Social Security");
		socialSecNum.setBounds(10, 140, 120, 20);
		panel_1.add(socialSecNum);
		
		socialSecNumText.setBounds(150, 140, 130, 20);
		panel_1.add(socialSecNumText);
		socialSecNumText.setColumns(10);

		JLabel address = new JLabel("Address");
		address.setBounds(10, 175, 120, 20);
		panel_1.add(address);
		
		addressText.setBounds(150, 167, 180, 70);
		panel_1.add(addressText);
		addressText.setColumns(10);

		JLabel attendingPhys = new JLabel("Attending Phys");
		attendingPhys.setBounds(10, 250, 120, 20);
		panel_1.add(attendingPhys);
		
		attendingPhysText.setBounds(150, 250, 130, 20);
		panel_1.add(attendingPhysText);
		attendingPhysText.setColumns(10);

		JLabel caringNurse = new JLabel("Caring Nurse");
		caringNurse.setBounds(10, 280, 120, 20);
		panel_1.add(caringNurse);
		
		caringNurseText.setBounds(150, 280, 130, 20);
		panel_1.add(caringNurseText);
		caringNurseText.setColumns(10);

		JLabel roomNum = new JLabel("Room Number");
		roomNum.setBounds(10, 310, 120, 20);
		panel_1.add(roomNum);
		
		roomNumText.setBounds(150, 310, 130, 20);
		panel_1.add(roomNumText);
		roomNumText.setColumns(10);

		JLabel location = new JLabel("Location");
		location.setBounds(10, 340, 120, 20);
		panel_1.add(location);
		
		locationText.setBounds(150, 340, 130, 20);
		panel_1.add(locationText);
		locationText.setColumns(10);

		JLabel patientNum = new JLabel("Patient Number");
		patientNum.setBounds(10, 370, 120, 20);
		panel_1.add(patientNum);
		
		patientNumText.setBounds(150, 370, 130, 20);
		panel_1.add(patientNumText);
		patientNumText.setColumns(10);

		JButton create = new JButton("Create Info");
		create.setBounds(10, 400, 130, 30);
		panel_1.add(create);

		CreatePatientInfo createPatientInfo =
	        new CreatePatientInfo( firstNameText,
	        		               middleNameText,
	        		               lastNameText,
	        		               medRecNumText,
	        		               financeNumText,
	        		               socialSecNumText,
	        		               addressText,
	        		               attendingPhysText,
	        		               caringNurseText,
	        		               roomNumText,
	        		               locationText,
	        		               patientNumText );

		create.addActionListener(createPatientInfo);

		JButton update = new JButton("Update Info");
		update.setBounds(150, 400, 130, 30);
		panel_1.add(update);

		CreatePatientInfo updatePatientInfo =
		        new CreatePatientInfo( firstNameText,
		        		               middleNameText,
		        		               lastNameText,
		        		               medRecNumText,
		        		               financeNumText,
		        		               socialSecNumText,
		        		               addressText,
		        		               attendingPhysText,
		        		               caringNurseText,
		        		               roomNumText,
		        		               locationText,
		        		               patientNumText );

		update.addActionListener(updatePatientInfo);
	}
}

class UpdatePatientInfo implements ActionListener {

	private JTextField firstName;
	private JTextField middleName;
	private JTextField lastName;
	private JTextField medRecNum;
	private JTextField financeNum;
	private JTextField socialSecNum;
	private JTextField address;
	private JTextField attendingPhys;
	private JTextField caringNurse;
	private JTextField roomNum;
	private JTextField location;
	private JTextField patientNum;

	UpdatePatientInfo( JTextField  firstNameIn,
			           JTextField  middleNameIn,
			           JTextField  lastNameIn,
			           JTextField  medRecNumIn,
			           JTextField  financeNumIn,
			           JTextField  socialSecIn,
			           JTextField  addressIn,
			           JTextField  attendingPhysIn,
			           JTextField  caringNurseIn,
			           JTextField  roomNumIn,
			           JTextField  locationIn,
			           JTextField  patientNumIn ) {

		firstName = firstNameIn;
		middleName = middleNameIn;
		lastName = lastNameIn;
		medRecNum = medRecNumIn;
		financeNum = financeNumIn;
		socialSecNum = socialSecIn;
		address = addressIn;
		attendingPhys = attendingPhysIn;
		caringNurse = caringNurseIn;
		roomNum = roomNumIn;
		location = locationIn;
		patientNum = patientNumIn;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();

		con.initialise("root", "offspring1");

		Map<String, Object> keyMap = new HashMap<String, Object>();
		keyMap.put("patient_id", patientNum.getText());

		Map<String, Object> updateMap = new HashMap<String, Object>();		
		updateMap.put("update_time", data.getCurrentTimeStamp());
		updateMap.put("first_name", firstName.getText());
		updateMap.put("middle_name", middleName.getText());
		updateMap.put("last_name", lastName.getText());
		updateMap.put("med_rec_ref", medRecNum.getText());
		updateMap.put("finance_ref", financeNum.getText());
		updateMap.put("social_security", socialSecNum.getText());
		updateMap.put("address", address.getText());
		updateMap.put("attending_physician", attendingPhys.getText());
		updateMap.put("caring_nurse", caringNurse.getText());
		updateMap.put("room_num", roomNum.getText());
		updateMap.put("location", location.getText());

		data.update(con.getConnection(), "patient", keyMap, updateMap);
		
	}
	
}

class CreatePatientInfo implements ActionListener {

	private JTextField firstName;
	private JTextField middleName;
	private JTextField lastName;
	private JTextField medRecNum;
	private JTextField financeNum;
	private JTextField socialSecNum;
	private JTextField address;
	private JTextField attendingPhys;
	private JTextField caringNurse;
	private JTextField roomNum;
	private JTextField location;
	private JTextField patientNum;

	CreatePatientInfo( JTextField  firstNameIn,
			           JTextField  middleNameIn,
			           JTextField  lastNameIn,
			           JTextField  medRecNumIn,
			           JTextField  financeNumIn,
			           JTextField  socialSecIn,
			           JTextField  addressIn,
			           JTextField  attendingPhysIn,
			           JTextField  caringNurseIn,
			           JTextField  roomNumIn,
			           JTextField  locationIn,
			           JTextField  patientNumIn ) {

		firstName = firstNameIn;
		middleName = middleNameIn;
		lastName = lastNameIn;
		medRecNum = medRecNumIn;
		financeNum = financeNumIn;
		socialSecNum = socialSecIn;
		address = addressIn;
		attendingPhys = attendingPhysIn;
		caringNurse = caringNurseIn;
		roomNum = roomNumIn;
		location = locationIn;
		patientNum = patientNumIn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();

		con.initialise("root", "offspring1");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("patient_id", patientNum.getText());
		map.put("update_time", data.getCurrentTimeStamp());
		map.put("first_name", firstName.getText());
		map.put("middle_name", middleName.getText());
		map.put("last_name", lastName.getText());
		map.put("med_rec_ref", medRecNum.getText());
		map.put("finance_ref", financeNum.getText());
		map.put("social_security", socialSecNum.getText());
		map.put("address", address.getText());
		map.put("attending_physician", attendingPhys.getText());
		map.put("caring_nurse", caringNurse.getText());
		map.put("room_num", roomNum.getText());
		map.put("location", location.getText());
		
		data.insert(con.getConnection(), "patient", map);
	}
	
}