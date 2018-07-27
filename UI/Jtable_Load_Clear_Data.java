package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swt.LoadPatients;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import java.awt.Font;

import net.proteanit.sql.DbUtils;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;




public class Jtable_Load_Clear_Data {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblMyPatients;
	

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jtable_Load_Clear_Data window = new Jtable_Load_Clear_Data();
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
	public Jtable_Load_Clear_Data() {
		initialize();
		ShowData();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void ShowData()
	{
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String[] cols = {"MRN", "First Name", "Last Name", "DOB","Reason for Visit"};
		String[][] data = {
				
								{"1","Triumfia","Fulks","01-02-2012", "Nosea"},
								{"2","Felicia","Pounds","02-03-2015", "Migranes"},
								{"3","Ryan","Oconor","03-04-2010", "Broken leg"},
								{"4","Joshua","Chambers","04-05-2005", "Broken Hips"},
								
									};
		
		model.setDataVector(data, cols);
		
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 788, 531);
		
		JButton btnNewButtonLoad = new JButton("Load");
		/*   // Possible loadfrom the database 
		btnNewButtonLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Connection con = null;
				try {
					con = DriverManager.getConnection("jdbc:mysql://35.226.84.132:3306/EMR?user=root&password=password\";\r\n" + 
							"    			connection", "root", "password");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Statement stmt = null;
				try {
					stmt = (Statement) con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String sql = "Select patient_id, first_name, last_name, DOB from PATIENT";
				ResultSet rs = null;
				try {
					rs = ((java.sql.Statement) stmt).executeQuery(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.setModel (DbUtils.resultSetToTableModel(rs));

				
				
				
				
			}
		});
		
		*/
		btnNewButtonLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowData();
			}
		}); 
		
		scrollPane = new JScrollPane();
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
								LoadPatients nw = new LoadPatients();
								nw.NewScreen();
							
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButtonClear = new JButton("Clear");
		btnNewButtonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel(null, new String[]{"id", "First Name", "Last Name", "Age"}));
			}
		});
		
		lblMyPatients = new JLabel("My Patients");
		lblMyPatients.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(369)
					.addComponent(lblMyPatients, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButtonLoad, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButtonClear, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
					.addGap(65))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(lblMyPatients, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(105)
							.addComponent(btnNewButtonLoad)
							.addGap(39)
							.addComponent(btnNewButtonClear))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
					.addGap(124))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		JButton btnChart = new JButton("Chart");
		
	}

//	public void NewScreen() {
		// TODO Auto-generated method stub
		
	}
//}



