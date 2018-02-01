package UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class PatientCharges implements ActionListener {

	private JTabbedPane tabbedPane;
	
	PatientCharges( JTabbedPane tabbedPaneInput ) {
		this.tabbedPane = tabbedPaneInput;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel panel_3;
		JTable table_1;
		JTextField textField_8;
		JTextField textField_9;
		JTextField textField_10;
		JTextField textField_2;
		JTextField textField_11;
		JTextField textField_12;
		JTextField textField_13;
		JTextField textField_14;
		JCheckBox chckbxDebitcreditCard;
		JButton btnNewButton;
		JTextField textField_15;
		JTextField textField_16;
		JButton btnPrint;
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Patient Charges", null, panel_3, null);
		panel_3.setLayout(null);
      
      		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(12, 12, 55, 16);
		panel_3.add(lblType);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(74, 8, 70, 25);
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"All", "None"}));
		panel_3.add(comboBox_4);
      
		JButton btnFind = new JButton("Find");
		btnFind.setBounds(152, 7, 98, 26);
		panel_3.add(btnFind);
		
		table_1 = new JTable();
		table_1.setBounds(12, 70, 921, 16);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"MRN", "PRODUCT NAME", "NUMBER OF PRODUCT PURCHASED", "PRODUCT PRICE", "BILLING STAFF INITIALS"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(202);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(243);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(146);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(185);
		panel_3.add(table_1);
		
		JLabel lblHealthInsuranceInformation = new JLabel("\t\t\t\t\t\t\tHealth Insurance Section");
		lblHealthInsuranceInformation.setFont(new Font("Dialog", Font.BOLD, 30));
		lblHealthInsuranceInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblHealthInsuranceInformation.setBounds(218, 278, 464, 39);
		panel_3.add(lblHealthInsuranceInformation);
		
		JLabel lblStartDate = new JLabel("Start date");
		lblStartDate.setBounds(389, 345, 120, 16);
		panel_3.add(lblStartDate);
		
		JLabel lblExpirationDate = new JLabel("Expiration Date");
		lblExpirationDate.setBounds(521, 345, 120, 16);
		panel_3.add(lblExpirationDate);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(372, 384, 106, 25);
		panel_3.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(515, 384, 106, 25);
		panel_3.add(textField_9);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Cash");
		chckbxNewCheckBox_1.setBounds(210, 450, 112, 24);
		panel_3.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxCheck = new JCheckBox("Check");
		chckbxCheck.setBounds(372, 450, 112, 24);
		panel_3.add(chckbxCheck);
		
		JCheckBox chckbxHealthPlanName = new JCheckBox("Insurance option");
		chckbxHealthPlanName.setBounds(12, 341, 132, 24);
		panel_3.add(chckbxHealthPlanName);
		
		JLabel lblHealthplanName = new JLabel("HealthPlan Name");
		lblHealthplanName.setBounds(202, 345, 120, 16);
		panel_3.add(lblHealthplanName);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(202, 386, 106, 25);
		panel_3.add(textField_10);
		
		JCheckBox chckbxSelfpayOption = new JCheckBox("SelfPay option");
		chckbxSelfpayOption.setBounds(12, 450, 132, 24);
		panel_3.add(chckbxSelfpayOption);
		
		chckbxDebitcreditCard = new JCheckBox("Debit/Credit Card");
		chckbxDebitcreditCard.setBounds(509, 450, 126, 24);
		panel_3.add(chckbxDebitcreditCard);
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setBounds(694, 296, 120, 16);
		panel_3.add(lblTotalAmount);
		
		JLabel lblPaidAmount = new JLabel("Paid Amount");
		lblPaidAmount.setBounds(694, 317, 120, 16);
		panel_3.add(lblPaidAmount);
		
		
		JLabel lblRemaining1 = new JLabel("Remaining1");
		lblRemaining1.setBounds(694, 356, 120, 16);
		panel_3.add(lblRemaining1);
		
		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setBounds(694, 377, 120, 16);
		panel_3.add(lblDiscount);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setBounds(694, 434, 120, 16);
		panel_3.add(lblTax);
				
		JLabel lblRemaining = new JLabel("Remaining2");
		lblRemaining.setBounds(694, 417, 120, 16);
		panel_3.add(lblRemaining);
		
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setBounds(694, 466, 120, 16);
		panel_3.add(lblBalance);
		
		textField_2 = new JTextField(); // Total Amount
		textField_2.setColumns(10);
		textField_2.setBounds(812, 292, 106, 25);
		panel_3.add(textField_2);
		
		textField_11 = new JTextField(); // Paid Amount
		textField_11.setColumns(10);
		textField_11.setBounds(812, 317, 106, 25);
		panel_3.add(textField_11);
		
		textField_12 = new JTextField(); // Remaining1
		textField_12.setColumns(10);
		textField_12.setBounds(812, 352, 106, 25);
		panel_3.add(textField_12);
		
		textField_13 = new JTextField(); // Tax
		textField_13.setColumns(10);
		textField_13.setBounds(812, 430, 106, 25);
		panel_3.add(textField_13);
		
		textField_14 = new JTextField();  // Discount
		textField_14.setColumns(10);
		textField_14.setBounds(812, 377, 106, 25);
		panel_3.add(textField_14);
		

		textField_16 = new JTextField(); // Remaining2
		textField_16.setColumns(10);
		textField_16.setBounds(812, 405, 106, 25);
		panel_3.add(textField_16);
		

		textField_15 = new JTextField(); // Balance 
		textField_15.setColumns(10);
		textField_15.setBounds(812, 462, 106, 25);
		panel_3.add(textField_15);
		
		
		btnNewButton = new JButton("-");
      btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double TotalAmount, PaidAmount, Remaining1;
				try {
					TotalAmount=Double.parseDouble(textField_2.getText());
					PaidAmount=Double.parseDouble(textField_11.getText());
					Remaining1=TotalAmount-PaidAmount;
					textField_12.setText(Double.toString(Remaining1));
				}catch (Exception e){
					JOptionPane.showMessageDialog(null, "Please Enter Valid number");
				}
			}
		});
		btnNewButton.setBounds(930, 310, 46, 16);
		panel_3.add(btnNewButton);
		
		btnNewButton = new JButton("-");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Double Remaining1, Discount, Remaining2;
				try {
					Remaining1=Double.parseDouble(textField_12.getText());
					Discount=Double.parseDouble(textField_14.getText());
					Remaining2=Remaining1-Discount;
					textField_16.setText(Double.toString(Remaining2));
				}catch (Exception e){
					JOptionPane.showMessageDialog(null, "Please Enter Valid number");
				}
			}
		});
		btnNewButton.setBounds(930, 366, 46, 16);
		panel_3.add(btnNewButton);
		
		btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Double Remaining2, Tax, Balance;
				try {
					Remaining2=Double.parseDouble(textField_16.getText());
					Tax=Double.parseDouble(textField_13.getText());
					Balance=Remaining2+Tax;
					textField_15.setText(Double.toString(Balance));
				}catch (Exception e){
					JOptionPane.showMessageDialog(null, "Please Enter Valid number");
				}
			}
		});
		btnNewButton.setBounds(930, 417, 46, 16);
		panel_3.add(btnNewButton);
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				PrinterJob job = PrinterJob.getPrinterJob();
				
				boolean ok = job.printDialog();
				if (ok) {
					try {
						job.print();
					} catch (PrinterException arg) {
					}
				}
			}
		});
		btnPrint.setBounds(878, 7, 98, 26);
		panel_3.add(btnPrint);
	}
	
}