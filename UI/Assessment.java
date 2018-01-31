package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;

public class Assessment implements ActionListener {
	private JTabbedPane tabbedPane;

	public Assessment( JTabbedPane tabbedPaneIn ) {
		this.tabbedPane = tabbedPaneIn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrNotes frame = new DrNotes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

class DrNotes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public DrNotes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1050, 900);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBounds(47, 166, 403, 288);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("DOB:");
		lblNewLabel_2.setBounds(19, 76, 61, 16);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("MRN:");
		lblNewLabel_3.setBounds(19, 122, 61, 16);
		panel.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(149, 26, 197, 26);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(149, 71, 130, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(149, 117, 130, 26);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Appointment Date:");
		lblNewLabel_4.setBounds(19, 168, 124, 16);
		panel.add(lblNewLabel_4);

		textField_3 = new JTextField();
		textField_3.setBounds(149, 163, 130, 26);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Appointment Type:");
		lblNewLabel_5.setBounds(19, 223, 124, 16);
		panel.add(lblNewLabel_5);

		textField_4 = new JTextField();
		textField_4.setBounds(149, 218, 130, 26);
		panel.add(textField_4);
		textField_4.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_2.setBounds(47, 514, 403, 288);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PrinterJob job = PrinterJob.getPrinterJob();
				boolean ok = job.printDialog();
				if (ok) {
					try {
						job.print();
					} catch (PrinterException ex) {
			
					}
				}
			}
		});
		btnPrint.setBounds(6, 253, 117, 29);
		panel_2.add(btnPrint);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(16, 29, 379, 210);
		panel_2.add(textArea);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(278, 253, 117, 29);
		panel_2.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Physician Notes");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lblNewLabel.setBounds(57, 459, 296, 43);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("Patient Information");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		label.setBounds(58, 124, 306, 30);
		contentPane.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_1.setBounds(574, 166, 403, 288);
		contentPane.add(panel_1);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Name");
		comboBox.addItem("Asthma");
		comboBox.addItem("Peanut allergy");
		comboBox.addItem("Eczema");
		comboBox.addItem("Rash");
		comboBox.addItem("Sneezing");
		comboBox.addItem("Cough");
		comboBox.setSelectedItem(null);
		comboBox.setBounds(102, 25, 280, 27);
		panel_1.add(comboBox);

		JLabel lblNewLabel_6 = new JLabel("Diagnosis:");
		lblNewLabel_6.setBounds(31, 29, 129, 16);
		panel_1.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Treatment:");
		lblNewLabel_7.setBounds(31, 137, 85, 16);
		panel_1.add(lblNewLabel_7);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(102, 133, 280, 27);
		panel_1.add(comboBox_1);

		JLabel lblConditionsDiagnosis = new JLabel("Conditions & Diagnosis");
		lblConditionsDiagnosis.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lblConditionsDiagnosis.setBounds(581, 120, 396, 38);
		contentPane.add(lblConditionsDiagnosis);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_3.setBounds(574, 514, 403, 288);
		contentPane.add(panel_3);

		JButton button = new JButton("Print");
		button.setBounds(6, 253, 117, 29);
		panel_3.add(button);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(16, 29, 379, 210);
		panel_3.add(textArea_1);

		JLabel lblDiagnosisSummary = new JLabel("Diagnosis Summary");
		lblDiagnosisSummary.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lblDiagnosisSummary.setBounds(584, 459, 329, 43);
		contentPane.add(lblDiagnosisSummary);
	}
}