package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Choice;
import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class Registration {

	private JFrame frmRegistration;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
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
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_47;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextField textField_50;
	private JTextField textField_51;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_54;
	private JTextField textField_55;
	private JTextField textField_56;
	private JTextField textField_57;
	private JTextField textField_58;
	private JTextField textField_59;
	private JTextField textField_60;
	private JTextField textField_61;
	private JTextField textField_62;
	private JTextField textField_63;
	private JTextField textField_64;
	private JTextField textField_65;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frmRegistration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistration = new JFrame();
		frmRegistration.setTitle("Registration");
		frmRegistration.setBounds(100, 100, 929, 759);
		frmRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmRegistration.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Patient Registration", null, panel, null);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Last Name:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(58, 39, 76, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("First Name:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(375, 39, 76, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Middle Initial:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(694, 39, 89, 16);
		panel.add(label_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(146, 36, 188, 22);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(463, 36, 188, 22);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(795, 37, 63, 22);
		panel.add(textField_2);
		
		JLabel label_3 = new JLabel("Address:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(77, 84, 57, 16);
		panel.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(146, 81, 712, 22);
		panel.add(textField_3);
		
		JLabel label_4 = new JLabel("City:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(105, 132, 29, 16);
		panel.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(146, 129, 188, 22);
		panel.add(textField_4);
		
		JLabel label_5 = new JLabel("State:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(375, 132, 39, 16);
		panel.add(label_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(426, 129, 70, 22);
		panel.add(comboBox);
		
		JLabel label_6 = new JLabel("Zip:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_6.setBounds(537, 132, 23, 16);
		panel.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(572, 129, 116, 22);
		panel.add(textField_5);
		
		JLabel label_7 = new JLabel("Phone:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(89, 175, 45, 16);
		panel.add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(146, 172, 116, 22);
		panel.add(textField_6);
		
		JLabel label_8 = new JLabel("SSN:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_8.setBounds(321, 175, 31, 16);
		panel.add(label_8);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setColumns(10);
		textField_7.setBounds(364, 172, 132, 22);
		panel.add(textField_7);
		
		JLabel label_9 = new JLabel("DOB:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_9.setBounds(99, 222, 35, 16);
		panel.add(label_9);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_8.setColumns(10);
		textField_8.setBounds(146, 219, 116, 22);
		panel.add(textField_8);
		
		JLabel label_10 = new JLabel("Sex:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_10.setBounds(321, 222, 29, 16);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("Marital Status:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_11.setBounds(463, 222, 93, 16);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("Driver's License:");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_12.setBounds(29, 267, 105, 16);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("Employer Name:");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_13.setBounds(25, 317, 109, 16);
		panel.add(label_13);
		
		JLabel label_14 = new JLabel("Employer Address:");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_14.setBounds(12, 364, 122, 16);
		panel.add(label_14);
		
		JLabel label_15 = new JLabel("Work Phone:");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_15.setBounds(463, 317, 84, 16);
		panel.add(label_15);
		
		JLabel label_16 = new JLabel("Email Address:");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_16.setBounds(38, 412, 96, 16);
		panel.add(label_16);
		
		JLabel label_17 = new JLabel("Cell Phone:");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_17.setBounds(485, 412, 71, 16);
		panel.add(label_17);
		
		JLabel label_18 = new JLabel("Emergency Contact Name:");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_18.setBounds(38, 461, 178, 16);
		panel.add(label_18);
		
		JLabel label_19 = new JLabel("Emergency Contact Phone:");
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_19.setBounds(485, 461, 178, 16);
		panel.add(label_19);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_9.setColumns(10);
		textField_9.setBounds(364, 220, 39, 22);
		panel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_10.setColumns(10);
		textField_10.setBounds(146, 264, 188, 22);
		panel.add(textField_10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Single", "Married", "Divorced", "Widowed"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setBounds(575, 220, 116, 22);
		panel.add(comboBox_1);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_11.setColumns(10);
		textField_11.setBounds(146, 315, 257, 22);
		panel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_12.setColumns(10);
		textField_12.setBounds(146, 362, 712, 22);
		panel.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_13.setColumns(10);
		textField_13.setBounds(575, 315, 116, 22);
		panel.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_14.setColumns(10);
		textField_14.setBounds(146, 410, 257, 22);
		panel.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_15.setColumns(10);
		textField_15.setBounds(575, 410, 116, 22);
		panel.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_16.setColumns(10);
		textField_16.setBounds(228, 459, 223, 22);
		panel.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_17.setColumns(10);
		textField_17.setBounds(675, 459, 116, 22);
		panel.add(textField_17);
		
		JButton button = new JButton("Save");
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(386, 548, 97, 25);
		panel.add(button);
		
		JButton button_1 = new JButton("Exit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmRegistration = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frmRegistration, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(386, 594, 97, 25);
		panel.add(button_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Search Patient", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblSearchPatientMrnssn = new JLabel("Search Patient MRN/SSN:");
		lblSearchPatientMrnssn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchPatientMrnssn.setBounds(107, 39, 175, 22);
		panel_1.add(lblSearchPatientMrnssn);
		
		textField_18 = new JTextField();
		textField_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_18.setColumns(10);
		textField_18.setBounds(282, 39, 152, 22);
		panel_1.add(textField_18);
		
		JLabel label_21 = new JLabel("Select Patient:");
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_21.setBounds(113, 145, 92, 16);
		panel_1.add(label_21);
		
		JList list = new JList();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list.setBounds(113, 174, 698, 339);
		panel_1.add(list);
		
		JButton button_2 = new JButton("Check-In Patient");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2.setBounds(374, 538, 170, 25);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("Check-Out Patient");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_3.setBounds(374, 576, 170, 25);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("Exit");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmRegistration = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frmRegistration, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_4.setBounds(714, 538, 97, 25);
		panel_1.add(button_4);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSearch.setBounds(444, 38, 89, 23);
		panel_1.add(btnSearch);
		
		JLabel lblSearchPatientBy = new JLabel("Search By Surname:");
		lblSearchPatientBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchPatientBy.setBounds(107, 88, 175, 22);
		panel_1.add(lblSearchPatientBy);
		
		textField_51 = new JTextField();
		textField_51.setBounds(282, 91, 152, 22);
		panel_1.add(textField_51);
		textField_51.setColumns(10);
		
		JButton btnSearch2 = new JButton("Search");
		btnSearch2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSearch2.setBounds(444, 90, 89, 23);
		panel_1.add(btnSearch2);
		
		JButton btnAddeditRecords = new JButton("Add/Edit Records");
		btnAddeditRecords.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAddeditRecords.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddeditRecords.setBounds(116, 538, 166, 64);
		panel_1.add(btnAddeditRecords);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Appointment", null, panel_4, "Choose Appointment Date");
		panel_4.setLayout(null);
		
		JLabel lblAppointmentTime = new JLabel("Appointment Time:");
		lblAppointmentTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAppointmentTime.setBounds(109, 29, 125, 16);
		panel_4.add(lblAppointmentTime);
		
		JLabel lblAppointments = new JLabel("Appointments:");
		lblAppointments.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAppointments.setBounds(109, 267, 109, 16);
		panel_4.add(lblAppointments);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setBounds(390, 561, 97, 25);
		panel_4.add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmRegistration = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frmRegistration, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBounds(390, 599, 97, 25);
		panel_4.add(btnExit);
		
		JScrollPane scrSpecialApp = new JScrollPane();
		scrSpecialApp.setBounds(109, 291, 669, 250);
		panel_4.add(scrSpecialApp);
		
		JTextArea taSpecialApp = new JTextArea();
		scrSpecialApp.setViewportView(taSpecialApp);
		
		JLabel lblAppointmentType = new JLabel("Appointment Type:");
		lblAppointmentType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAppointmentType.setBounds(109, 231, 136, 25);
		panel_4.add(lblAppointmentType);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1529996400000L), new Date(1529996400000L), new Date(1546243200000L), Calendar.DAY_OF_YEAR));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spinner.setBounds(242, 27, 148, 20);
		panel_4.add(spinner);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Family/Internal Medicine - Office Visit", "Family/Internal Medicine - Wellness Exam", "For Same- Day Visits - Family/Internal Medicine, Pediatrics", "Gastroenterology - Colonoscopy", "Lab Appointment", "OB/GYN - Office Visit", "OB/GYN - Routine Pregnancy Visit", "OB/GYN - Wellness Exam", "Optometry - Routine Eye Exam", "Pediatrics - Adolescent Physical", "Pediatrics - Child Physical", "Pedicatrics - Office Visit", "Request an Appointment", "Video Visit"}));
		comboBox_3.setBounds(242, 225, 348, 31);
		panel_4.add(comboBox_3);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(242, 58, 198, 153);
		panel_4.add(calendar);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Insurance Holder", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_22 = new JLabel("Responsible Party Information");
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_22.setBounds(12, 13, 246, 16);
		panel_2.add(label_22);
		
		JLabel label_23 = new JLabel("Relationship of Responsible Party to Patient:");
		label_23.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_23.setBounds(66, 57, 284, 16);
		panel_2.add(label_23);
		
		JCheckBox checkBox = new JCheckBox("Self");
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkBox.setBounds(358, 53, 70, 25);
		panel_2.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Spouse");
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkBox_1.setBounds(426, 53, 83, 25);
		panel_2.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("Parent");
		checkBox_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkBox_2.setBounds(513, 53, 83, 25);
		panel_2.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("Other");
		checkBox_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkBox_3.setBounds(600, 53, 75, 25);
		panel_2.add(checkBox_3);
		
		textField_19 = new JTextField();
		textField_19.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_19.setColumns(10);
		textField_19.setBounds(683, 54, 116, 22);
		panel_2.add(textField_19);
		
		JLabel label_24 = new JLabel("Last Name:");
		label_24.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_24.setBounds(58, 104, 76, 16);
		panel_2.add(label_24);
		
		textField_20 = new JTextField();
		textField_20.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_20.setColumns(10);
		textField_20.setBounds(146, 102, 188, 22);
		panel_2.add(textField_20);
		
		JLabel label_25 = new JLabel("First Name:");
		label_25.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_25.setBounds(375, 104, 76, 16);
		panel_2.add(label_25);
		
		textField_21 = new JTextField();
		textField_21.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_21.setColumns(10);
		textField_21.setBounds(463, 101, 188, 22);
		panel_2.add(textField_21);
		
		JLabel label_26 = new JLabel("Address:");
		label_26.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_26.setBounds(77, 150, 57, 16);
		panel_2.add(label_26);
		
		textField_22 = new JTextField();
		textField_22.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_22.setColumns(10);
		textField_22.setBounds(146, 147, 712, 22);
		panel_2.add(textField_22);
		
		JLabel label_27 = new JLabel("Middle Initial:");
		label_27.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_27.setBounds(694, 104, 89, 16);
		panel_2.add(label_27);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(795, 102, 63, 22);
		panel_2.add(textField_23);
		
		JLabel label_28 = new JLabel("City:");
		label_28.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_28.setBounds(105, 198, 29, 16);
		panel_2.add(label_28);
		
		textField_24 = new JTextField();
		textField_24.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_24.setColumns(10);
		textField_24.setBounds(146, 195, 188, 22);
		panel_2.add(textField_24);
		
		JLabel label_29 = new JLabel("State:");
		label_29.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_29.setBounds(375, 198, 39, 16);
		panel_2.add(label_29);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"}));
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_2.setBounds(426, 195, 70, 22);
		panel_2.add(comboBox_2);
		
		JLabel label_30 = new JLabel("Zip:");
		label_30.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_30.setBounds(540, 198, 23, 16);
		panel_2.add(label_30);
		
		textField_25 = new JTextField();
		textField_25.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_25.setColumns(10);
		textField_25.setBounds(575, 195, 116, 22);
		panel_2.add(textField_25);
		
		JLabel label_31 = new JLabel("Phone:");
		label_31.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_31.setBounds(89, 247, 45, 16);
		panel_2.add(label_31);
		
		textField_26 = new JTextField();
		textField_26.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_26.setColumns(10);
		textField_26.setBounds(146, 244, 116, 22);
		panel_2.add(textField_26);
		
		JLabel label_32 = new JLabel("SSN:");
		label_32.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_32.setBounds(321, 247, 31, 16);
		panel_2.add(label_32);
		
		textField_27 = new JTextField();
		textField_27.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_27.setColumns(10);
		textField_27.setBounds(364, 244, 132, 22);
		panel_2.add(textField_27);
		
		JLabel label_33 = new JLabel("DOB:");
		label_33.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_33.setBounds(528, 247, 35, 16);
		panel_2.add(label_33);
		
		textField_28 = new JTextField();
		textField_28.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_28.setColumns(10);
		textField_28.setBounds(575, 244, 116, 22);
		panel_2.add(textField_28);
		
		JLabel label_34 = new JLabel("Sex:");
		label_34.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_34.setBounds(719, 247, 29, 16);
		panel_2.add(label_34);
		
		textField_29 = new JTextField();
		textField_29.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_29.setColumns(10);
		textField_29.setBounds(760, 244, 39, 22);
		panel_2.add(textField_29);
		
		JLabel label_35 = new JLabel("Employer Name:");
		label_35.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_35.setBounds(25, 296, 109, 16);
		panel_2.add(label_35);
		
		textField_30 = new JTextField();
		textField_30.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_30.setColumns(10);
		textField_30.setBounds(146, 293, 257, 22);
		panel_2.add(textField_30);
		
		JLabel label_36 = new JLabel("Work Phone:");
		label_36.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_36.setBounds(444, 296, 84, 16);
		panel_2.add(label_36);
		
		textField_31 = new JTextField();
		textField_31.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_31.setColumns(10);
		textField_31.setBounds(540, 293, 116, 22);
		panel_2.add(textField_31);
		
		JLabel label_37 = new JLabel("Employer Address:");
		label_37.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_37.setBounds(12, 338, 122, 16);
		panel_2.add(label_37);
		
		textField_32 = new JTextField();
		textField_32.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_32.setColumns(10);
		textField_32.setBounds(146, 335, 712, 22);
		panel_2.add(textField_32);
		
		JButton button_5 = new JButton("Save");
		button_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_5.setBounds(375, 463, 97, 25);
		panel_2.add(button_5);
		
		JButton button_6 = new JButton("Exit");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmRegistration = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frmRegistration, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		button_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_6.setBounds(375, 501, 97, 25);
		panel_2.add(button_6);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Insurance Information", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel label_38 = new JLabel("Primary Insurance");
		label_38.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_38.setBounds(47, 13, 154, 16);
		panel_3.add(label_38);
		
		JLabel label_39 = new JLabel("Plan Name:");
		label_39.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_39.setBounds(99, 57, 75, 16);
		panel_3.add(label_39);
		
		textField_33 = new JTextField();
		textField_33.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_33.setColumns(10);
		textField_33.setBounds(186, 54, 188, 22);
		panel_3.add(textField_33);
		
		JLabel label_40 = new JLabel("Insured's Name:");
		label_40.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_40.setBounds(444, 57, 109, 16);
		panel_3.add(label_40);
		
		textField_34 = new JTextField();
		textField_34.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_34.setColumns(10);
		textField_34.setBounds(565, 54, 198, 22);
		panel_3.add(textField_34);
		
		JLabel label_41 = new JLabel("Insured's Social Security:");
		label_41.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_41.setBounds(13, 97, 161, 16);
		panel_3.add(label_41);
		
		textField_35 = new JTextField();
		textField_35.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_35.setColumns(10);
		textField_35.setBounds(186, 94, 188, 22);
		panel_3.add(textField_35);
		
		JLabel label_42 = new JLabel("Insured's Date of Birth:");
		label_42.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_42.setBounds(400, 97, 153, 16);
		panel_3.add(label_42);
		
		textField_36 = new JTextField();
		textField_36.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_36.setColumns(10);
		textField_36.setBounds(565, 94, 116, 22);
		panel_3.add(textField_36);
		
		JLabel label_43 = new JLabel("Policy/ID #:");
		label_43.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_43.setBounds(96, 140, 78, 16);
		panel_3.add(label_43);
		
		textField_37 = new JTextField();
		textField_37.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_37.setColumns(10);
		textField_37.setBounds(186, 137, 188, 22);
		panel_3.add(textField_37);
		
		JLabel label_44 = new JLabel("Group #:");
		label_44.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_44.setBounds(433, 140, 60, 16);
		panel_3.add(label_44);
		
		textField_38 = new JTextField();
		textField_38.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_38.setColumns(10);
		textField_38.setBounds(505, 137, 116, 22);
		panel_3.add(textField_38);
		
		JLabel label_45 = new JLabel("Eff Date:");
		label_45.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_45.setBounds(662, 143, 59, 16);
		panel_3.add(label_45);
		
		JLabel label_46 = new JLabel("Claims Address:");
		label_46.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_46.setBounds(71, 180, 103, 16);
		panel_3.add(label_46);
		
		textField_39 = new JTextField();
		textField_39.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_39.setColumns(10);
		textField_39.setBounds(186, 177, 712, 22);
		panel_3.add(textField_39);
		
		JLabel label_47 = new JLabel("Claims Phone:");
		label_47.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_47.setBounds(83, 216, 91, 16);
		panel_3.add(label_47);
		
		textField_40 = new JTextField();
		textField_40.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_40.setColumns(10);
		textField_40.setBounds(186, 213, 116, 22);
		panel_3.add(textField_40);
		
		textField_41 = new JTextField();
		textField_41.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_41.setColumns(10);
		textField_41.setBounds(733, 137, 91, 22);
		panel_3.add(textField_41);
		
		JLabel label_48 = new JLabel("Secondary Insurance");
		label_48.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_48.setBounds(13, 269, 188, 16);
		panel_3.add(label_48);
		
		JLabel label_49 = new JLabel("Plan Name:");
		label_49.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_49.setBounds(99, 310, 75, 16);
		panel_3.add(label_49);
		
		textField_42 = new JTextField();
		textField_42.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_42.setColumns(10);
		textField_42.setBounds(186, 307, 188, 22);
		panel_3.add(textField_42);
		
		JLabel label_50 = new JLabel("Insured's Name:");
		label_50.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_50.setBounds(444, 310, 109, 16);
		panel_3.add(label_50);
		
		textField_43 = new JTextField();
		textField_43.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_43.setColumns(10);
		textField_43.setBounds(565, 307, 198, 22);
		panel_3.add(textField_43);
		
		JLabel label_51 = new JLabel("Insured's Social Security:");
		label_51.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_51.setBounds(13, 353, 161, 16);
		panel_3.add(label_51);
		
		textField_44 = new JTextField();
		textField_44.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_44.setColumns(10);
		textField_44.setBounds(186, 350, 188, 22);
		panel_3.add(textField_44);
		
		JLabel label_52 = new JLabel("Insured's Date of Birth:");
		label_52.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_52.setBounds(400, 353, 153, 16);
		panel_3.add(label_52);
		
		textField_45 = new JTextField();
		textField_45.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_45.setColumns(10);
		textField_45.setBounds(565, 350, 116, 22);
		panel_3.add(textField_45);
		
		JLabel label_53 = new JLabel("Policy/ID #:");
		label_53.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_53.setBounds(96, 396, 78, 16);
		panel_3.add(label_53);
		
		textField_46 = new JTextField();
		textField_46.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_46.setColumns(10);
		textField_46.setBounds(186, 393, 188, 22);
		panel_3.add(textField_46);
		
		JLabel label_54 = new JLabel("Group #:");
		label_54.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_54.setBounds(433, 396, 60, 16);
		panel_3.add(label_54);
		
		textField_47 = new JTextField();
		textField_47.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_47.setColumns(10);
		textField_47.setBounds(505, 393, 116, 22);
		panel_3.add(textField_47);
		
		JLabel label_55 = new JLabel("Eff Date:");
		label_55.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_55.setBounds(662, 396, 59, 16);
		panel_3.add(label_55);
		
		JLabel label_56 = new JLabel("Claims Address:");
		label_56.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_56.setBounds(71, 436, 103, 16);
		panel_3.add(label_56);
		
		textField_48 = new JTextField();
		textField_48.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_48.setColumns(10);
		textField_48.setBounds(186, 433, 712, 22);
		panel_3.add(textField_48);
		
		JLabel label_57 = new JLabel("Claims Phone:");
		label_57.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_57.setBounds(83, 472, 91, 16);
		panel_3.add(label_57);
		
		textField_49 = new JTextField();
		textField_49.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_49.setColumns(10);
		textField_49.setBounds(186, 469, 116, 22);
		panel_3.add(textField_49);
		
		textField_50 = new JTextField();
		textField_50.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_50.setColumns(10);
		textField_50.setBounds(733, 393, 91, 22);
		panel_3.add(textField_50);
		
		JButton button_7 = new JButton("Save");
		button_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_7.setBounds(377, 551, 97, 25);
		panel_3.add(button_7);
		
		JButton button_8 = new JButton("Exit");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmRegistration = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frmRegistration, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		button_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_8.setBounds(377, 589, 97, 25);
		panel_3.add(button_8);
		
		JPanel panel_5 = new JPanel();
		panel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_5.setBorder(new LineBorder(SystemColor.activeCaption));
		tabbedPane.addTab("Billing", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(SystemColor.desktop));
		panel_6.setBackground(UIManager.getColor("Button.background"));
		panel_6.setLayout(null);
		
		JLabel lblInsuranceCompany = new JLabel("Insurance ");
		lblInsuranceCompany.setBounds(10, 24, 108, 14);
		panel_6.add(lblInsuranceCompany);
		
		JLabel lblInsuredName = new JLabel("Insured Name");
		lblInsuredName.setBounds(10, 69, 91, 14);
		panel_6.add(lblInsuredName);
		
		textField_52 = new JTextField();
		textField_52.setBounds(122, 21, 162, 20);
		panel_6.add(textField_52);
		textField_52.setColumns(10);
		
		textField_53 = new JTextField();
		textField_53.setBounds(122, 66, 162, 20);
		panel_6.add(textField_53);
		textField_53.setColumns(10);
		
		JLabel lblInsuredDob = new JLabel("Insured DOB");
		lblInsuredDob.setBounds(10, 124, 91, 14);
		panel_6.add(lblInsuredDob);
		
		textField_54 = new JTextField();
		textField_54.setColumns(10);
		textField_54.setBounds(122, 121, 162, 20);
		panel_6.add(textField_54);
		
		JLabel lblRelation = new JLabel("Relation");
		lblRelation.setBounds(10, 172, 46, 14);
		panel_6.add(lblRelation);
		
		textField_55 = new JTextField();
		textField_55.setColumns(10);
		textField_55.setBounds(122, 169, 162, 20);
		panel_6.add(textField_55);
		
		JLabel lblEffectiveDate = new JLabel("Effective Date");
		lblEffectiveDate.setBounds(10, 222, 108, 14);
		panel_6.add(lblEffectiveDate);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(122, 216, 162, 20);
		panel_6.add(dateChooser_1);
		
		JLabel lblExpirationDate = new JLabel("Expiration Date");
		lblExpirationDate.setBounds(10, 270, 108, 14);
		panel_6.add(lblExpirationDate);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(122, 264, 162, 20);
		panel_6.add(dateChooser_2);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new LineBorder(SystemColor.desktop));
		panel_7.setBackground(UIManager.getColor("Button.background"));
		
		JLabel lblMrn = new JLabel("MRN");
		lblMrn.setBounds(10, 24, 125, 14);
		panel_7.add(lblMrn);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 69, 91, 14);
		panel_7.add(lblLastName);
		
		textField_56 = new JTextField();
		textField_56.setColumns(10);
		textField_56.setBounds(122, 21, 100, 20);
		panel_7.add(textField_56);
		
		textField_57 = new JTextField();
		textField_57.setColumns(10);
		textField_57.setBounds(122, 66, 100, 20);
		panel_7.add(textField_57);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 124, 91, 14);
		panel_7.add(lblAddress);
		
		textField_58 = new JTextField();
		textField_58.setColumns(10);
		textField_58.setBounds(122, 121, 274, 20);
		panel_7.add(textField_58);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(10, 172, 46, 14);
		panel_7.add(lblCity);
		
		textField_59 = new JTextField();
		textField_59.setColumns(10);
		textField_59.setBounds(122, 169, 125, 20);
		panel_7.add(textField_59);
		
		JLabel lblZip = new JLabel("Zip");
		lblZip.setBounds(10, 214, 26, 14);
		panel_7.add(lblZip);
		
		JLabel label_62 = new JLabel("Expiration Date");
		label_62.setBounds(10, 270, 75, 14);
		panel_7.add(label_62);
		
		JDateChooser dateChooser_4 = new JDateChooser();
		dateChooser_4.setBounds(122, 264, 162, 20);
		panel_7.add(dateChooser_4);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(232, 69, 91, 14);
		panel_7.add(lblFirstName);
		
		textField_60 = new JTextField();
		textField_60.setColumns(10);
		textField_60.setBounds(296, 66, 100, 20);
		panel_7.add(textField_60);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(258, 172, 36, 14);
		panel_7.add(lblPhone);
		
		textField_61 = new JTextField();
		textField_61.setColumns(10);
		textField_61.setBounds(296, 169, 100, 20);
		panel_7.add(textField_61);
		
		textField_62 = new JTextField();
		textField_62.setColumns(10);
		textField_62.setBounds(122, 211, 52, 20);
		panel_7.add(textField_62);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI\t", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"}));
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_4.setBounds(246, 209, 52, 20);
		panel_7.add(comboBox_4);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(194, 214, 52, 14);
		panel_7.add(lblState);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(417, 96, 46, 14);
		panel_7.add(lblSex);
		
		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setBounds(417, 127, 46, 14);
		panel_7.add(lblSsn);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(417, 69, 46, 14);
		panel_7.add(lblDob);
		
		textField_63 = new JTextField();
		textField_63.setColumns(10);
		textField_63.setBounds(451, 63, 91, 20);
		panel_7.add(textField_63);
		
		textField_64 = new JTextField();
		textField_64.setColumns(10);
		textField_64.setBounds(451, 93, 91, 20);
		panel_7.add(textField_64);
		
		textField_65 = new JTextField();
		textField_65.setColumns(10);
		textField_65.setBounds(451, 121, 91, 20);
		panel_7.add(textField_65);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(UIManager.getColor("Button.focus")));
		
		JButton btnReset = new JButton("Reset");
		
		JButton btnSearchPatient = new JButton("Search Patient");
		
		JButton btnPrintClaim = new JButton("Print Claim");
		
		JButton btnUpdate = new JButton("Update");
		
		JButton btnDelete = new JButton("Delete");
		
		JLabel lblPatientDemographics = new JLabel("Patient Demographics");
		lblPatientDemographics.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblListOfVisits = new JLabel("List of Visits");
		lblListOfVisits.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblPrimarysecondaryInsurance = new JLabel("Primary/Secondary Insurance");
		lblPrimarysecondaryInsurance.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap(9, Short.MAX_VALUE)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addComponent(btnDelete)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnUpdate)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPrintClaim)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSearchPatient)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReset)
							.addGap(32))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
									.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel_5.createSequentialGroup()
										.addComponent(lblListOfVisits)
										.addGap(484)))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPatientDemographics))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPrimarysecondaryInsurance)
								.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPatientDemographics)
						.addComponent(lblPrimarysecondaryInsurance))
					.addGap(8)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel_5.createSequentialGroup()
							.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(lblListOfVisits)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
					.addGap(206)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearchPatient)
						.addComponent(btnPrintClaim)
						.addComponent(btnUpdate)
						.addComponent(btnDelete)
						.addComponent(btnReset))
					.addContainerGap())
		);
		
		JButton btnProcessInsurance = new JButton("Process Insurance");
		btnProcessInsurance.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnProcessInsurance.setBounds(10, 394, 123, 23);
		panel_6.add(btnProcessInsurance);
		
		JButton btnReset_1 = new JButton("Reset");
		btnReset_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnReset_1.setBounds(227, 394, 89, 23);
		panel_6.add(btnReset_1);
		
		table = new JTable();
		table.setBackground(UIManager.getColor("Button.background"));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Visit No.", "Visit Date/Time", "Clinic", "Provider", "Appointment Date/Time", "Type"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(0).setMinWidth(42);
		table.getColumnModel().getColumn(1).setPreferredWidth(88);
		table.getColumnModel().getColumn(4).setPreferredWidth(125);
		scrollPane.setViewportView(table);
		panel_5.setLayout(gl_panel_5);
	}
}