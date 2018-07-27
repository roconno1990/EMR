package UI;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.AbstractListModel;


public class List {

	private JFrame frame;
	private JList list;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List window = new List();
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
	public List() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 782, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLoadValues = new JButton("Load Values");
		btnLoadValues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel DLM=new DefaultListModel();
				DLM.addElement("MRN                                    First Name                    	       Last Name                                      Visit Reason");
				DLM.addElement("01                                      Triumfia                                 Fulks                                                    Migranes");
				DLM.addElement("02                                       Felicia                                 Pounds                                                  Back Pain");
				DLM.addElement("03                                       Joshua                                  Chambers                                                     Clot");
				DLM.addElement("04                                       Ryan                                     O'Connor                                                      	 Flu");
				list.setModel(DLM);
				
				
			}
		});
		btnLoadValues.setBounds(309, 105, 160, 23);
		frame.getContentPane().add(btnLoadValues);
		
		list = new JList();
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(90, 159, 666, 146);
		frame.getContentPane().add(list);
	}
}
