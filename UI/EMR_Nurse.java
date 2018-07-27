package UI;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.GridLayout;

import javax.swing.GroupLayout.Alignment;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import base.DBBase;
import base.DBConnect;

public class EMR_Nurse extends JFrame {
	
	JFrame frmNurse;
	private JPanel contentPane;
	private JTextField firstname;
	private JTextField textSubstance;
	private JTextField textCategory;
	private JTextField textReactions;
	private JTextField textRStatus;
	private JTextField textUpdated;
	private JTextField textReviewed;
	private JTextField textOnset;
	private JTextField textComment;
	private JTextField textPulse;
	private JTextField textRythm;
	private JTextField textBP1;
	private JTextField textBP2;
	private JTextField textRespiratory;
	private JTextField textTemp;
	private JTextField textTempLocation;
	private JTextField textHeight;
	private JTextField textWeight;
	private JTable table;

	private DBConnect con;
	private DBBase data;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EMR_Nurse frame = new EMR_Nurse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EMR_Nurse() {
		setTitle("Nurse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1043, 769);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		con = new DBConnect();
		data = new DBBase();
		con.initialise("root", "password");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JLabel lblElectronicMedicalRecord = new JLabel("ELECTRONIC MEDICAL RECORD");
		lblElectronicMedicalRecord.setFont(new Font("Times New Roman", Font.BOLD, 35));
		
		JLabel lblLastName = new JLabel("Patient ID:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		final JLabel lblPID = new JLabel("");
		lblPID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblElectronicMedicalRecord)
							.addGap(218)
							.addComponent(lblLastName)
							.addGap(22)
							.addComponent(lblPID)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblElectronicMedicalRecord)
						.addComponent(lblLastName)
						.addComponent(lblPID))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 671, Short.MAX_VALUE)
					.addGap(3))
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Home", null, panel, null);
		
		JLabel lblSearchPatient = new JLabel("Search Patient:");
		lblSearchPatient.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblSelectPatient = new JLabel("Select Patient:");
		lblSelectPatient.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int selectedRowIndex = table.getSelectedRow();
			
			lblPID.setText(model.getValueAt(selectedRowIndex, 0).toString());
			}
		});
		btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		firstname = new JTextField();
		firstname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		firstname.setColumns(10);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmNurse = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frmNurse, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnSearch = new JButton("Load Patients");
		btnSearch.addActionListener(new ActionListener() {
	
		public void actionPerformed(ActionEvent arg0) {
			//ResultSet rs = data.query(con.getConnection(), "patient", Collections.emptyMap());
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://35.226.84.132:3306/EMR?user=root&password=password\";\r\n" + 
							"    			connection", "root", "password");
					Statement stmt = con.createStatement();
					String sql = "Select patient_id, first_name, last_name, DOB from PATIENT";
					ResultSet rs = stmt.executeQuery(sql);
					table.setModel (DbUtils.resultSetToTableModel(rs));
					//table = new JTable(data.fitToTable(rs));
					//JScrollPane scrollPane = new JScrollPane(table);
					//scrollPane.setBounds(52, 135, 678, 270);
					//panel.add(scrollPane);
					
				} 
				catch(Exception e) {System.out.print(e);}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			//@Override
			//public void actionPerformed(ActionEvent arg0) {
				//String searchText = firstname.getText();

				//if( !searchText.equals("") )
				//{
					//Map<String, Object> map = new HashMap<String, Object>();
					//map.put("username", searchText);

					//ResultSet rs = data.query(con.getConnection(), "user", map);
					//try
					//{
						//table = new JTable(data.fitToTable(rs));
						//JScrollPane scrollPane = new JScrollPane(table);
						//scrollPane.setBounds(52, 135, 678, 270);
						//panel.add(scrollPane);
					//} catch (SQLException e1) {
						//e1.printStackTrace();
					//}
				//}
			//}
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://35.226.84.132:3306/EMR?user=root&password=password\";\r\n" + 
							"    			connection", "root", "password");
					String sql = "Select patient_id, first_name, last_name, DOB from PATIENT WHERE first_name ='" +firstname.getText()+ "'";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					table.setModel (DbUtils.resultSetToTableModel(rs));
					
				} 
				catch(Exception e) {System.out.print(e);}
			}
		});
		btnSearch_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstname.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(69)
					.addComponent(btnSelect, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(268)
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(69))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(319)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSearchPatient, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
								.addComponent(firstname, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblSelectPatient, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addComponent(btnSearch_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(234))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSearch_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblSearchPatient)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(firstname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(70)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectPatient)
						.addComponent(btnSearch))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSelect, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExit)
						.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(51))
		);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Allergy", null, panel_1, null);
		
		JLabel lblSubstance = new JLabel("Substance:");
		lblSubstance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblSeverity = new JLabel("Severity:");
		lblSeverity.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblReactions = new JLabel("Reactions:");
		lblReactions.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblReactionStatus = new JLabel("Reaction Status:");
		lblReactionStatus.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblInteraction = new JLabel("Interaction:");
		lblInteraction.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblSource = new JLabel("Source:");
		lblSource.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblUpdatedTime = new JLabel("Updated Time:");
		lblUpdatedTime.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblReviewedBy = new JLabel("Reviewed By:");
		lblReviewedBy.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblEstimatedOnset = new JLabel("Estimated Onset:");
		lblEstimatedOnset.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblComment = new JLabel("Comment:");
		lblComment.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textSubstance = new JTextField();
		textSubstance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textSubstance.setColumns(10);
		
		textCategory = new JTextField();
		textCategory.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textCategory.setColumns(10);
		
		textReactions = new JTextField();
		textReactions.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textReactions.setColumns(10);
		
		textRStatus = new JTextField();
		textRStatus.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textRStatus.setColumns(10);
		
		textUpdated = new JTextField();
		textUpdated.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textUpdated.setColumns(10);
		
		textReviewed = new JTextField();
		textReviewed.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textReviewed.setColumns(10);
		
		textOnset = new JTextField();
		textOnset.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textOnset.setColumns(10);
		
		textComment = new JTextField();
		textComment.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textComment.setColumns(10);
		
		final JComboBox comboType = new JComboBox();
		comboType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> comboType = (JComboBox<String>) e.getSource();
		        String selectedItem = (String) comboType.getSelectedItem();
			}
		});
		
		comboType.setModel(new DefaultComboBoxModel(new String[] {"FOOD", "Balsam of Peru", "Egg", "Fish or shellfish", "Fruit", "Gluten", "Garlic", "Hot peppers", "Oats", "Meat", "Milk", "Peanut", "Rice", "Sesame", "Soy", "Sulfites", "Tartrazine", "Tree nut", "Wheat", "", "DRUG", "Balsam of Peru", "Cephalosporins", "Dilantin", "Intravenous contrast dye", "Local anesthetics", "Non-Seroidal anti-inflammatories", "(Cromolyn sodium, nedocrmil sodium, etc.)", "Penicillin", "Sulfonamides", "Tegretol", "Tetracycline", "", "ENVIRONMENTAL", "Balsam of Peru", "Cat", "Chromium", "Cobalt Chloride", "Cosmetics", "Dog ", "Formaldehyde", "Fungicide", "Gold (gold sodium thiosulfate)", "House dust mite", "Insect Sting", "Latex", "Mold", "Nickel(nickel sulfate hexahydrate)", "Perfume", "Photographic developers", "Pollen", "Semen", "Water"}));
		comboType.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		final JComboBox comboSeverity = new JComboBox();
		comboSeverity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> comboSeverity = (JComboBox<String>) e.getSource();
		        String selectedSeverity = (String) comboSeverity.getSelectedItem();
			}
		});
		comboSeverity.setModel(new DefaultComboBoxModel(new String[] {"Low", "Medium", "High", "Critical"}));
		comboSeverity.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		final JComboBox comboInteraction = new JComboBox();
		comboInteraction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> comboInteraction = (JComboBox<String>) e.getSource();
		        String selectedInteraction = (String) comboInteraction.getSelectedItem();
			}
		});
		comboInteraction.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		comboInteraction.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		final JComboBox comboSource = new JComboBox();
		comboSource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> comboSource = (JComboBox<String>) e.getSource();
		        String selectedSource = (String) comboSource.getSelectedItem();
			}
		});
		comboSource.setModel(new DefaultComboBoxModel(new String[] {"Drug", "Food ", "Rhinitis", "Seasonal", "Skin", "Pet"}));
		comboSource.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://35.226.84.132:3306/EMR?user=root&password=password\";\r\n" + 
							"    			connection", "root", "password");
					 String sub=textSubstance.getText();
					 String selectedType = (String) comboType.getSelectedItem();
					 String cat=textCategory.getText();
					 String selectedSeverity = (String) comboSeverity.getSelectedItem();
					 String react=textReactions.getText();
					 String rStatus=textRStatus.getText();
					 String selectedInteraction = (String) comboInteraction.getSelectedItem();
					 String selectedSource = (String) comboSource.getSelectedItem();
					 String updated=textUpdated.getText();
					 String review=textReviewed.getText();
					 String onset=textOnset.getText();
					 String comment=textComment.getText();
					String sql = "UPDATE ALLERGY SET Substance = '"+sub+"', Type = '"+selectedType+"', Category = '"+cat+"',  Severity = '"+selectedSeverity+"', Reactions = '"+react+"', Reaction_Status = '"+rStatus+"', Interaction = '"+selectedInteraction+"', Source = '"+selectedSource+"', Updated_Time = '"+updated+"', Reviewed_By = '"+review+"', Estimated_Onset = '"+onset+"', Comment = '"+comment+"'  WHERE patient_id ='" +lblPID.getText()+"'";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Inserted Successfully!");
				} 
				catch(Exception e) {System.out.print(e);}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNurse = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frmNurse, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton button_5 = new JButton("Clear");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textSubstance.setText(null);
				textCategory.setText(null);
				textReactions.setText(null);
				textRStatus.setText(null);
				textUpdated.setText(null);
				textReviewed.setText(null);
				textOnset.setText(null);
				textComment.setText(null);
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(193)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblReviewedBy)
						.addComponent(lblUpdatedTime)
						.addComponent(lblSource)
						.addComponent(lblInteraction)
						.addComponent(lblReactionStatus)
						.addComponent(lblReactions)
						.addComponent(lblSeverity)
						.addComponent(lblCategory)
						.addComponent(lblType)
						.addComponent(lblSubstance)
						.addComponent(lblEstimatedOnset)
						.addComponent(lblComment))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textUpdated, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textOnset, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboSeverity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboInteraction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboSource, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textReactions, 489, 489, 489)
						.addComponent(textComment, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(textReviewed, Alignment.LEADING)
							.addComponent(textRStatus, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(textCategory, Alignment.LEADING)
							.addComponent(textSubstance, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)))
					.addGap(186))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(69)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(261)
					.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 311, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(69))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSubstance)
						.addComponent(textSubstance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblType)
						.addComponent(comboType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategory)
						.addComponent(textCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSeverity)
						.addComponent(comboSeverity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblReactions)
						.addComponent(textReactions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReactionStatus)
						.addComponent(textRStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInteraction)
						.addComponent(comboInteraction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSource)
						.addComponent(comboSource, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUpdatedTime)
						.addComponent(textUpdated, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReviewedBy)
						.addComponent(textReviewed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textOnset, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEstimatedOnset))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textComment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblComment))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(51))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Vital Signs", null, panel_2, null);
		
		JLabel lblPulseRate = new JLabel("Pulse Rate:");
		lblPulseRate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textPulse = new JTextField();
		textPulse.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textPulse.setColumns(10);
		
		JLabel lblBeatsPerMinute = new JLabel("beats per minute");
		
		JLabel lblRhythm = new JLabel("Rhythm:");
		lblRhythm.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		final JComboBox comboRythm = new JComboBox();
		comboRythm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> comboRythm = (JComboBox<String>) e.getSource();
		        String selectedRythm = (String) comboRythm.getSelectedItem();
			}
		});
		comboRythm.setModel(new DefaultComboBoxModel(new String[] {"-choose", "Regular", "Arrhythmia", "Tachycardia", "Bradycardia"}));
		comboRythm.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textRythm = new JTextField();
		textRythm.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textRythm.setColumns(10);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure:");
		lblBloodPressure.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblSystolic = new JLabel("Systolic (90-119)");
		
		JLabel lblDiastolic = new JLabel("Diastolic (60-79)");
		
		textBP1 = new JTextField();
		textBP1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textBP1.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textBP2 = new JTextField();
		textBP2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textBP2.setColumns(10);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel = new JLabel("Position:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblLocation_1 = new JLabel("Location:");
		lblLocation_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		final JComboBox comboBPLocation = new JComboBox();
		comboBPLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> comboBPLocation = (JComboBox<String>) e.getSource();
		        String selectedBLoc = (String) comboBPLocation.getSelectedItem();
			}
		});
		comboBPLocation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBPLocation.setModel(new DefaultComboBoxModel(new String[] {"-choose", "Left Arm", "Right Arm"}));
		
		final JComboBox comboPLocation = new JComboBox();
		comboPLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> comboPLocation = (JComboBox<String>) e.getSource();
		        String selectedLoc = (String) comboPLocation.getSelectedItem();
			}
		});
		comboPLocation.setModel(new DefaultComboBoxModel(new String[] {"-choose", "Radial", "Carotid", "Femoral", "Pedal", "Brachial", "Apical"}));
		comboPLocation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		final JComboBox comboBPPosition = new JComboBox();
		comboBPPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> comboBPPostion = (JComboBox<String>) e.getSource();
		        String selectedBPos = (String) comboBPPosition.getSelectedItem();
			}
		});
		comboBPPosition.setModel(new DefaultComboBoxModel(new String[] {"-choose", "Sitting", "Standing", "Laying"}));
		comboBPPosition.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblRespitoryRate = new JLabel("Respiratory Rate:");
		lblRespitoryRate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textRespiratory = new JTextField();
		textRespiratory.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textRespiratory.setColumns(10);
		
		JLabel lblUnitType = new JLabel("Unit Type:");
		lblUnitType.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		final JRadioButton rdbtnUsStandard = new JRadioButton("U.S. Standard");
		
		final JRadioButton rdbtnMetric = new JRadioButton("Metric");
		
		JLabel lblTemperature = new JLabel("Temperature:");
		lblTemperature.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textTemp = new JTextField();
		textTemp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textTemp.setColumns(10);
		
		JLabel lblF = new JLabel("(92-103) F");
		
		JLabel lblLocation_2 = new JLabel("Location:");
		lblLocation_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		final JComboBox comboTempLocation = new JComboBox();
		comboTempLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> comboTempLocation = (JComboBox<String>) e.getSource();
		        String selectedTLoc = (String) comboTempLocation.getSelectedItem();
			}
		});
		comboTempLocation.setModel(new DefaultComboBoxModel(new String[] {"-choose", "Orally", "Rectally", "Axillary", "By Ear", "By Skin"}));
		comboTempLocation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textTempLocation = new JTextField();
		textTempLocation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textTempLocation.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textHeight = new JTextField();
		textHeight.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textHeight.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textWeight = new JTextField();
		textWeight.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textWeight.setColumns(10);
		
		JLabel lblInches = new JLabel("inches");
		
		JLabel lblPounds = new JLabel("pounds");
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://35.226.84.132:3306/EMR?user=root&password=password\";\r\n" + 
							"    			connection", "root", "password");
					 String pulse=textPulse.getText();
					 String selectedLoc = (String) comboPLocation.getSelectedItem();
					 String selectedRythm = (String) comboRythm.getSelectedItem();
					 String rythm=textRythm.getText();
					 String sys=textBP1.getText();
					 String dia=textBP2.getText();
					 String selectedBLoc = (String) comboBPLocation.getSelectedItem();
					 String selectedBPos = (String) comboBPPosition.getSelectedItem();
					 String respit=textRespiratory.getText();
					 String unit = null;
					 if(rdbtnUsStandard.isSelected())
					        unit="US Standard";
					else if(rdbtnMetric.isSelected()) 
					        unit="Metric";
					 String temp=textTemp.getText();
					 String selectedTLoc = (String) comboTempLocation.getSelectedItem();
					 String note=textTempLocation.getText();
					 String height=textHeight.getText();
					 String weight=textWeight.getText();
					String sql = "UPDATE VITALS SET Pulse_Rate = '"+pulse+"', Location_Pulse = '"+selectedLoc+"', Rythm_Type = '"+selectedRythm+"',  Rythm = '"+rythm+"', Systolic = '"+sys+"', Diastolic = '"+dia+"', BP_Location = '"+selectedBLoc+"', BP_Position = '"+selectedBPos+"', Respiratory_Rate = '"+respit+"', Temperature = '"+temp+"', Unit_Type = '"+unit+"', Temp_Location = '"+selectedTLoc+"', Temp_Note = '"+note+"', Height = '"+height+"', Weight = '"+weight+"'  WHERE patient_id ='" +lblPID.getText()+"'";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Inserted Successfully!");
				} 
				catch(Exception e1) {System.out.print(e1);}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton button_1 = new JButton("Exit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNurse = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frmNurse, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton button_6 = new JButton("Clear");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPulse.setText(null);
				textRythm.setText(null);
				textBP1.setText(null);
				textBP2.setText(null);
				textRespiratory.setText(null);
				textTemp.setText(null);
				textTempLocation.setText(null);
				textHeight.setText(null);
				textWeight.setText(null);
			}
		});
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(96)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblWeight)
						.addComponent(lblHeight)
						.addComponent(lblTemperature)
						.addComponent(lblRespitoryRate)
						.addComponent(lblBloodPressure)
						.addComponent(lblRhythm)
						.addComponent(lblPulseRate))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSystolic)
								.addComponent(comboRythm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textRythm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(67)
									.addComponent(lblDiastolic))))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(textBP1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textBP2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(textPulse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblBeatsPerMinute)))
							.addGap(18)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblLocation)
								.addComponent(lblLocation_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(comboBPLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBPPosition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(comboPLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(textRespiratory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblUnitType))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(textTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblF)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblLocation_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboTempLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textTempLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(rdbtnUsStandard)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnMetric))))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblInches))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(textWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPounds)))
					.addContainerGap(88, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(69)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(263)
					.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(69))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPulseRate)
						.addComponent(textPulse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBeatsPerMinute)
						.addComponent(lblLocation_1)
						.addComponent(comboPLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRhythm)
						.addComponent(comboRythm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textRythm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBloodPressure)
						.addComponent(lblSystolic)
						.addComponent(lblDiastolic))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(textBP1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(textBP2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLocation)
						.addComponent(comboBPLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(comboBPPosition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRespitoryRate)
						.addComponent(textRespiratory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUnitType)
						.addComponent(rdbtnUsStandard)
						.addComponent(rdbtnMetric))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTemperature)
						.addComponent(textTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblF)
						.addComponent(lblLocation_2)
						.addComponent(comboTempLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textTempLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHeight)
						.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInches))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWeight)
						.addComponent(textWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPounds))
					.addPreferredGap(ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(51))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Reason for Visit", null, panel_3, null);
		
		JLabel lblReasonForPatient = new JLabel("Reason for Patient Visit:");
		lblReasonForPatient.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		final JTextPane textPane_Reason = new JTextPane();
		textPane_Reason.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://35.226.84.132:3306/EMR?user=root&password=password\";\r\n" + 
							"    			connection", "root", "password");
					 String reason=textPane_Reason.getText();
					String sql = "UPDATE VISIT SET reason = '"+reason+"'  WHERE patient_id ='" +lblPID.getText()+"'";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Inserted Successfully!");
				} 
				catch(Exception e1) {System.out.print(e1);
				}
				}
		});
		btnUpdate_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton button_2 = new JButton("Exit");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNurse = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frmNurse, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton button_7 = new JButton("Clear");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane_Reason.setText(null);
			}
		});
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(210)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(textPane_Reason, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
						.addComponent(lblReasonForPatient))
					.addGap(207))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(69)
					.addComponent(btnUpdate_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
					.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(283)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(69))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(80)
					.addComponent(lblReasonForPatient)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textPane_Reason, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate_1)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(51))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Patient Questions/Concerns", null, panel_4, null);
		
		JLabel lblPatientQuestions = new JLabel("Patient Questions:");
		lblPatientQuestions.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		final JTextPane textPane_Questions = new JTextPane();
		textPane_Questions.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblPatientConcerns = new JLabel("Patient Concerns:");
		lblPatientConcerns.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		final JTextPane textPane_Concerns = new JTextPane();
		textPane_Concerns.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnUpdate_2 = new JButton("Update");
		btnUpdate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://35.226.84.132:3306/EMR?user=root&password=password\";\r\n" + 
							"    			connection", "root", "password");
					 String questions=textPane_Questions.getText();
					 String concerns=textPane_Concerns.getText();
					String sql = "UPDATE APPOINTMENT_DETAILS SET comments = '"+questions+"', comments = '"+concerns+"'  WHERE patient_id ='" +lblPID.getText()+"'";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Inserted Successfully!");
				} 
				catch(Exception e1) {System.out.print(e1);}
			}
		});
		btnUpdate_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton button_3 = new JButton("Exit");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNurse = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frmNurse, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton button_8 = new JButton("Clear");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane_Questions.setText(null);
				textPane_Concerns.setText(null);
			}
		});
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(69)
					.addComponent(btnUpdate_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(271)
					.addComponent(button_8, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 301, Short.MAX_VALUE)
					.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(69))
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(162)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblPatientQuestions)
							.addContainerGap())
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(lblPatientConcerns)
								.addContainerGap())
							.addGroup(gl_panel_4.createSequentialGroup()
								.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
									.addComponent(textPane_Concerns, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
									.addComponent(textPane_Questions, GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
								.addGap(182)))))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(88)
					.addComponent(lblPatientQuestions)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textPane_Questions, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(lblPatientConcerns)
					.addGap(18)
					.addComponent(textPane_Concerns, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate_2)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_8, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(51))
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Patient Education", null, panel_5, null);
		
		JLabel lblPleaseSelectThe = new JLabel("Please select the education information needed for the patient:");
		lblPleaseSelectThe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		final JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"-choose", "-A-", "Acute Bronchitis", "After Surgery Care", "Alcoholism/Substance Abuse", "Allergies", "Alzheimers Disease", "Anal Disorders", "Anemia", "Angina", "Angioplasty", "Animal Bites", "Ankle Injuries", "Appendicitis", "Arm Injuries", "Arrhytmia", "Arthritis", "Asthma", "Atrial Fibrillation", "-B-", "Back Injuries", "Bacterial Infections", "Bile Duct Disease", "Biodefense", "Biopsy", "Bladder Diseases", "Body Weight", "Bone Cancer", "Bone Marrow Diseases", "Brain Diseases", "Breast Cancer", "Breathing Problems", "Burns", "-C-", "Cancer", "Cancer Chemotherapy", "Cancer-Living With", "Cataract", "Cervical Cancer", "Cesarean Section", "Child Abuse", "Cholesterol", "Chronic Kidney Disease", "Colonoscopy", "Colorectal Cancer", "Concussion", "Constipation", "COPD", "Coronary Artery Bypass", "Chron's Disease", "CT Scans", "-D-", "Deep Vein Thrombosis", "Dementia", "Depression", "Diabetes", "Diarrhea", "Digestive Diseases", "Dislocations", "Diverticulitis", "Drug Reactions", "-E-", "Ear Infections", "Edema", "Esophagus Disorders", "Excercise", "Eye Diseases", "Eye Injuries", "-F-", "Facial Injuries", "Falls", "Fatigue", "Fever", "First Aid", "Flu", "Flu Shot", "Fractures", "-G-", "Gallstones", "Gastrointestinal Bleeding", "Germs", "Glaucoma", "-H-", "Headache", "Health Screening", "Healthy Sleep", "Hearing Disorders", "Heart Attack", "Heart Disease", "Heart Failure", "Hepatitis", "Hep A", "Hep B", "High Blood Pressure", "Hip Injuries", "Hip Replacement", "HPV", "Hyperglycemia", "Hypoglycemia", "Hysterectomy", "-I-", "Immunizations", "Insect Bites", "Irritable Bowel Syndrome", "-J-", "Joint Disorders", "-K-", "Kidney Diseases", "Kidney Failure", "Kidney Stones", "Knee Replacement", "-L-", "Lab Tests", "Leg Injuries", "Lung Cancer", "Lung Diseases", "-M-", "Mammography", "Measles", "Medical Device Safety", "Melanoma", "Meningitis", "Meningococcal Infections", "Menopause", "Mental Disorders", "Mental Health", "MRI Scans", "MRSA", "-N-", "Nausea", "Neurologic Diseases", "Neuromuscular Disorders", "Nuclear Scans", "Nutrition", "-O-", "Osteoporosis", "-P-", "Pacemakers", "Pain", "Pain Relievers", "Parasitic Diseases", "Parathyroid Disorders", "Parkinson's Disease", "Peripheral Arterial Disease", "Pnemonia", "Polio", "Pregnancy", "Prenatal Care", "Prostate Cancer", "-Q-", "Quitting Smoking", "-R-", "Radiation Emergencies", "Radiation Therapy", "Rotavirus Infections", "-S-", "Seizures", "Sexually Transmitted Diseases", "Shingles", "Skin Cancer", "Skin Infections", "Sleep Apnea", "Sore Throat", "Spinal Cord Diseases", "Strep Infections", "Stress", "Stroke", "Suicide", "Surgery", "Swallowing Disorders", "-T-", "Testicular Cancer", "Thyroid Cancer", "Thyroid Tests", "Tick Bites", "Tooth Disorders", "Tuberculosis", "-U-", "Ulcerative Colitis", "Ultrasound", "Urinary Tract Infection", "-V-", "Vaginal Diseases", "-W-", "Wounds", "-X-", "X-rays"}));
		comboBox_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnSelect_1 = new JButton("Select");
		btnSelect_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cb = comboBox_9.getSelectedIndex();
				if (cb == 2)
				{
					try {
						
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Bronchitis_Fr.pdf"));
						
					}
					
					catch (Exception e1){
						e1.printStackTrace();
					}

				}
				
				if (cb == 3)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/HomeCare_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 4)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/SubstanceAbuse_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 5)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Allergies_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 6)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Alzheimers_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 7)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/BariumEnema_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 8)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Anemia_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 9)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Angina_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 10)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/HeartCathAngioplasty_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 11)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/AnimalBitesScratches_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 12)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/AnkleSprain_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 13)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Appendectomy_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 14)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/ActiveROM-WEFS_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 15)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/EPS_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 16)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Arthritis_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 17)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Asthma_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 18)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Atrial_Fibrillation_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 20)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/BackHealthSafety_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 21)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("http://www.immunize.org/vis/french_ppsv.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 22)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/ERCP_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 23)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Biological_Emergencies_AFr_final.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 24)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Biopsy_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 25)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/IVP_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 26)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/WaysManageWt_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 27)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/BoneScan_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 28)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/BoneMarrowBiopsy_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 29)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/BrainScan_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 30)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/BreastBiopsy_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 31)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/IncentiveSpirometer_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 32)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/BurnCare_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 34)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Cancer_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 35)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Chemotherapy_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 36)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.cancer.org/content/dam/cancer-org/cancer-control/fr/booklets-flyers/about-cancer-pain-french.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 37)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Cataract-Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 38)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/LEEP_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 39)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/070790_Your_Recovery_After_Cesarean_Birth-Fin.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 40)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://healthreach.nlm.nih.gov/files/French_ViolenceInTheHome_Final.pdf?_ga=2.200279469.282006636.1529652548-1402223836.1527665456"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 41)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Cholesterol_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 42)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Kidney_Failure_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 43)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/ColonoscopyPrep_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 44)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Cancer_Colon_Rectum_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 45)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/TypesBrainInjury_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 46)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Constipation_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 47)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/COPD_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 48)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/CABS_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 49)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/CrohnsDisease_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 50)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/CTScan_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 52)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/DVT_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 53)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/TypesDementia_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 54)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/FeelingSad_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 55)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Diabetes_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 56)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Diarrhea_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 57)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/EGD_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 58)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/WearingShoulderSling_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 59)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Diverticulitis_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 60)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/TakingMedsSafely_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 62)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/MiddleEarInfection_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 63)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/LimitingFluids_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 64)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/BariumSwallow_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 65)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/StartingExerciseProgram_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 66)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/DiabeticRetinopathy_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 67)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Retinal_Detachment-Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 69)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/FacialStengthening_Fre.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 70)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/fall-prevent-home_Fre.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 71)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.cancer.org/content/dam/cancer-org/cancer-control/fr/booklets-flyers/fatigue-french.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 72)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/TakingTemp_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 73)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.fema.gov/media-library-data/1391109638897-8b94bc73b1be4b9cbe4ada06f7bfa25f/2014_checklist_fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 74)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/HomeCarePandemicFlu_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 75)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("http://www.immunize.org/vis/french_flu_inactive.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 76)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/BoneFractures_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				

				if (cb == 78)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/GallBladder_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 79)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/HemoccultTest_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 80)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/HandWashing_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 81)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Glaucoma_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 83)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Headaches_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 84)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.cancer.org/content/dam/cancer-org/cancer-control/fr/booklets-flyers/american-cancer-society-guidelines-for-the-early-detection-of-cancer-french.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 85)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Common_Sleep_Problems_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 86)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/HearingLoss_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 87)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/HeartAttack_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 88)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/StressTest_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 89)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/HeartFailure_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 90)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/ViralHepatitis_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 91)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("http://www.immunize.org/vis/french_hepatitis_a.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 92)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.cdc.gov/hepatitis/hbv/pdfs/HepBAtRisk-Africa_fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 93)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/HighBP_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 94)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Pelvic_Fracture_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 95)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/TotalHipReplacement_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 96)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("http://www.immunize.org/vis/french_hpv.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 97)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/HighBloodSugar_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 98)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/LowBloodSugar_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 99)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Hysterectomy_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 101)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("http://www.immunize.org/catg.d/p4030-10.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 102)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("http://www.healthvermont.gov/sites/default/files/documents/pdf/Mosquito_bite_prev_flyer_French.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 103)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/IBS_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 105)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/HomeCareTotalJoint_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 107)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/IVP_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 108)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Kidney_Failure_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 109)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/IVP_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 110)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/TotalKneeReplacement_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 112)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.cancer.org/content/dam/cancer-org/cancer-control/fr/booklets-flyers/your-lab-tests-french.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 113)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/ActiveLegROM_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 114)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Lung_Cancer_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 115)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Bronchoscopy_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 117)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Mammogram_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 118)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("http://www.immunize.org/vis/french_mmr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 119)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/ThrowingAwaySyringes_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 120)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/MelanomaExam_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 121)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("http://www.immunize.org/vis/french_ppsv.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 122)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("http://www.immunize.org/vis/french_meningococcal.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 123)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Managing_Menopause_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 124)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://healthreach.nlm.nih.gov/files/French_WhatIsMentalDistress_UTTRevised.pdf?_ga=2.132596109.282006636.1529652548-1402223836.1527665456"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 125)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://healthreach.nlm.nih.gov/files/French_HowToHelpSomeoneThinkingOfSuicide.pdf?_ga=2.203950099.282006636.1529652548-1402223836.1527665456"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 126)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/MRI_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 127)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/MRSA_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 129)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.cancer.org/content/dam/cancer-org/cancer-control/fr/booklets-flyers/nausea-and-vomiting-french.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 130)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/EEG_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 131)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/EMG_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 132)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/PETScan_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 133)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("http://refugees.org/wp-content/uploads/2015/12/Nutrition-Resources-French.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 135)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Osteoporosis_fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 137)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Pacemaker_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 138)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/AboutYourPain_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 139)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/PCA_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 140)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/StoolTestOP_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 141)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/HighBloodCalcium_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 142)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/ParkinsonsDisease_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 143)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/BloodVesselDisease_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 144)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Pneumonia_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 145)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("http://www.immunize.org/vis/french_polio_ipv.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 146)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/AHealthyPregnancy_fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 147)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/PrenatalCare_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 148)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/ProstateCancer_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}

				if (cb == 150)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/HowQuitSmoking_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 152)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Nuclear_Radiation_Emergencies_AFr_final.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 153)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/RadiationTherapy_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 154)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("http://www.immunize.org/vis/french_rotavirus.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 156)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Seizures_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 157)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/STDs_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 158)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("http://www.immunize.org/vis/french_zoster_live.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 159)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/SkinCancer_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 160)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Boils_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 161)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/CPAP_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 162)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/SoreThroat_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 163)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Myelogram_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 164)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/StrepThroat_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 165)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/CopingStress_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 166)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Stroke_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 167)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://healthreach.nlm.nih.gov/files/French_HowToHelpSomeoneThinkingOfSuicide.pdf?_ga=2.127340046.282006636.1529652548-1402223836.1527665456"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 168)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/PreparingSurgery_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 169)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/SwallowingProblems_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 171)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/TesticularSelfExam_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 172)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/ThyroidBiopsy_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 173)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/ThyroidScan_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 174)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("http://www.healthvermont.gov/sites/default/files/documents/pdf/Tick_Flyer_French.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 175)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Toothache_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 176)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Tuberculosis_fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 178)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/UlcerativeColitis_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 179)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Ultrasound_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 180)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/UTI_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 182)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/Vaginal_Infection_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 184)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/IncisionCare_FR.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				if (cb == 186)
				{
					try {
						Desktop d = Desktop.getDesktop();
						d.browse(new URI("https://www.healthinfotranslations.org/pdfDocs/HavingXray_Fr.pdf"));
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		btnSelect_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton button_4 = new JButton("Exit");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNurse = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frmNurse, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_5.createSequentialGroup()
					.addGap(69)
					.addComponent(btnSelect_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 665, Short.MAX_VALUE)
					.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(69))
				.addGroup(Alignment.LEADING, gl_panel_5.createSequentialGroup()
					.addGap(63)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPleaseSelectThe))
					.addContainerGap(479, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(41)
					.addComponent(lblPleaseSelectThe)
					.addGap(18)
					.addComponent(comboBox_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 491, Short.MAX_VALUE)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSelect_1)
						.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(51))
		);
		panel_5.setLayout(gl_panel_5);
		contentPane.setLayout(gl_contentPane);
	}
}
