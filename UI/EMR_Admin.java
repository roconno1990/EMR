package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import base.DBBase;
import base.DBConnect;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EMR_Admin {

	private JFrame frmAdmin;
	private JTextField textFName;
	private JTextField textLName;
	private JTextField textEID;
	private JTextField textCName;
	private JTextField textAddress;
	private JTextField textSSN;
	private JTextField textDOB;
	private JTextField textEmail;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textNPI;
	private JTextField textLNum;
	private JTextField textField_12;
	private JTextField dob;
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
					EMR_Admin window = new EMR_Admin();
					window.frmAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EMR_Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdmin = new JFrame();
		frmAdmin.setTitle("Admin");
		frmAdmin.setBounds(100, 100, 835, 689);
		frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdmin.getContentPane().setLayout(null);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		con = new DBConnect();
		data = new DBBase();
		con.initialise("root", "password");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 13, 793, 616);
		frmAdmin.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Admin", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblSearchUser = new JLabel("Enter Name:");
		lblSearchUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchUser.setBounds(30, 51, 100, 16);
		panel_1.add(lblSearchUser);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_12.setBounds(138, 49, 302, 22);
		panel_1.add(textField_12);
		textField_12.setColumns(10);

		ResultSet rs = data.query(con.getConnection(), "user", Collections.emptyMap());
		try
		{
			table = new JTable(data.fitToTable(rs));
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(52, 135, 678, 270);
			scrollPane.setHorizontalScrollBarPolicy(
	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setVerticalScrollBarPolicy(
	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			panel_1.add(scrollPane);
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}

		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setBounds(450, 47, 127, 25);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String searchText = textField_12.getText();

				if( !searchText.equals("") )
				{
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("username", searchText);

					ResultSet rs = data.partialQuery(con.getConnection(), "user", map);
					try
					{
						DefaultTableModel model = data.fitToTable(rs);
						model.fireTableDataChanged();
						table.setModel(model);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
			
		});
		panel_1.add(btnSearch);

		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBounds(590, 47, 127, 25);
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textField_12.setText("");
				
				ResultSet rs = data.query(con.getConnection(), "user", Collections.emptyMap());
				try
				{
					DefaultTableModel model = data.fitToTable(rs);
					model.fireTableDataChanged();
					table.setModel(model);
				}
				catch( SQLException e )
				{
					e.printStackTrace();
				}
			}
			
		});
		panel_1.add(btnClear);

		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBounds(52, 432, 127, 25);
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frmAddUser = new JFrame();
				frmAddUser.setTitle("Add User");
				frmAddUser.setBounds(100, 100, 835, 689);
				frmAddUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frmAddUser.getContentPane().setLayout(null);
				frmAddUser.setVisible(true);
				
				JTabbedPane tabbedPane1 = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane1.setBounds(12, 13, 793, 616);
				frmAddUser.getContentPane().add(tabbedPane1);
				
				JPanel panel = new JPanel();
				tabbedPane1.addTab("Add User", null, panel, null);
				panel.setLayout(null);
				
				JLabel label = new JLabel("First Name:");
				label.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label.setBounds(95, 54, 100, 16);
				panel.add(label);

				textFName = new JTextField();
				textFName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textFName.setColumns(10);
				textFName.setBounds(205, 51, 251, 22);
				panel.add(textFName);
				
				JLabel label_1 = new JLabel("Last Name:");
				label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label_1.setBounds(95, 89, 100, 16);
				panel.add(label_1);
				
				textLName = new JTextField();
				textLName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textLName.setColumns(10);
				textLName.setBounds(205, 86, 251, 22);
				panel.add(textLName);
				
				JLabel label_2 = new JLabel("Employee ID:");
				label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label_2.setBounds(85, 124, 100, 16);
				panel.add(label_2);
				
				textEID = new JTextField();
				textEID.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textEID.setColumns(10);
				textEID.setBounds(205, 121, 251, 22);
				panel.add(textEID);
				
				JLabel label_4 = new JLabel("Address:");
				label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label_4.setBounds(115, 160, 100, 16);
				panel.add(label_4);
				
				textAddress = new JTextField();
				textAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textAddress.setColumns(10);
				textAddress.setBounds(205, 159, 500, 22);
				panel.add(textAddress);

				JLabel label_5 = new JLabel("DOB:");
				label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label_5.setBounds(135, 200, 100, 16);
				panel.add(label_5);

				dob = new JTextField();
				dob.setFont(new Font("Tahoma", Font.PLAIN, 15));
				dob.setColumns(10);
				dob.setBounds(205, 197, 251, 22);
				panel.add(dob);
				
				JLabel label_8 = new JLabel("Username:");
				label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label_8.setBounds(100, 237, 100, 16);
				panel.add(label_8);

				textUsername = new JTextField();
				textUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textUsername.setColumns(10);
				textUsername.setBounds(205, 235, 251, 22);
				panel.add(textUsername);
				
				JLabel label_9 = new JLabel("Password:");
				label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label_9.setBounds(105, 270, 100, 16);
				panel.add(label_9);
				
				textPassword = new JTextField();
				textPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textPassword.setColumns(10);
				textPassword.setBounds(205, 268, 251, 22);
				panel.add(textPassword);
				
				JLabel lblTitle = new JLabel("Role:");
				lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblTitle.setBounds(145, 25, 50, 16);
				panel.add(lblTitle);
				
				JComboBox<String> comboBox = new JComboBox<>();
				comboBox.addItem("REGISTRATION");
				comboBox.addItem("PHYSICIAN");
				comboBox.addItem("NURSE");
				comboBox.addItem("ADMIN");
				comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
				comboBox.setBounds(205, 23, 251, 22);
				panel.add(comboBox);
				
				JButton btnAddupdateUser = new JButton("Add User");
				btnAddupdateUser.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnAddupdateUser.setBounds(287, 498, 169, 25);
				btnAddupdateUser.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String fName = textFName.getText();
						String lName = textLName.getText();
						String eid = textEID.getText();
						String addr = textAddress.getText();
						String dateOfBirth = dob.getText();
						String usrName = textUsername.getText();
						String password = textPassword.getText();
						String role = (String) comboBox.getSelectedItem();
						
						String errorField = "";
						if( eid.equals("") )
						{
							errorField = "Employee ID";
						}
						else if( role.equals("") )
						{
							errorField = "Role";
						}
						else if( usrName.equals("") )
						{
							errorField = "Username";
						}
						else if( password.equals("") )
						{
							errorField = "password";
						}
						else if( fName.equals("") )
						{
							errorField = "First Name";
						}
						else if( lName.equals("") )
						{
							errorField  = "Last Name";
						}
						
						if( !errorField.equals("") )
						{
							String errorText = "The field " + errorField + " is required!";
							JOptionPane.showMessageDialog(frmAdmin, errorText);
						}
						else
						{
							Map<String, Object> userMap = new HashMap<String, Object>();
							userMap.put("user_id", eid);
							userMap.put("username", usrName);
							userMap.put("password", password);
							userMap.put("dob", dateOfBirth);
							userMap.put("role", role);
							userMap.put("locked", "N");
							data.insert(con.getConnection(), "user", userMap);
							
							Map<String, Object> userInfoMap = new HashMap<String, Object>();
							userInfoMap.put("user_id", eid);
							userInfoMap.put("firstName", fName);
							userInfoMap.put("lastName", lName);
							userInfoMap.put("address", addr);
							data.insert(con.getConnection(), "user_info", userInfoMap);
							
							ResultSet rs = data.query(con.getConnection(), "user", Collections.emptyMap());
							try
							{
								DefaultTableModel model = data.fitToTable(rs);
								model.fireTableDataChanged();
								table.setModel(model);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
							textFName.setText("");
							textLName.setText("");
							textEID.setText("");
							textAddress.setText("");
							textUsername.setText("");
							textPassword.setText("");
							dob.setText("");
						}
					}
					
				});
				panel.add(btnAddupdateUser);
				
				JButton button_5 = new JButton("Clear");
				button_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						textFName.setText("");
						textLName.setText("");
						textEID.setText("");
						textAddress.setText("");
						textUsername.setText("");
						textPassword.setText("");
						dob.setText("");
					}
				});
				button_5.setFont(new Font("Tahoma", Font.BOLD, 15));
				button_5.setBounds(287, 548, 169, 25);
				panel.add(button_5);
				
			}
			
		});
		panel_1.add(btnAdd);

		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEdit.setBounds(192, 432, 127, 25);
		panel_1.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame frmAddUser = new JFrame();
				frmAddUser.setTitle("Edit User");
				frmAddUser.setBounds(100, 100, 835, 689);
				frmAddUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frmAddUser.getContentPane().setLayout(null);
				frmAddUser.setVisible(true);
				
				JTabbedPane tabbedPane1 = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane1.setBounds(12, 13, 793, 616);
				frmAddUser.getContentPane().add(tabbedPane1);
				
				JPanel panel = new JPanel();
				tabbedPane1.addTab("Edit User", null, panel, null);
				panel.setLayout(null);

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int[] rows = table.getSelectedRows(); 
				String userID = model.getValueAt(rows[0], 0).toString();

				Map<String, Object> keyMap = new HashMap<String, Object>();
				keyMap.put("user_id", userID);
				List<Map<String, Object>> userRow = new ArrayList<Map<String, Object>>();
				userRow = data.retrieve(con.getConnection(), "user", keyMap);
				List<Map<String, Object>> userInfoRow = new ArrayList<Map<String, Object>>();
				userInfoRow = data.retrieve(con.getConnection(), "user_info", keyMap);
				
				JLabel label = new JLabel("First Name:");
				label.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label.setBounds(95, 54, 100, 16);
				panel.add(label);

				textFName = new JTextField();
				textFName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textFName.setColumns(10);
				textFName.setBounds(205, 51, 251, 22);
				textFName.setText(data.getStringField(userInfoRow, "firstName"));
				panel.add(textFName);
				
				JLabel label_1 = new JLabel("Last Name:");
				label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label_1.setBounds(95, 89, 100, 16);
				panel.add(label_1);
				
				textLName = new JTextField();
				textLName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textLName.setColumns(10);
				textLName.setBounds(205, 86, 251, 22);
				textLName.setText(data.getStringField(userInfoRow, "lastName"));
				panel.add(textLName);
				
				JLabel label_2 = new JLabel("Employee ID:");
				label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label_2.setBounds(85, 124, 100, 16);
				panel.add(label_2);
				
				textEID = new JTextField();
				textEID.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textEID.setColumns(10);
				textEID.setBounds(205, 121, 251, 22);
				textEID.setText(data.getIntegerField(userRow, "user_id").toString());
				panel.add(textEID);
				
				JLabel label_4 = new JLabel("Address:");
				label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label_4.setBounds(115, 160, 100, 16);
				panel.add(label_4);
				
				textAddress = new JTextField();
				textAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textAddress.setColumns(10);
				textAddress.setBounds(205, 159, 500, 22);
				textAddress.setText(data.getStringField(userInfoRow, "address"));
				panel.add(textAddress);

				JLabel label_5 = new JLabel("DOB:");
				label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label_5.setBounds(135, 200, 100, 16);
				panel.add(label_5);

				dob = new JTextField();
				dob.setFont(new Font("Tahoma", Font.PLAIN, 15));
				dob.setColumns(10);
				dob.setBounds(205, 197, 251, 22);
				dob.setText(data.getStringField(userRow, "DOB"));
				panel.add(dob);
				
				JLabel label_8 = new JLabel("Username:");
				label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label_8.setBounds(100, 237, 100, 16);
				panel.add(label_8);

				textUsername = new JTextField();
				textUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textUsername.setColumns(10);
				textUsername.setBounds(205, 235, 251, 22);
				textUsername.setText(data.getStringField(userRow, "username"));
				panel.add(textUsername);
				
				JLabel label_9 = new JLabel("Password:");
				label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label_9.setBounds(105, 270, 100, 16);
				panel.add(label_9);
				
				textPassword = new JTextField();
				textPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textPassword.setColumns(10);
				textPassword.setBounds(205, 268, 251, 22);
				textPassword.setText(data.getStringField(userRow, "password"));
				panel.add(textPassword);
				
				JLabel lblTitle = new JLabel("Role:");
				lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblTitle.setBounds(145, 25, 50, 16);
				panel.add(lblTitle);
				
				JComboBox<String> comboBox = new JComboBox<>();
				comboBox.addItem("REGISTRATION");
				comboBox.addItem("PHYSICIAN");
				comboBox.addItem("NURSE");
				comboBox.addItem("ADMIN");
				comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
				comboBox.setBounds(205, 23, 251, 22);
				comboBox.setSelectedItem(data.getStringField(userRow, "role"));
				panel.add(comboBox);
				
				JButton btnUpdateUser = new JButton("Modify User");
				btnUpdateUser.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnUpdateUser.setBounds(287, 498, 169, 25);
				btnUpdateUser.addActionListener( new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {

						DefaultTableModel model = (DefaultTableModel) table.getModel();
						for( int i = 0; i < rows.length; i++ )
						{
							String userID = model.getValueAt(rows[i], 0).toString();
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("user_id", userID);

							Map<String, Object> updateUserFields = new HashMap<String, Object>();
							updateUserFields.put("username", textUsername.getText());
							updateUserFields.put("password", textPassword.getText());
							updateUserFields.put("role", comboBox.getSelectedItem().toString());
							updateUserFields.put("DOB", dob.getText());
							data.update(con.getConnection(), "user", map, updateUserFields);

							Map<String, Object> updateUserInfoFields = new HashMap<String, Object>();
							updateUserInfoFields.put("firstName", textFName.getText());
							updateUserInfoFields.put("lastName", textLName.getText());
							updateUserInfoFields.put("address", textAddress.getText());
							data.update(con.getConnection(), "user_info", map, updateUserInfoFields);
							
							ResultSet rs = data.query(con.getConnection(), "user", Collections.emptyMap());
							try
							{
								model = data.fitToTable(rs);
								model.fireTableDataChanged();
								table.setModel(model);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
					} 
					
				});
				panel.add(btnUpdateUser);
				
				JButton button_5 = new JButton("Clear");
				button_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						textFName.setText("");
						textLName.setText("");
						textEID.setText("");
						textAddress.setText("");
						textUsername.setText("");
						textPassword.setText("");
						dob.setText("");
					}
				});
				button_5.setFont(new Font("Tahoma", Font.BOLD, 15));
				button_5.setBounds(287, 548, 169, 25);
				panel.add(button_5);
			}
		});
		
		JButton btnLockUser = new JButton("Lock");
		btnLockUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLockUser.setBounds(332, 432, 127, 25);
		btnLockUser.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int[] rows = table.getSelectedRows(); 

				for( int i = 0; i < rows.length; i++ )
				{
					String userID = model.getValueAt(rows[i], 0).toString();
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("user_id", userID);

					Map<String, Object> updateFields = new HashMap<String, Object>();
					updateFields.put("locked", "Y");
					data.update(con.getConnection(), "user", map, updateFields);
					
					ResultSet rs = data.query(con.getConnection(), "user", Collections.emptyMap());
					try
					{
						model = data.fitToTable(rs);
						model.fireTableDataChanged();
						table.setModel(model);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		panel_1.add(btnLockUser);
		
		JButton btnUnlockUser = new JButton("Unlock");
		btnUnlockUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUnlockUser.setBounds(472, 432, 127, 25);
		btnUnlockUser.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int[] rows = table.getSelectedRows(); 

				for( int i = 0; i < rows.length; i++ )
				{
					String userID = model.getValueAt(rows[i], 0).toString();
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("user_id", userID);

					Map<String, Object> updateFields = new HashMap<String, Object>();
					updateFields.put("locked", "N");
					data.update(con.getConnection(), "user", map, updateFields);
					
					ResultSet rs = data.query(con.getConnection(), "user", Collections.emptyMap());
					try
					{
						model = data.fitToTable(rs);
						model.fireTableDataChanged();
						table.setModel(model);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		panel_1.add(btnUnlockUser);
		
		JButton btnDeleteUser = new JButton("Delete");
		btnDeleteUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeleteUser.setBounds(612, 432, 127, 25);
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int[] rows = table.getSelectedRows(); 

				for( int i = 0; i < rows.length; i++ )
				{
					String userID = model.getValueAt(rows[i], 0).toString();
					Map<String, Object> delMap = new HashMap<String, Object>();
					delMap.put("user_id", userID);
					data.delete(con.getConnection(), "user_info", delMap);
					data.delete(con.getConnection(), "user", delMap);
					
					ResultSet rs = data.query(con.getConnection(), "user", Collections.emptyMap());
					try
					{
						model = data.fitToTable(rs);
						model.fireTableDataChanged();
						table.setModel(model);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		panel_1.add(btnDeleteUser);
		
		JButton button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmAdmin = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frmAdmin, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(612, 550, 127, 25);
		panel_1.add(button);
	}
}
