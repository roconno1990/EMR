package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Physician_UI {

	private JFrame frame;
	 private final JLabel lblNewLabel = new JLabel("ELECTRONIC MEDICAL RECORD");
	   private JTextField txtPatientNameMrn;
	   private JTabbedPane tabbedPane;
		private JPanel panel;
		private JPanel panel_1;
		private JPanel panel_4;
		private JLabel lblNewLabel_2;
		private JLabel lblNewLabel_3;
		private JLabel lblNewLabel_4;
		private JLabel lblNewLabel_5;
		private JList list;
		private JLabel lblNewLabel_6;
		private JLabel lblNewLabel_7;
		private JLabel lblNewLabel_8;
		private JLabel lblNewLabel_9;
		private JLabel lblNewLabel_10;
		private JLabel lblNewLabel_11;
		private JLabel lblNewLabel_12;
		private JLabel lblNewLabel_13;
		private JEditorPane editorPane_6;
		private JComboBox comboBox;
		private JComboBox comboBox_1;
		private JComboBox comboBox_2;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_3;
		private JTextField textField_4;
		private JTextField textField_5;
		private JTextField textField_6;
		private JTextField textField_7;
		private JCheckBox chckbxNewCheckBox;
		private final ButtonGroup buttonGroup = new ButtonGroup();
		private JComboBox comboBox_3;
		private JTextField txtPulse;
		private JTextField textField_2;
		private JTextField textField_8;
		private JTextField txtRepository;
		private JTextField textField_9;
		private JTextField textField_10;
		private JTextField textField_11;
		private JTextField textField_12;
		private JTextField textField_13;
		private JTextField textField_14;
		private JTextField textField_15;
		private JTextField textField_16;
		private JTextField textField_17;
		private JTextField textField_18;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Physician_UI window = new Physician_UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Physician_UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Physician");
		frame.setBounds(0, 0, 1250, 799);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
	    lblNewLabel.setBounds(10, 0, 697, 35);
	    frame.getContentPane().add(lblNewLabel);
	      
	    // column tab
	    JPanel panel_2 = new JPanel();
	    panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
	    panel_2.setBounds(30, 90, 144, 900);
	    frame.getContentPane().add(panel_2);	
	    panel_2.setLayout(null);
			
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(171, 47, 1135, 713);
		frame.getContentPane().add(tabbedPane);
			
		panel = new JPanel();
		tabbedPane.addTab("Home", null, panel, null);
		panel.setLayout(null);
			
		JLabel lblSearchPatient = new JLabel("Search Patient:");
		lblSearchPatient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchPatient.setBounds(137, 34, 98, 16);
		panel.add(lblSearchPatient);
			
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_15.setBounds(247, 31, 283, 22);
		panel.add(textField_15);
		textField_15.setColumns(10);
			
		JLabel lblSelectPatient = new JLabel("Select Patient:");
		lblSelectPatient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectPatient.setBounds(143, 149, 92, 16);
		panel.add(lblSelectPatient);
			
		JList list_2 = new JList();
		list_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list_2.setBounds(143, 178, 778, 155);
		panel.add(list_2);
			
		JButton btnSelect = new JButton("Select");
		btnSelect.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSelect.setBounds(504, 431, 97, 25);
		panel.add(btnSelect);
			
		JButton btnExit_1 = new JButton("Exit");
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				frame = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
				
		});
		btnExit_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit_1.setBounds(504, 497, 97, 25);
		panel.add(btnExit_1);
			
		panel_1 = new JPanel();
		tabbedPane.addTab("Allergy", null, panel_1, null);
		panel_1.setLayout(null);
			
		list = new JList();
		list.setBounds(4, 17, 0, 0);
		panel_1.add(list);
			
		lblNewLabel_13 = new JLabel("Substance");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_13.setBounds(99, 17, 67, 16);
		panel_1.add(lblNewLabel_13);
			
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(178, 15, 114, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
			
		lblNewLabel_12 = new JLabel("Type");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(132, 52, 34, 16);
		panel_1.add(lblNewLabel_12);
			
		lblNewLabel_11 = new JLabel("Category");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(99, 88, 67, 16);
		panel_1.add(lblNewLabel_11);
			
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setBounds(178, 86, 114, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
			
		lblNewLabel_10 = new JLabel("Severity");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(109, 123, 55, 16);
		panel_1.add(lblNewLabel_10);
			
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Low", "Medium", "High", "Critical"}));
		comboBox_1.addContainerListener(new ContainerAdapter() {
			public void componentAdded(ContainerEvent arg0) {
			}
		});
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBox_1.setBounds(178, 119, 90, 25);
		comboBox_1.setToolTipText("");
		panel_1.add(comboBox_1);
			
		lblNewLabel_9 = new JLabel("Reactions");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(99, 159, 67, 16);
		panel_1.add(lblNewLabel_9);
			
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setBounds(178, 157, 114, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
			
		lblNewLabel_8 = new JLabel("Interaction");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(96, 229, 70, 16);
		panel_1.add(lblNewLabel_8);
			
		comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		comboBox_2.setBounds(178, 225, 80, 25);
		panel_1.add(comboBox_2);
			
		lblNewLabel_7 = new JLabel("Comment");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(498, 123, 67, 16);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblNewLabel_7);
			
		editorPane_6 = new JEditorPane();
		editorPane_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editorPane_6.setBounds(577, 51, 134, 22);
		panel_1.add(editorPane_6);
			
		lblNewLabel_6 = new JLabel("Source");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(117, 268, 49, 16);
		panel_1.add(lblNewLabel_6);
			
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Drug", "Food ", "Rhinitis", "Seasonal", "Skin", "Pet"}));
		comboBox.setBounds(178, 264, 100, 25);
		panel_1.add(comboBox);
			
		lblNewLabel_5 = new JLabel("Reaction Status");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(60, 192, 106, 16);
		panel_1.add(lblNewLabel_5);
			
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setBounds(577, 121, 411, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
			
		lblNewLabel_4 = new JLabel("Reviewed By Who?");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(440, 52, 125, 16);
		panel_1.add(lblNewLabel_4);
			
		textField_6 = new JTextField();
		textField_6.setBounds(577, 87, 134, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
			
		lblNewLabel_3 = new JLabel("Estimated Onset");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(456, 88, 109, 16);
		panel_1.add(lblNewLabel_3);
			
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setBounds(178, 190, 114, 20);
		textField_7.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
			
		lblNewLabel_2 = new JLabel("Updated Time");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(471, 17, 94, 16);
		panel_1.add(lblNewLabel_2);
			
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(577, 15, 134, 20);
		panel_1.add(textField);
		textField.setColumns(10);
			
		chckbxNewCheckBox = new JCheckBox("Show As Read");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxNewCheckBox.setBounds(44, 356, 122, 24);
		panel_1.add(chckbxNewCheckBox);
			
		comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"FOOD", "Balsam of Peru", "Egg", "Fish or shellfish", "Fruit", "Gluten", "Garlic", "Hot peppers", "Oats", "Meat", "Milk", "Peanut", "Rice", "Sesame", "Soy", "Sulfites", "Tartrazine", "Tree nut", "Wheat", "", "DRUG", "Balsam of Peru", "Cephalosporins", "Dilantin", "Intravenous contrast dye", "Local anesthetics", "Non-Seroidal anti-inflammatories", "(Cromolyn sodium, nedocrmil sodium, etc.)", "Penicillin", "Sulfonamides", "Tegretol", "Tetracycline", "", "ENVIRONMENTAL", "Balsam of Peru", "Cat", "Chromium", "Cobalt Chloride", "Cosmetics", "Dog ", "Formaldehyde", "Fungicide", "Gold (gold sodium thiosulfate)", "House dust mite", "Insect Sting", "Latex", "Mold", "Nickel(nickel sulfate hexahydrate)", "Perfume", "Photographic developers", "Pollen", "Semen", "Water"}));
		comboBox_3.setBounds(178, 48, 147, 25);
		panel_1.add(comboBox_3);
			
		JButton btnUpdateAllergies = new JButton("Update Allergies");
		btnUpdateAllergies.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdateAllergies.setBounds(440, 490, 169, 25);
		panel_1.add(btnUpdateAllergies);
			
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				frame = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBounds(440, 556, 169, 25);
		panel_1.add(btnExit);
			
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
			
		JButton btnUpdateVitals = new JButton("Update Vitals");
		btnUpdateVitals.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdateVitals.setBounds(375, 630, 142, 25);
		panel_4.add(btnUpdateVitals);
			
		JButton btnExit_2 = new JButton("Exit");
		btnExit_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				frame = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnExit_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit_2.setBounds(604, 630, 97, 25);
		panel_4.add(btnExit_2);
			
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Reason For Visit", null, panel_5, null);
		panel_5.setLayout(null);
			
		JLabel lblReasonForPatient = new JLabel("Reason for Patient Visit:");
		lblReasonForPatient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblReasonForPatient.setBounds(75, 70, 160, 16);
		panel_5.add(lblReasonForPatient);
			
		JTextPane textPane = new JTextPane();
		textPane.setBounds(75, 99, 919, 166);
		panel_5.add(textPane);
			
		JButton btnNewButton_1 = new JButton("Update Reason");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(457, 348, 152, 25);
		panel_5.add(btnNewButton_1);
			
		JButton btnExit_3 = new JButton("Exit");
		btnExit_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				frame = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnExit_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit_3.setBounds(457, 399, 152, 25);
		panel_5.add(btnExit_3);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Scans & Labs", null, panel_7, null);
		panel_7.setLayout(null);
		
		JLabel label_4 = new JLabel("Type of Scan:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(127, 61, 93, 16);
		panel_7.add(label_4);
		
		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setModel(new DefaultComboBoxModel(new String[] {"MRI", "CT", "PET", "PET-CT", "Ultrasound", "X-Ray"}));
		comboBox_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_10.setBounds(232, 59, 133, 22);
		panel_7.add(comboBox_10);
		
		JLabel label_5 = new JLabel("Area Being Scanned:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(85, 117, 135, 16);
		panel_7.add(label_5);
		
		JComboBox comboBox_11 = new JComboBox();
		comboBox_11.setModel(new DefaultComboBoxModel(new String[] {"Head", "Neck", "Upper Back", "Lower Back", "Torse", "Left Arm", "Right Arm", "Chest", "Left Leg", "Right Leg", "Left Hand", "Right Hand", "Left Foot", "Right Foot"}));
		comboBox_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_11.setBounds(232, 115, 133, 22);
		panel_7.add(comboBox_11);
		
		JLabel lblLabs = new JLabel("Lab Results:");
		lblLabs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLabs.setBounds(141, 365, 79, 16);
		panel_7.add(lblLabs);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(141, 394, 759, 189);
		panel_7.add(textArea_2);
		
		JLabel lblScanResults = new JLabel("Scan Results:");
		lblScanResults.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblScanResults.setBounds(133, 174, 87, 16);
		panel_7.add(lblScanResults);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(141, 203, 759, 104);
		panel_7.add(textArea_3);
		
		JButton btnSave_3 = new JButton("Save");
		btnSave_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave_3.setBounds(484, 596, 97, 25);
		panel_7.add(btnSave_3);
		
		JButton btnExit_8 = new JButton("Exit");
		btnExit_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnExit_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit_8.setBounds(484, 634, 97, 25);
		panel_7.add(btnExit_8);
			
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Patient Questions/Concerns", null, panel_6, null);
		panel_6.setLayout(null);
			
		JLabel lblPatientQuestions = new JLabel("Patient Questions:");
		lblPatientQuestions.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPatientQuestions.setBounds(160, 76, 132, 16);
		panel_6.add(lblPatientQuestions);
			
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(160, 120, 747, 163);
		panel_6.add(textArea);
			
		JLabel lblPatientConcersns = new JLabel("Patient Concersns:");
		lblPatientConcersns.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPatientConcersns.setBounds(160, 334, 132, 16);
		panel_6.add(lblPatientConcersns);
			
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(160, 375, 747, 163);
		panel_6.add(textArea_1);
			
		JButton btnUpdateQuestionsconcerns = new JButton("Update Questions/Concerns");
		btnUpdateQuestionsconcerns.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdateQuestionsconcerns.setBounds(426, 584, 243, 25);
		panel_6.add(btnUpdateQuestionsconcerns);
			
		JButton btnExit_4 = new JButton("Exit");
		btnExit_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				frame = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnExit_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit_4.setBounds(495, 622, 97, 25);
		panel_6.add(btnExit_4);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Notes", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNotes = new JLabel("Notes:");
		lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNotes.setBounds(200, 72, 48, 16);
		panel_3.add(lblNotes);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(200, 101, 677, 345);
		panel_3.add(textArea_4);
		
		JButton btnSave = new JButton("Save ");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setBounds(479, 518, 97, 25);
		panel_3.add(btnSave);
		
		JButton btnExit_7 = new JButton("Exit");
		btnExit_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnExit_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit_7.setBounds(479, 563, 97, 25);
		panel_3.add(btnExit_7);
		
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("Diagnosis", null, panel_8, null);
		panel_8.setLayout(null);
		
		JLabel lblPatientDiagnosis = new JLabel("Patient Diagnosis:");
		lblPatientDiagnosis.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPatientDiagnosis.setBounds(181, 79, 114, 16);
		panel_8.add(lblPatientDiagnosis);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(181, 108, 660, 192);
		panel_8.add(textArea_5);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave_1.setBounds(462, 376, 97, 25);
		panel_8.add(btnSave_1);
		
		JButton btnExit_6 = new JButton("Exit");
		btnExit_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnExit_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit_6.setBounds(462, 423, 97, 25);
		panel_8.add(btnExit_6);
		
		JPanel panel_9 = new JPanel();
		tabbedPane.addTab("Prescriptions", null, panel_9, null);
		panel_9.setLayout(null);
		
		JLabel lblPrescription = new JLabel("Prescription:");
		lblPrescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrescription.setBounds(222, 81, 78, 16);
		panel_9.add(lblPrescription);
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_16.setBounds(312, 79, 209, 22);
		panel_9.add(textField_16);
		textField_16.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(240, 132, 60, 16);
		panel_9.add(lblQuantity);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_17.setBounds(312, 130, 101, 22);
		panel_9.add(textField_17);
		textField_17.setColumns(10);
		
		JLabel lblRefills = new JLabel("Refills:");
		lblRefills.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRefills.setBounds(260, 183, 40, 16);
		panel_9.add(lblRefills);
		
		textField_18 = new JTextField();
		textField_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_18.setBounds(312, 181, 101, 22);
		panel_9.add(textField_18);
		textField_18.setColumns(10);
		
		JLabel lblListOfMedications = new JLabel("List of Medications:");
		lblListOfMedications.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblListOfMedications.setBounds(176, 281, 124, 16);
		panel_9.add(lblListOfMedications);
		
		JList list_3 = new JList();
		list_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list_3.setBounds(312, 281, 330, 278);
		panel_9.add(list_3);
		
		JButton btnSave_2 = new JButton("Save");
		btnSave_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave_2.setBounds(485, 603, 97, 25);
		panel_9.add(btnSave_2);
		
		JButton btnExit_5 = new JButton("Exit");
		btnExit_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnExit_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit_5.setBounds(485, 641, 97, 25);
		panel_9.add(btnExit_5);
		
	    

	      JButton regInfo = new JButton("Registration");
	      JButton patTrack = new JButton("Patient tracker");
	      JButton phyExam = new JButton("Physical Exam");
	      JButton meds = new JButton("Medication");
	      JButton orders = new JButton("Orders");
	      JButton labRes = new JButton("Lab Results");
	      JButton radRes = new JButton("Radiology Results");
	      JButton asess = new JButton("Asessment");
	      JButton probList = new JButton("Problem List");
	      JButton diag = new JButton("Diagnoses");
	      JButton vital = new JButton("Vital Signs");
	      JButton addRemove = new JButton("Add/Remove Patient");
	      JButton patientInfo = new JButton("Patient Information");
	      JButton physRep = new JButton("Physician Reports");
	      JButton inbox = new JButton("Inbox");
	      JButton complaints = new JButton("Complaints");
	      
	      panel_2.add(regInfo);
	      panel_2.add(patTrack);
	      panel_2.add(phyExam);
	      panel_2.add(meds);
	      panel_2.add(orders);
	      panel_2.add(labRes);
	      panel_2.add(radRes);
	      panel_2.add(asess);
	      panel_2.add(probList);
	      panel_2.add(diag);
	      panel_2.add(vital);
	      panel_2.add(addRemove);
	      panel_2.add(patientInfo);
	      panel_2.add(physRep);
	      panel_2.add(inbox);
	      panel_2.add(complaints);

	      frame.getContentPane().add(panel_2);   

	      JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
	      tabbedPane_1.setBounds(220, 67, 1735, 920);
	      frame.getContentPane().add(tabbedPane_1);
	      
	      // Row tab
	      JButton btnNewButton = new JButton("");
	      tabbedPane_1.addTab("Visit History", null, btnNewButton, null);
	      
	}
}
