package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import UI.EMR;
import base.DBBase;
import base.DBConnect;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login_S {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JFrame frmLoginSystem;
	int attempts = 3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_S window = new Login_S();
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
	public Login_S() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 300, 711, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLoginTitle = new JLabel("EMR Login System");
		lblLoginTitle.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLoginTitle.setBounds(275, 13, 205, 43);
		frame.getContentPane().add(lblLoginTitle);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(138, 138, 74, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(138, 229, 74, 16);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUsername.setBounds(291, 136, 265, 22);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setBounds(291, 227, 265, 22);
		frame.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DBConnect con = new DBConnect();
				DBBase data = new DBBase();
				String password = txtPassword.getText();	
				String username = txtUsername.getText();
				boolean success = con.initialise("root", "password");
				
				while (attempts!=0)
				{
					Map<String, Object> keyMap = new HashMap<String, Object>();
					keyMap.put("username", username);
					List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
					rows = data.retrieve(con.getConnection(), "user", keyMap);
					String pass = data.getStringField(rows, "password");
					String role = data.getStringField(rows, "role");

					if (rows.size() > 0 &&
						pass.equals(password) ) {
						
						txtPassword.setText(null);
						txtUsername.setText(null);
						
						switch(role)
						{
							case "NURSE":
								EMR_Nurse info = new EMR_Nurse();
								EMR_Nurse.main(null);
								break;
							case "PHYSICIAN":
								Physi physician = new Physi();
								physician.open();
								Physi.main(null);
								break;
							case "ADMIN":
								EMR_Admin adminInfo = new EMR_Admin();
								EMR_Admin.main(null);
								break;
							case "REGISTRATION":
								Registration regInfo = new Registration();
								Registration.main(null);
								break;
						    default:
						    	JOptionPane.showMessageDialog(null, "Invalid User Setup", "User Login Error", JOptionPane.ERROR_MESSAGE);
						    	break;
						}
						
					}
					
					else
					{
						attempts--; 
						JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
						txtPassword.setText(null);
						txtUsername.setText(null);
					}
					return;
				}
				if (attempts==0)
				{
					JOptionPane.showMessageDialog(frame, "Too Many Failed Attempts");
					System.exit(0);
				}
				con.closeConnection();
		}});
		btnLogin.setBounds(101, 365, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtUsername.setText(null);
				txtPassword.setText(null);
				
			}
		});
		btnReset.setBounds(301, 365, 97, 25);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmLoginSystem = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(495, 365, 97, 25);
		frame.getContentPane().add(btnExit);
	}
}
