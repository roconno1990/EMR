package UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Vitals implements ActionListener {

	private JTabbedPane tabbedPane;

	Vitals( JTabbedPane tabbedPaneInput ) {
		this.tabbedPane = tabbedPaneInput;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel panel_4;
		JTextField txtPulse;
		JTextField textField_2;
		JTextField textField_8;
		JTextField txtRepository;
		JTextField textField_9;
		JTextField textField_10;
		JTextField textField_11;
		JTextField textField_12;
		JTextField textField_13;
		JTextField textField_14;

		panel_4 = new JPanel();
		tabbedPane.addTab("Vital Signs", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblPulseRate = new JLabel("Pulse Rate");
		lblPulseRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPulseRate.setBounds(89, 72, 88, 16);
		panel_4.add(lblPulseRate);
		
		JLabel lblRhythm = new JLabel("Rhythm");
		lblRhythm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRhythm.setBounds(89, 144, 56, 16);
		panel_4.add(lblRhythm);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure");
		lblBloodPressure.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBloodPressure.setBounds(89, 221, 100, 16);
		panel_4.add(lblBloodPressure);
		
		JLabel lblRepsoitoryRate = new JLabel("Repsoitory Rate");
		lblRepsoitoryRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRepsoitoryRate.setBounds(89, 339, 117, 16);
		panel_4.add(lblRepsoitoryRate);
		
		JLabel lblTemperatre = new JLabel("Temperatre");
		lblTemperatre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTemperatre.setBounds(89, 442, 88, 16);
		panel_4.add(lblTemperatre);
		
		JLabel lblTemperatureMeasurementLocation = new JLabel("Location");
		lblTemperatureMeasurementLocation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTemperatureMeasurementLocation.setBounds(466, 442, 80, 16);
		panel_4.add(lblTemperatureMeasurementLocation);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHeight.setBounds(89, 513, 56, 16);
		panel_4.add(lblHeight);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWeight.setBounds(89, 567, 56, 16);
		panel_4.add(lblWeight);
		
		txtPulse = new JTextField();
		txtPulse.setBounds(217, 69, 116, 22);
		panel_4.add(txtPulse);
		txtPulse.setColumns(10);
		
		JLabel lblBeatsPerMinute = new JLabel("beats per minute");
		lblBeatsPerMinute.setBounds(345, 72, 127, 16);
		panel_4.add(lblBeatsPerMinute);
		
		JLabel label = new JLabel("(60-100)");
		label.setBounds(89, 90, 56, 16);
		panel_4.add(label);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(287, 167, 1, 1);
		panel_4.add(verticalBox);
		
		JList list_1 = new JList();
		list_1.setBounds(173, 143, 1, 1);
		panel_4.add(list_1);
		
		JLabel lblSystolic = new JLabel("Systolic");
		lblSystolic.setBounds(217, 221, 56, 16);
		panel_4.add(lblSystolic);
		
		JLabel lblDiastolic = new JLabel("Diastolic");
		lblDiastolic.setBounds(305, 221, 56, 16);
		panel_4.add(lblDiastolic);
		
		JLabel label_1 = new JLabel("(90-119)");
		label_1.setBounds(217, 238, 56, 16);
		panel_4.add(label_1);
		
		JLabel label_2 = new JLabel("(60-79)");
		label_2.setBounds(305, 238, 56, 16);
		panel_4.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(217, 267, 56, 22);
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(305, 267, 56, 22);
		panel_4.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel label_3 = new JLabel("/");
		label_3.setBounds(287, 270, 22, 19);
		panel_4.add(label_3);
		
		JLabel lblMmhg = new JLabel("mmHg");
		lblMmhg.setBounds(387, 270, 56, 16);
		panel_4.add(lblMmhg);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLocation.setBounds(466, 72, 56, 16);
		panel_4.add(lblLocation);
		
		JLabel label_8 = new JLabel("Location");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_8.setBounds(466, 270, 56, 16);
		panel_4.add(label_8);
		
		txtRepository = new JTextField();
		txtRepository.setBounds(217, 336, 116, 22);
		panel_4.add(txtRepository);
		txtRepository.setColumns(10);
		
		JLabel lblUnitType = new JLabel("Unit Type");
		lblUnitType.setBounds(121, 375, 56, 16);
		panel_4.add(lblUnitType);
		
		JRadioButton rdbtnUsStandard = new JRadioButton("U.S. Standard");
		rdbtnUsStandard.setBounds(202, 371, 127, 25);
		panel_4.add(rdbtnUsStandard);
		
		JRadioButton rdbtnMetric = new JRadioButton("Metric");
		rdbtnMetric.setBounds(329, 371, 127, 25);
		panel_4.add(rdbtnMetric);
		
		textField_9 = new JTextField();
		textField_9.setBounds(217, 439, 116, 22);
		panel_4.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblF = new JLabel("(92-103 F)");
		lblF.setBounds(345, 442, 68, 16);
		panel_4.add(lblF);
		
		textField_10 = new JTextField();
		textField_10.setBounds(217, 510, 116, 22);
		panel_4.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(217, 564, 116, 22);
		panel_4.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(710, 70, 116, 22);
		panel_4.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPosition.setBounds(710, 270, 56, 16);
		panel_4.add(lblPosition);
		
		textField_13 = new JTextField();
		textField_13.setBounds(710, 440, 116, 22);
		panel_4.add(textField_13);
		textField_13.setColumns(10);
		
		JComboBox comboBox_Rythm = new JComboBox();
		comboBox_Rythm.setModel(new DefaultComboBoxModel(new String[] {"-choose", "Regular", "Arrhythmia", "Tachycardia", "Bradycardia"}));
		comboBox_Rythm.setToolTipText("");
		comboBox_Rythm.setBounds(217, 142, 116, 22);
		panel_4.add(comboBox_Rythm);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"-choose", "Left Arm", "Right Arm"}));
		comboBox_4.setBounds(558, 267, 116, 22);
		panel_4.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"-choose", "Sitting", "Standing", "Laying"}));
		comboBox_5.setBounds(788, 267, 108, 22);
		panel_4.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"-choose", "Radial", "Carotid", "Femoral", "Pedal", "Brachial", "Apical"}));
		comboBox_6.setBounds(558, 70, 116, 22);
		panel_4.add(comboBox_6);
		
		textField_14 = new JTextField();
		textField_14.setBounds(356, 142, 142, 22);
		panel_4.add(textField_14);
		textField_14.setColumns(10);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"-choose", "Orally", "Rectally", "Axillary", "By Ear", "By Skin"}));
		comboBox_7.setBounds(557, 440, 117, 22);
		panel_4.add(comboBox_7);
		
		JLabel lblInches = new JLabel("inches");
		lblInches.setBounds(345, 514, 56, 16);
		panel_4.add(lblInches);
		
		JLabel lblLbs = new JLabel("lbs");
		lblLbs.setBounds(345, 568, 56, 16);
		panel_4.add(lblLbs);	
	}
	
}